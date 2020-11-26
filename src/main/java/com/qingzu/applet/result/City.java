package com.qingzu.applet.result;

import java.math.BigDecimal;
import java.util.Date;

public class City {
    Integer id;
    String cityId;
    String cityName;
    BigDecimal lat;
    BigDecimal lng;
    String provinceId;
    String pinyin;

    public Date getNextPayTime() {
        return nextPayTime;
    }

    public void setNextPayTime(Date nextPayTime) {
        this.nextPayTime = nextPayTime;
    }

    Date nextPayTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
