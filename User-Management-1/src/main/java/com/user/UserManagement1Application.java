package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserManagement1Application {

	public static void main(String[] args) {
//		SpringApplication.run(UserManagement1Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(UserManagement1Application.class);
		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
