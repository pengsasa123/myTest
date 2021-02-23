import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test11 {
    public static void main(String[] args) {

        /**
         * 通过Thread.setDaemon(false)设置为用户线程；通过Thread.setDaemon(true)设置为守护线程。
         * 如果不设置次属性，默认为用户线程。
         *
         * 用户线程和守护线程的区别：
         *
         * 1. 主线程结束后用户线程还会继续运行,JVM存活；主线程结束后守护线程和JVM的状态又下面第2条确定。
         *
         * 2.如果没有用户线程，都是守护线程，那么JVM结束（随之而来的是所有的一切烟消云散，包括所有的守护线程）
         */
        ExecutorService executorService = Executors.newFixedThreadPool(4, (r) -> {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            // 开启守护线程
            t.setDaemon(true);
            return t;
        });

        executorService.execute(()->{
            System.out.println("守护线程进来了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("123");
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("456");
    }
}

