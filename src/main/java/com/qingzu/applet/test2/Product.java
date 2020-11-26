package com.qingzu.applet.test2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
@Data
public class Product {
    private String username;
    private String password;
}
