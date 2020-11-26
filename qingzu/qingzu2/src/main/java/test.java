

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiConsumer;


@Slf4j
public class test {

    public static ThreadPoolExecutor readDeviceDataPool = new ThreadPoolExecutor(4, 4, 0,
        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());

    public static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4, new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws Exception {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        System.out.println(Thread.currentThread().getName());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("future:" + Thread.currentThread().getName());
                System.out.println("future 开始了");
                TimeUnit.SECONDS.sleep(0);
                System.out.println("future 结束了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "123";
        }, readDeviceDataPool);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("future1:" + Thread.currentThread().getName());
                System.out.println("future1 开始了");
                TimeUnit.SECONDS.sleep(0);
                System.out.println("future1 结束了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "456";
        }, readDeviceDataPool);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("我是无返回值的"), readDeviceDataPool);

        CompletableFuture<String> future3 = future.thenCombine(future1, (s1, s2) -> {
            System.out.println("future3:" + Thread.currentThread().getName());
            System.out.println("future3 开始了");
            return s1 + s2;
        });
        System.out.println("12121121");
        System.out.println(future3.get());

        /*Person person = () -> new Student("xiao", 1, 1);
        System.out.println(person.eat());
*/
        CompletableFuture.runAsync(() -> {
            System.out.println("hahhaha");
        }, readDeviceDataPool).exceptionally(e -> {
            System.out.println(e);
            return null;
        });

        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            readDeviceDataPool.execute(()->{
                if (finalI == 5) {
                    int j = 1/0;
                }
                System.out.println(finalI);
            });
        }

        System.out.println("================================================");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture.runAsync(()->{
                if (finalI == 5) {
                    int j = 1/0;
                }
                System.out.println(finalI);
            },readDeviceDataPool).exceptionally(e->{
                System.out.println(e);
                return null;
            }).whenCompleteAsync((s, throwable) -> {
                System.out.println("poiuy");
                System.out.println(s);
            });
        }

        BigDecimal bigDecimal = BigDecimal.valueOf(0.02D);
        System.out.println(bigDecimal.intValue());
    }


    public static <T> String getString(T t) {

        String jsonString = JSONObject.toJSONString(t);

        return jsonString;
    }


    /**
     * @param s      要截取的字符串
     * @param length 要截取字符串的长度->是字节一个汉字2个字节
     *               return 返回length长度的字符串（含汉字）
     */
    private static String getTitleToTen(String s, int length) throws Exception {

        byte[] bytes = s.getBytes("Unicode");
        int n = 0;
        int i = 2;
        for (; i < bytes.length && n < length; i++) {
            if (i % 2 == 0) {
                n++;
            } else {
                if (bytes[i] != 0) {
                    n++;
                }
            }
        }
        //将截一半的汉字要保留
        if (i % 2 == 1) {
            i = i + 1;
        }
        String unicode = new String(bytes, 0, i, "Unicode");
        StringBuilder sb = new StringBuilder();
        return sb.append(s).delete(0, unicode.length()).toString();
    }
}
