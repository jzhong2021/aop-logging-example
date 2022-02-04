package com.mirkocaserta.example.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Aspect
@ConfigurationProperties("interceptor")
public class Interceptor {

	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

	/**
	 * Message to print on startup
	 */
	private String message = "Startup";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Around("execution(* com.mirkocaserta.example.controller.ExampleController.home2())")
	public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = joinPoint.proceed();
		logger.debug("AspectJ intercept: " + joinPoint.toShortString() + ": " + result);
		return result;
	}

	@Around("execution(* com.mirkocaserta.example.controller.ExampleController.home2())")
	public Object stack(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.debug("AspectJ stack: " + joinPoint.toShortString());
		return joinPoint.proceed();
	}

	@EventListener
	public void started(ContextRefreshedEvent event) {
		logger.debug("AspectJ started: " + message + ": " + event);
	}

}
