import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class test7 {
    public static void main(String[] args) {

        Student student = new Student();
        student.setAge(1);

        Student s = new Student();
        s.setAge(1);
        s.setName("小明");
        Student s1 = new Student();
        s1.setAge(3);
        s1.setName("小红");
        Student s2 = new Student();
        s2.setAge(2);
        s2.setName("小军");
        Student s3 = new Student();
        s3.setAge(2);
        s3.setName("小刚");

        List<Student> list = Arrays.asList(s, s1, s2, s3);
        Map<Integer, List<String>> collect = list.stream().collect(Collectors
            .groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(collect);


        List<Student> students = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(students);

        Map<Integer, Long> collect1 = list.stream().collect(Collectors
            .groupingBy(Student::getAge, Collectors.counting()));
        System.out.println(collect1);

        /**
         * 手动实现一个toList
         * @param Object 表示元素
         * @param ArrayList<Object> 第一个表示执行中的结果 第二个表示最终的结果
         */
        Collector<Object, ArrayList<Object>, ArrayList<Object>> collector = Collector.of(
            /*Supplier<A> supplier 无参数返回一个结果
                相当于返回了一个执行中的结果A
            */
            () -> new ArrayList<>(),
            /*
                BiConsumer<A, T> accumulator 接收2个参数不返回结果
                T表示元素 A表示执行中的结果
                这个表示T会在容器A中发生操作
             */
            (x, y) -> x.add(y),
            /*
                BinaryOperator<A> combiner 接收2个参数并返回同类型的结果
                A表示执行中的结果
                这个表示合并结果,将其合成执行中的结果A
             */
            (x, y) -> {
                x.addAll(y);
                return x;
            },
            /*
                Function<A, R> finisher 接收一个参数并返回一个结果
                R表示最终结果 A表示执行中的结果
                这个表示把结果A转为最终结果R
             */
            x -> x,
            Collector.Characteristics.IDENTITY_FINISH
        );
        list.stream()
            .map(Student::getAge)
            .collect(collector)
            .forEach(System.out::println);

        // 聚合函数查询
        IntSummaryStatistics statistics = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        int max = statistics.getMax();
        int min = statistics.getMin();
        double average = statistics.getAverage();
        long sum = statistics.getSum();
        System.out.printf("最大值->%d,最小值->%d,平均值->%.2f,合计->%d", max, min, average, sum);
    }
}
