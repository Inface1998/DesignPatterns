package com.test.threads.synchronize;

import org.junit.Test;

public class Client {
    private final Object lock = new Object();
    private  int number = 0;
    private boolean writeComplete = false;

    private void read() {
        synchronized (lock) {
            // 如果还没有写入完成，循环等待直到写入完成
            while (!writeComplete) {
                // 等待，并且不要阻塞写入
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("number = " + number);
        }
    }

    private void write(int change) {
        synchronized (lock) {
            number += change;
            System.out.println("写入 " + number);
        }
    }

    @Test
    public void test() throws InterruptedException {
        // 开启一个线程加 10000 次
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                write(1);
            }
            System.out.println("增加 10000 次已完成");
            writeComplete = true;
            synchronized (lock){
                lock.notify();
            }
        }).start();

        // 开启一个线程减 10000 次
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                read();
            }
            System.out.println("减少 10000 次已完成");
        }).start();

        // 睡眠一秒保证线程执行完成
        Thread.sleep(1000);

    }
}