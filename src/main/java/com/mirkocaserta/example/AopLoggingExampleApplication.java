package com.mirkocaserta.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // NOTE: this is needed for @Aspect to work
public class AopLoggingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopLoggingExampleApplication.class, args);
	}

}
