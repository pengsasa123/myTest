import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test4 {

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        ArrayList<String> list = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
            a.add("--->" + b);
            return a;
        }, (a, b) -> null);
        System.out.println(list);

        List<Integer> integers = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        long reduce = integers.stream().reduce(0L, (a, b) -> a + b, (a, b) -> 0L);
        System.out.println(reduce);

        List<Integer> list1 = new ArrayList<>();
        Integer reduce1 = list1.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce1);

        // 当初始值与list的类型不一致时,第三个参数来指定返回值
        List<Integer> integers2 = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        // 如果不指定第三个参数的话,前面会报错,初始值a的类型就是integer,反而指定了返回值类型,a的类型就是返回值stringbuilder
        StringBuilder reduce2 = integers2.stream().reduce(new StringBuilder(), (a, b) -> a.append(b), StringBuilder::append);
        System.out.println(reduce2);

    }


}
