package com.qingzu.applet.test2;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({Product.class})
public class ProductConfig {

    @Autowired
    Product product;

    @Bean(name = "productService",autowire = Autowire.BY_NAME)
    public ProductService productService(){
        return new ProductService(product.getUsername(),product.getPassword());
    }
}
