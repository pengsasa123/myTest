package com.qingzu.applet.controller;

import com.qingzu.applet.interfaces.AppletService;
import com.qingzu.applet.result.Result;
import com.qingzu.applet.result.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ValidateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/d/applet")
public class AppletController {

    @Autowired
    private AppletService appletService;


    /**
     * 工程小程序-登录
     * @param account :账号
     * @param password : 密码
     * @return
     */
    @PostMapping("/optsInstallMaster_Login")
    public Result optsInstallMaster_Login(@RequestParam("account") String account,@RequestParam("password") String password){
        if(!ValidateUtils.Number(account)){
            return ResultUtil.illegality("工号只支持数字");
        }
        if(account.length()>12){
            return ResultUtil.illegality("工号最长12位");
        }
        if(password.length()>6){
            return ResultUtil.illegality("密码最长6位");
        }
        Map<String, Object> resultMap = appletService.optsInstallMaster_Login(account, password);

        return ResultUtil.success(resultMap);
    }

    /**
     * 工程小程序-请选择所安装的设备
     * @param opInstallMasterID :安装师傅id
     * @return
     */
    @GetMapping("/optsInstallMaster_UnInstallIHardware")
    public Result optsInstallMaster_UnInstallIHardware(@RequestParam("opInstallMasterID") Long opInstallMasterID){
        if(null == opInstallMasterID){
            return ResultUtil.empty("参数不能为空");
        }

        List<Map<String, Object>> resultMap = appletService.optsInstallMaster_UnInstallIHardware(opInstallMasterID);

        Map<String,Object> map = new HashMap<>();
        map.put("list",resultMap);

        return ResultUtil.success(map);
    }


    /**
     * 安装师傅-检查序列号
     * @param deviceNumber :硬件序列号
     * @return
     */
    @GetMapping("/optsInstallMaster_CheckDeviceNumber")
    public Result optsInstallMaster_CheckDeviceNumber(@RequestParam("deviceNumber") String deviceNumber){
        if(StringUtils.isEmpty(deviceNumber)){
            return ResultUtil.empty("参数不能为空");
        }

        Map<String, Object> resultMap = appletService.optsInstallMaster_CheckDeviceNumber(deviceNumber);

        return ResultUtil.success(resultMap);
    }


    /**
     *  工程小程序-选择安装房源
     * @param opInstallMasterID : 安装师傅id
     * @param baIHardwareCategoryID : 智能硬件类型id
     * @return
     */
    @GetMapping("/optsInstallMaster_MaHouse")
    public Result optsInstallMaster_MaHouse(@RequestParam("opInstallMasterID") Long opInstallMasterID,@RequestParam("baIHardwareCategoryID") Long baIHardwareCategoryID){

        if(null ==opInstallMasterID || null ==  baIHardwareCategoryID){
            return ResultUtil.empty("参数不能为空");
        }

        List<Map<String, Object>> resultMap = appletService.optsInstallMaster_MaHouse(opInstallMasterID, baIHardwareCategoryID);

        Map<String,Object> map = new HashMap<>();
        map.put("list",resultMap);

        return ResultUtil.success(map);
    }

    /**
     * 确认安装完毕按钮
     * @param opInstallMasterID : 安装师傅id
     * @param opHouseIHardwareID : 房源-智能硬件对应表id
     * @param maHouseID : 房源id
     * @param baIHardwareCategoryID : 智能硬件类型id
     * @param deviceNumber : 智能硬件序列号
     */
    @PostMapping("/optsInstallMaster_InstallProcess")
    public Result optsInstallMaster_InstallProcess(@RequestParam("opInstallMasterID") Long opInstallMasterID, @RequestParam("opHouseIHardwareID") Long opHouseIHardwareID,
                                                   @RequestParam("maHouseID") Long maHouseID, @RequestParam("baIHardwareCategoryID") Long baIHardwareCategoryID, @RequestParam("deviceNumber") String deviceNumber){
        try {
            if(null == opInstallMasterID || null == opHouseIHardwareID || null == maHouseID || null == baIHardwareCategoryID || StringUtils.isEmpty(deviceNumber)){
                return ResultUtil.empty("参数不能为空");
            }

            appletService.optsInstallMaster_InstallProcess(opInstallMasterID, opHouseIHardwareID, maHouseID, baIHardwareCategoryID, deviceNumber);

            Map<String,Object> map = new HashMap<>();
            map.put("msg","成功");

            return ResultUtil.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getMessage());
        }

    }
}
