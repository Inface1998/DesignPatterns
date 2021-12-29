package com.test.threads.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : zhanghj
 */
public class Client1 {
    private int number = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private void write(int change) throws InterruptedException {
        if(lock.tryLock(1, TimeUnit.SECONDS)){
            number += change;
            lock.unlock();
        }else {
            System.out.println("1 秒内没有获取到锁，不再等待。");
        }
    }
}
