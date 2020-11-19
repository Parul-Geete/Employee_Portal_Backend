package com.company.employees.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	// main method to start the application
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
