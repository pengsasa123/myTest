package com.qingzu.applet.test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalculateAge {
    public static void main(String[] args) {
        CalculateAge.getAge("2015-11-10");
    }

    public static void getAge(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(date, dateTimeFormatter);
        Duration between = Duration.between(parse.atStartOfDay(), LocalDate.now().atStartOfDay());
        System.out.println(between.toDays());
    }
}
