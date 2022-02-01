package com.mirkocaserta.example.service;

import com.mirkocaserta.example.domain.Customer;
import com.mirkocaserta.example.domain.DebugXXX;
import com.mirkocaserta.example.domain.Order;
import com.mirkocaserta.example.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderService implements OrderService {

    @Override
    @DebugXXX // NOTE: annotate methods you want to enable logging for
    public Order orderJZ(Customer customer, Product product) {
        System.out.println("Enter orderJZ ...");
        return new Order(Order.Status.PROCESSED, customer, product);
    }

}

/*
aop-logging-example: 00:58:09.770 [http-nio-8080-exec-1] DEBUG com.mirkocaserta.example.service.DefaultOrderService - orderJZ(Customer{fullName='Arthur Dent', address='The Galaxy'},Product{id=42, name='Hitchhiker's Guide to the Galaxy'}): invoked
Enter orderJZ ...
aop-logging-example: 00:58:09.791 [http-nio-8080-exec-1] DEBUG com.mirkocaserta.example.service.DefaultOrderService - orderJZ(Customer{fullName='Arthur Dent', address='The Galaxy'},Product{id=42, name='Hitchhiker's Guide to the Galaxy'}): returning; result=Order{status=PROCESSED, timestamp=Tue Feb 01 00:58:09 EST 2022, customer=Customer{fullName='Arthur Dent', address='The Galaxy'}, product=Product{id=42, name='Hitchhiker's Guide to the Galaxy'}}
*/