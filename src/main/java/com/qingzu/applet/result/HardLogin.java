package com.qingzu.applet.result;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import util.HttpClientHelper;

import java.util.HashMap;
import java.util.Map;

@Component
public class HardLogin {

    @Value("${vlease.username}")
    private String username;

    @Value("${vlease.password}")
    private String password;

    @Value("${vlease.ip}")
    private String ip;
    /**
     * 登录硬件的方法
     * @param
     * @return
     */

    public String login(){
        try {

            Map<String ,String> map = new HashMap<>();
            map.put("Content-Type","application/json; charset=utf-8");

            JSONObject contentMap = new JSONObject();
            contentMap.put("username",username);
            contentMap.put("password",password);

            String post = HttpClientHelper.httpPost(ip+"/api/sys/login", "POST", map, contentMap);

            JSONObject parse = JSONObject.parseObject(post);

            JSONObject result = (JSONObject) parse.get("result");

            String token = (String) result.get("token");
            System.out.println("2222222222222::"+token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
