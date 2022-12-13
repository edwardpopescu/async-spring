package com.inghubs.asyncspring;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static lombok.AccessLevel.PRIVATE;

@SpringBootApplication
@NoArgsConstructor(access = PRIVATE)
public class AsyncSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncSpringApplication.class, args);
	}

}
