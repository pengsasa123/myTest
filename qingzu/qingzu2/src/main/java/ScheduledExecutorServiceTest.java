import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    public static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4, new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
        //等待任务执行完毕再进行下一步
        scheduledExecutorService.scheduleWithFixedDelay(() -> {

            System.out.println("1234567890");
        }, 3, 1, TimeUnit.SECONDS);


        //不管任务是否执行完毕,到时间就执行
        scheduledExecutorService.scheduleAtFixedRate(() -> {

            System.out.println("1234567890");
        }, 3, 1, TimeUnit.SECONDS);
    }
}
