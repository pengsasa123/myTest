package com.qingzu.applet.controller;

public class Singleton {
    public static final Singleton SINGLETON = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstace(){
        return SINGLETON;
    }
}
