package com.validus.codingtest.musicdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringApp {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringApp.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
