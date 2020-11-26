package com.qingzu.applet.test4;

import lombok.Data;

@Data
public class Student extends Person{
    private String nianJi;

    @Override
    public void run(){
        System.out.println("i can run!");
    }
}
