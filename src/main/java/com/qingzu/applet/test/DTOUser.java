package com.qingzu.applet.test;

import org.springframework.beans.BeanUtils;

public class DTOUser implements DTOConvert<UserDTO,User>{
    @Override
    public User convert(UserDTO userDTO) {
       return null;
    }

    public static void main(String[] args) {
        User user = new UserDTO().convertToUser();
    }
}
