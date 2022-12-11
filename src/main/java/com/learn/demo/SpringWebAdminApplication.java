package com.learn.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.learn.demo.mapper")
@ServletComponentScan(basePackages = "com.learn.demo")
@SpringBootApplication
public class SpringWebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebAdminApplication.class, args);
	}

}
