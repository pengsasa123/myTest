import java.util.*;
import java.util.stream.Collectors;

public class Java8FlatMapTest {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("1", "2", "3");
        List<String> list2 = Arrays.asList("1", "2", "3");
        List<String> list3 = Arrays.asList("7", "8", "9");

        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        List<String> collect = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);

        Map<String, Object> map = new HashMap<>();
        map.put("12", 1);
        System.out.println(map);
    }
}
