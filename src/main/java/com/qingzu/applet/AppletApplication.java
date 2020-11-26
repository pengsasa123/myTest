package com.qingzu.applet;

import com.qingzu.applet.result.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppletApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(AppletApplication.class, args);
		User bean = run.getBean(User.class);
		System.out.println(bean);
	}

}

