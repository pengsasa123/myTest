package com.qingzu.applet.JavaDesignPattern.Decorator;

/**
 * 装饰者模式
 */
public abstract class Drinks {
    //每种饮料都有一个名字
    String name;

    public String getName(){
        return name;
    }
    //每种饮料的价格
    public abstract double cost();
}
