package com.qingzu.applet.controller;


import com.alibaba.fastjson.JSONObject;
import com.qingzu.applet.result.HardLogin;
import com.qingzu.applet.result.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import util.HttpSendCenter;


import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/d/hardware")
public class Hardware {

    @Value("${vlease.ip}")
    private String ip;

    @Autowired
    private HardLogin hardLogin;

    /**
     * 添加指纹
     * @param blueBrdInfo : 蓝牙消息
     * @return
     */
    @GetMapping("/fingerprintKeyInsert")
    public JSONObject fingerprintKeyInsert(@RequestParam("blueBrdInfo") String blueBrdInfo){

        try {
            String token = hardLogin.login();
           // System.out.println("3333333333333::"+token);
            URL url = new URL(ip+"/api/lock/fingerprintKey/insert?blueBrdInfo=" + blueBrdInfo);
            JSONObject jsonObject = HttpSendCenter.get(token, url.toString());

            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取所有指纹
     * @param blueBrdInfo : 蓝牙消息
     * @return
     */
    @GetMapping("/fingerprintKeyGetAll")
    public JSONObject fingerprintKeyGetAll(@RequestParam("blueBrdInfo") String blueBrdInfo){
        try {
            String token = hardLogin.login();
            URL url = new URL(ip+"/api/lock/fingerprintKey/getAll?blueBrdInfo=" + blueBrdInfo);
            JSONObject jsonObject = HttpSendCenter.get(token, url.toString());
            return jsonObject;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 远程开锁
     * @param address : mac蓝牙地址
     * @return
     */
    @GetMapping("/remote")
    public JSONObject remote(@RequestParam("address") String address){

        try {
            String token = hardLogin.login();
            URL url = new URL(ip+"/api/lock/remote?address=" + address);
            JSONObject jsonObject = HttpSendCenter.get(token, url.toString());
            return jsonObject;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加设备
     * @param lock
     * @return
     */
    @PostMapping("/lockAdd")
    public JSONObject lockAdd(@RequestBody Lock lock){
        try {
            String token = hardLogin.login();
            URL url = new URL(ip+"/api/lock/add");
            JSONObject contentMap = new JSONObject();
            contentMap.put("deviceName",lock.getDeviceName());
            contentMap.put("hotelName",lock.getHotelName());
            contentMap.put("imei",lock.getImei());
            contentMap.put("imsi",lock.getImsi());
            contentMap.put("mac",lock.getMac());

            System.out.println(contentMap);
            JSONObject jsonObject = HttpSendCenter.post(token, url.toString(), contentMap);

            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     *  清空指纹
     * @param blueBrdInfo
     * @return
     */
    @GetMapping("/fingerprintKeyClear")
    public JSONObject fingerprintKeyClear(@RequestParam("blueBrdInfo") String blueBrdInfo){
        try {
            String token = hardLogin.login();
            URL url = new URL(ip+"/api/lock/fingerprintKey/clear?blueBrdInfo=" + blueBrdInfo);
            JSONObject jsonObject = HttpSendCenter.get(token, url.toString());
            return jsonObject;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *  删除指纹
     * @param blueBrdInfo :蓝牙广播消息
     * @param fingerId : 指纹id 0-40字符串
     * @return
     */
    @GetMapping("/fingerprintKeyDelete")
    public JSONObject fingerprintKeyDelete(@RequestParam("blueBrdInfo") String blueBrdInfo,@RequestParam("fingerId") String fingerId){
        try {
            String token = hardLogin.login();
            URL url = new URL(ip+"/api/lock/fingerprintKey/delete?blueBrdInfo=" + blueBrdInfo+"&fingerId="+fingerId);
            JSONObject jsonObject = HttpSendCenter.get(token, url.toString());
            return jsonObject;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 蓝牙开锁
     * @param blueBrdInfo
     * @return
     */
    @GetMapping("/lockBluetooh")
    public JSONObject lockBluetooh(@RequestParam("blueBrdInfo") String blueBrdInfo){
        try {
            String token = hardLogin.login();
            URL url = new URL(ip+"/api/lock/bluetooth?blueBrdInfo=" + blueBrdInfo);
            JSONObject jsonObject = HttpSendCenter.get(token, url.toString());
            System.out.println(jsonObject);
            return jsonObject;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
 }
