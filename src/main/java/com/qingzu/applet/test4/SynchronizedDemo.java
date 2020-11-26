package com.qingzu.applet.test4;

import com.google.common.base.Supplier;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedDemo {
    private static Lock lock = new ReentrantLock();
    private static volatile int num = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        demo();
        demo1();
    }

    public static void demo() {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            Runnable runnable = () -> sync();
            runnable.run();
        }
        System.out.println("累加：" + num);
    }

    public static void demo1() {
        for (int i = 0; i < 1000; i++) {
            Runnable r = () -> atomicInteger.incrementAndGet();
            r.run();
        }
        System.out.println(atomicInteger);
    }

    public static void sync() {
        lock.lock();
        num++;
        lock.unlock();
    }
}
