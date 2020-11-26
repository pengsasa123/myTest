package com.qingzu.applet.test3;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class People {
    private Integer age =30;
    private User user;
}
