package com.qingzu.applet.test4;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Test2 {
    private static int oo = 0;
    public static ThreadPoolExecutor wxpayHandlePool = new ThreadPoolExecutor(4, 4, 0,
        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                method();
//            }).start();
//        }
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        wxpayHandlePool.execute(()->{
            method();
        });
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----->" + oo);
    }

    public static void method() {
        for (int i = 0; i < 10000; i++) {
            oo++;
        }
    }
}
