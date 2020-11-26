package com.qingzu.applet.test;

import java.time.LocalDate;



public class Test {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 6, 5);
        LocalDate of = LocalDate.of(2019, 12, 4);
        long s = of.toEpochDay() - localDate.toEpochDay();
        System.out.println(s);

    }
}