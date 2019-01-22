package com.qingzu.applet.interfaces;

import java.util.List;
import java.util.Map;

public interface AppletService {

    /**
     * 工程小程序-登录
     * @param account :账号
     * @param password : 密码
     * @return
     */
    Map<String ,Object> optsInstallMaster_Login(String account,String password);

    /**
     * 工程小程序-请选择所安装的设备
     * @param opInstallMasterID :安装师傅id
     * @return
     */
    List<Map<String,Object>> optsInstallMaster_UnInstallIHardware(Long opInstallMasterID);

    /**
     * 安装师傅-检查序列号
     * @param deviceNumber :硬件序列号
     * @return
     */
    Map<String ,Object> optsInstallMaster_CheckDeviceNumber(String deviceNumber);


    /**
     *  工程小程序-选择安装房源
     * @param opInstallMasterID : 安装师傅id
     * @param baIHardwareCategoryID : 智能硬件类型id
     * @return
     */
    List<Map<String,Object>> optsInstallMaster_MaHouse(Long opInstallMasterID,Long baIHardwareCategoryID);


    /**
     * 确认安装完毕按钮
     * @param opInstallMasterID : 安装师傅id
     * @param opHouseIHardwareID : 房源-智能硬件对应表id
     * @param maHouseID : 房源id
     * @param baIHardwareCategoryID : 智能硬件类型id
     * @param deviceNumber : 智能硬件序列号
     */
    void optsInstallMaster_InstallProcess(Long opInstallMasterID,Long opHouseIHardwareID,Long maHouseID,Long baIHardwareCategoryID,String deviceNumber);
}
