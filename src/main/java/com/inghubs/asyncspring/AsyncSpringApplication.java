package com.inghubs.asyncspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class AsyncSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncSpringApplication.class, args);
	}

}
