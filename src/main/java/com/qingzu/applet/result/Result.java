package com.qingzu.applet.result;

import java.io.Serializable;

public class Result<T> implements Serializable {

    @Override
    public String toString() {
        return "Result [code=" + code + ", status=" + status + ", data=" + data + "]";
    }
    private Integer code;
    private String status;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
