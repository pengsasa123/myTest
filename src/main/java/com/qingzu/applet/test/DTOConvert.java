package com.qingzu.applet.test;

public interface DTOConvert<S,T> {
    T convert(S s);
}
