import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    public static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4, new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
        //等待任务执行完毕再进行下一步(以上一次任务的结束时间计算下一次任务的开始时间)
        scheduledExecutorService.scheduleWithFixedDelay(() -> {

            System.out.println("1234567890");
        }, 3, 1, TimeUnit.SECONDS);


        //不管任务是否执行完毕,到时间就执行(按照上一次任务的发起时间计算下一次任务的开始时间)
        scheduledExecutorService.scheduleAtFixedRate(() -> {

            System.out.println("1234567890");
        }, 3, 1, TimeUnit.SECONDS);
    }
}
