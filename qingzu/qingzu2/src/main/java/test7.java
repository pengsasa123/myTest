import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test7 {
    public static void main(String[] args) {
        Function<Integer, Integer> f = i -> i + 1;
        System.out.println(f.apply(3));

        Student student = new Student();
        student.setAge(1);

        Optional.of(student)
            .flatMap(u -> Optional.of(u.getAge()));


        Comparator comparator = Comparator.comparingDouble(Double::doubleValue);
        BinaryOperator by = BinaryOperator.minBy(comparator);
        System.out.println(by.apply(1.1, 2.2));

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

    }
}
