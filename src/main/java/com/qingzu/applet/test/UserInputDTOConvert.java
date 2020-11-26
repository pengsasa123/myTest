package com.qingzu.applet.test;


import org.springframework.beans.BeanUtils;

public class UserInputDTOConvert extends Converter<UserDTO, User> {
    @Override
    protected User doForward(UserDTO userDTO) {


        return null;
    }

    @Override
    protected UserDTO doBackward(User user) {
        return null;
    }

    public static void main(String[] args) {
        User build = User.builder()
                .id(1l)
                .userName("111")
                .password("222")
                .build();
        System.out.println(build);
    }
}
