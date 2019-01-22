package com.qingzu.applet.service;

import com.qingzu.applet.dao.AppletDao;
import com.qingzu.applet.interfaces.AppletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AppletServiceImpl implements AppletService{

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

    @Transactional
    @Override
    public void optsInstallMaster_InstallProcess(Long opInstallMasterID, Long opHouseIHardwareID, Long maHouseID, Long baIHardwareCategoryID, String deviceNumber) {
        appletDao.optsInstallMaster_InstallProcess(opInstallMasterID, opHouseIHardwareID, maHouseID, baIHardwareCategoryID, deviceNumber);
    }
}
