package com.example.assertions_junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AssertionsJunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssertionsJunitApplication.class, args);
	}

}
