import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static ReentrantLock lock = new ReentrantLock(true);
    public static int i = 0;
    public static ThreadPoolExecutor readDeviceDataPool = new ThreadPoolExecutor(4, 4, 0,
        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        boolean b = lock.tryLock();

        System.out.println(b);
    }
}
