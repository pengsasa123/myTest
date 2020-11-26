package com.qingzu.applet.test;

public class Signton {
    public static final Signton SIGNTON = new Signton();
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Signton() {}

    public Signton(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public static Signton getInstance(){
        return SIGNTON;
    }
}
