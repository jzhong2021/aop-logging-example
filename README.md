
# Spring Boot AOP logging example

This is an example project which shows how to setup and use aop
logging in a Spring Boot app.

## Running

To run the project:

```shell
$ mvn spring-boot:run
```

Fire up this url in your
browser: [http://localhost:8080/](http://localhost:8080/)

You should see something like the following in your console each time
you refresh the web page:

```
aop-logging-example: 15:00:15.807 [http-nio-8080-exec-1] DEBUG com.mirkocaserta.example.service.DefaultOrderService - order(Customer{fullName='Arthur Dent', address='The Galaxy'},Product{id=42, name='Hitchhiker's Guide to the Galaxy'}): invoked
aop-logging-example: 15:00:15.814 [http-nio-8080-exec-1] DEBUG com.mirkocaserta.example.service.DefaultOrderService - order(Customer{fullName='Arthur Dent', address='The Galaxy'},Product{id=42, name='Hitchhiker's Guide to the Galaxy'}): returning; result=Order{status=PROCESSED, timestamp=Tue May 11 15:00:15 CEST 2021, customer=Customer{fullName='Arthur Dent', address='The Galaxy'}, product=Product{id=42, name='Hitchhiker's Guide to the Galaxy'}}
```

## Hints

The parts that you need to look for are easily searchable:

```shell
$ grep -r NOTE .
./src/main/java/com/mirkocaserta/example/AopLoggingExampleApplication.java:@EnableAspectJAutoProxy // NOTE: this is needed for @Aspect to work
./src/main/java/com/mirkocaserta/example/service/DefaultOrderService.java:    @Debug // NOTE: annotate methods you want to enable logging for
./src/main/java/com/mirkocaserta/example/domain/Debug.java:public @interface Debug { // NOTE: annotate methods with this to enable logging at debug level
./src/main/java/com/mirkocaserta/example/logging/aop/LoggingAspect.java:public class LoggingAspect { // NOTE: customize this class maybe?
```

## Warning

Someone once said

> With great power comes great responsibility

Please be careful when using this aspect. You can easily shoot yourself in the foot with it.

Make sure the methods you are intercepting take parameters that cleanly implement `toString()` methods.

Imagine intercepting a controller method that takes a `HttpServletRequest`. Yeah, that happened to me once in production and my tech lead was not amused, I can assure you.
