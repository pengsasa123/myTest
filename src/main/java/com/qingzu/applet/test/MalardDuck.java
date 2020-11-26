package com.qingzu.applet.test;

public class MalardDuck extends Duck{
    public MalardDuck() {
        flyBehavior = new FlyBehavior() {
            @Override
            public void fly() {
                System.out.println("I can fly!");
            }
        };
        quackBehavior = new QuackBehavior() {
            @Override
            public void quack() {
                System.out.println("icanquack!");
            }
        };
    }
}
