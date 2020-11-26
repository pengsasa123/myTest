package com.qingzu.applet.test;

public class UserDTO {
    private String userName;
    private String password;

    public User convertToUser(){
        DTOUser dtoUser = new DTOUser();
        User convert = dtoUser.convert(this);
        return convert;
    }
}
