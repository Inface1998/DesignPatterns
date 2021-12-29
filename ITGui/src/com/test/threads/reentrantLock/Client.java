package com.test.threads.reentrantLock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Client {
    private int number = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final Condition condition = writeLock.newCondition();
    // 标志是否写入完成
    private boolean writeComplete = false;

    private void read() {
        readLock.lock();
        // 如果还没有写入完成，循环等待直到写入完成
        while (!writeComplete) {
            // 等待，并且不要阻塞写入
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("number = " + number);
        readLock.unlock();
    }

    private void write(int change) {
        writeLock.lock();
        number += change;
        System.out.println("写入 " + number);
        writeLock.unlock();
    }

    @Test
    public void test() throws InterruptedException {
        // 开启一个线程写入 100 次 number
        new Thread(() -> {
            writeComplete = false;
            for (int i = 0; i < 100; i++) {
                write(1);
            }
            writeComplete = true;
            // 写入完成，唤醒读取线程，await/signal 操作必须在 lock 时执行。
            writeLock.lock();
            condition.signal();
            writeLock.unlock();
        }).start();

        // 开启一个线程读取 100 次 number
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                read();
            }
        }).start();

        // 睡眠一秒保证线程执行完成
        Thread.sleep(1000);
    }
}