package com.qingzu.applet.result;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Time {
    @JSONField(format = "yyyy-MM-dd")
    private Date time;

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                '}';
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
