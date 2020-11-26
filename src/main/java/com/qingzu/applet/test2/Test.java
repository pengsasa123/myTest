package com.qingzu.applet.test2;



import java.time.LocalDate;
import java.time.LocalDateTime;


public class Test {
    public static void main(String[] args) {

        LocalDate localDate = LocalDateTime.now().toLocalDate();
        LocalDate of1 = LocalDate.of(2019, 06, 03);
        long l = of1.toEpochDay()-localDate.toEpochDay();
        System.out.println(l);
        System.out.println(LocalDateTime.now());
    }
}
