package com.qingzu.applet.test2;


public class ProductService {
    private String username;
    private String password;

    public ProductService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String get(){
        return username+"---"+password;
    }
}
