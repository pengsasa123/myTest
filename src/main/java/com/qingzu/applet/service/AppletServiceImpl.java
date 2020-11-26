package com.qingzu.applet.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qingzu.applet.dao.AppletDao;
import com.qingzu.applet.interfaces.AppletService;
import com.qingzu.applet.result.City;
import com.qingzu.applet.result.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Service
public class AppletServiceImpl implements AppletService{

    private static final String  KEY = "EGBBZ-BDJKJ-DR7FF-KBZ35-FQMVS-4ABCM";

    @Autowired
    private AppletDao appletDao;

    @Override
    public Map<String, Object> optsInstallMaster_Login(String account, String password) {
        return appletDao.optsInstallMaster_Login(account, password);
    }

    @Override
    public List<Map<String, Object>> optsInstallMaster_UnInstallIHardware(Long opInstallMasterID) {
        return appletDao.optsInstallMaster_UnInstallIHardware(opInstallMasterID);
    }

    @Override
    public Map<String, Object> optsInstallMaster_CheckDeviceNumber(String deviceNumber) {
        return appletDao.optsInstallMaster_CheckDeviceNumber(deviceNumber);
    }

    @Override
    public List<Map<String, Object>> optsInstallMaster_MaHouse(Long opInstallMasterID, Long baIHardwareCategoryID) {
        return appletDao.optsInstallMaster_MaHouse(opInstallMasterID, baIHardwareCategoryID);
    }

    @Override
    public List<Map<String,String>> getqwe() {
        return appletDao.getqwe();
    }

    @Override
    public int update(String pinyin, String cityName) {
        return appletDao.update(pinyin, cityName);
    }

    @Override
    public List<String> getId() {
        return appletDao.getId();
    }

    @Override
    public int insert(String streetId, BigDecimal lat, BigDecimal lng, String areaId,String streetName) {
       return appletDao.insert(streetId, lat, lng, areaId, streetName);
    }

    @Transactional
    @Override
    public void optsInstallMaster_InstallProcess(Long opInstallMasterID, Long opHouseIHardwareID, Long maHouseID, Long baIHardwareCategoryID, String deviceNumber) {
        appletDao.optsInstallMaster_InstallProcess(opInstallMasterID, opHouseIHardwareID, maHouseID, baIHardwareCategoryID, deviceNumber);
    }
    @Override
    public void test() {
        Test test = new Test();
        test.setUpdate(new Date());
    }
}
