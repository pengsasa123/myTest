package com.qingzu.applet.dao;

import com.qingzu.applet.result.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface AppletDao {

    Map<String ,Object> optsInstallMaster_Login(@Param("account") String account, @Param("password") String password);

    List<Map<String,Object>> optsInstallMaster_UnInstallIHardware(@Param("opInstallMasterID") Long opInstallMasterID);

    Map<String ,Object> optsInstallMaster_CheckDeviceNumber(@Param("deviceNumber") String deviceNumber);

    List<Map<String,Object>> optsInstallMaster_MaHouse(@Param("opInstallMasterID") Long opInstallMasterID,@Param("baIHardwareCategoryID") Long baIHardwareCategoryID);

    void optsInstallMaster_InstallProcess(@Param("opInstallMasterID") Long opInstallMasterID,@Param("opHouseIHardwareID") Long opHouseIHardwareID,
                                          @Param("maHouseID") Long maHouseID,@Param("baIHardwareCategoryID") Long baIHardwareCategoryID,@Param("deviceNumber") String deviceNumber);

    List<String> getId();
    List<Map<String,String>> getqwe();

    int update(@Param("pinyin") String pinyin,@Param("cityName") String cityName);

    int insert(@Param("streetId") String streetId, @Param("lat") BigDecimal lat,
               @Param("lng") BigDecimal lng, @Param("areaId") String areaId,@Param("streetName") String streetName);
}
