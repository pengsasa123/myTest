import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class test6 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        AtomicInteger accumulateCount = new AtomicInteger(0);
        AtomicInteger combineCount = new AtomicInteger(0);
        List<Integer> reduce = IntStream.range(0, 10)
            .parallel()
            .boxed()
            .reduce(list, (i, j) -> {
                System.out.println("i===========" + i);
                System.out.println("j===========" + j);
                accumulateCount.incrementAndGet();
                ArrayList<Integer> newI = new ArrayList<>(i);
                newI.add(j);
                return newI;
            }, (i, j) -> {
                System.out.println("i-----------" + i);
                System.out.println("j-----------" + j);
                combineCount.incrementAndGet();
                ArrayList<Integer> newI = new ArrayList<>(i);
                newI.addAll(j);
                return newI;
            });
    }
}
