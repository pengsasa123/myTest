package com.qingzu.applet.test3;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String username = "111";
    private String password = "222";
}
