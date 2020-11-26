package com.qingzu.applet.test4;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.util.concurrent.*;

public class TestCountDownLatch {

    public static void main(String[] args) {

        TimeInterval timer = DateUtil.timer();
        //CountDownLatch 为唯一的、共享的资源
        final CountDownLatch latch = new CountDownLatch(10000);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10000, 10000, 0,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10000), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println(timer.interval());
    }
}

