import java.util.stream.Stream;

public class test9 {
    public static void main(String[] args) {
        // 无限流  从2开始每次加2
        // Stream.iterate(2, x -> x + 2);
        // 无限流 无参,有返回值
        /*Stream.generate(() -> Math.random())
            .forEach(System.out::println);*/

        // 合并两个stream
        Stream.concat(Stream.of(1, 2, 3, 6, 7), Stream.of(1, 2, 3, 4, 5))
            .forEach(System.out::println);
    }
}
