package com.mirkocaserta.example.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
//@Retention(RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.CLASS)   //JZ: changed but not saw difference
public @interface DebugXXX { // NOTE: annotate methods with this to enable logging at debug level
}
