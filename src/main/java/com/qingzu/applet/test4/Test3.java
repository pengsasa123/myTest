package com.qingzu.applet.test4;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

@Component
public class Test3 {
    public static int num = 0;

    public static void main(String[] args) {
        Date date = new Date();
        String s = JSONObject.toJSONString(date);
        System.out.println(s);
    }
}
