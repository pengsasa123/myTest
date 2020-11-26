package com.qingzu.applet.controller;




import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TengxunMap {

    private static final String  KEY = "EGBBZ-BDJKJ-DR7FF-KBZ35-FQMVS-4ABCM";



    public static List<Map<String,Object>> getLocation(String id){
        String urlStr = "https://apis.map.qq.com/ws/district/v1/getchildren?id="+id+"&key="+KEY;
        String result = "";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            // 腾讯地图使用GET
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 获取地址解析结果
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }
        List list =new LinkedList();

        Map<String,Object> map;
        JSONArray jsonObject = (JSONArray) JSON.parseObject(result).get("result");
        if(null != jsonObject){
            for(int i = 0;i<jsonObject.size();i++){
                JSONArray jsonObject1 = jsonObject. getJSONArray(i);
                for(int j =0;j<jsonObject1.size();j++){
                    map = new HashMap<>();
                    JSONObject jsonObject2 = jsonObject1.getJSONObject(j);
                    String id1 = jsonObject2.getString("id");
                    String name = (String) jsonObject2.get("fullname");
                    JSONObject location = jsonObject2.getJSONObject("location");
                    BigDecimal lat = location.getBigDecimal("lat");
                    BigDecimal lng = location.getBigDecimal("lng");
                    map.put("Id",id1);
                    map.put("name",name);
                    map.put("lat",lat);
                    map.put("lng",lng);
                    list.add(map);
                }
            }
        }else {
            return null;
        }
        return list;

    }

    public static void main(String[] args) {
        List location = TengxunMap.getLocation("410000");
        location.forEach(c -> System.out.println(c));
    }
}


