package com.qingzu.applet.test;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private Long id;
    private String userName;
    private String password;
}
