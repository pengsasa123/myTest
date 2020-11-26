package com.qingzu.applet.test;

public abstract class Converter<A,B> {
    protected abstract B doForward(A a);
    protected abstract A doBackward(B b);
}
