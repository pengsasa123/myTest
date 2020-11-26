package com.qingzu.applet.test4;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(new run());
        }
        executor.shutdown();
    }
}

class run implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "OK!");

        try {

            Thread.sleep(10);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }
}