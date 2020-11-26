package com.qingzu.applet.test4;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;

    public void run(){
        System.out.println("i can fly!");
    }
}
