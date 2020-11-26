package com.qingzu.applet.test3;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        User user = User.builder().username("111").password("222").build();
        People people = People.builder().age(40).user(user).build();

        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(user));
        System.out.println(jsonObject);

        boolean b = Pattern.matches("^[+]{0,1}(\\d+)$", "20000000000");
        System.out.println(b);

        long time = System.currentTimeMillis() / 1000 + 3600 * 24;
        System.out.println(time);
        Date date = new Date(time * 1000);
        System.out.println(date);

        Predicate<Integer> tPredicate = p -> p == 1;
        boolean apply = tPredicate.apply(1);
        System.out.println(apply);

        Supplier<Integer> integerSupplier = () -> 100;
        System.out.println(integerSupplier.get());

        Consumer<User> consumer = p -> System.out.println(p.getPassword());
        consumer.accept(user);

        boolean method = method(2014);
        System.out.println(method);

        Predicate<String> stringPredicate = p->p.equals("1");
        LocalDate.now().isLeapYear();
    }

    public static boolean method(Integer i) {
        Predicate<Integer> predicate = p -> p % 4 == 0;
        return predicate.apply(i);
    }
}
