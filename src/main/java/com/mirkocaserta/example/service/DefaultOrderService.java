package com.mirkocaserta.example.service;

import com.mirkocaserta.example.domain.Customer;
import com.mirkocaserta.example.domain.Debug;
import com.mirkocaserta.example.domain.Order;
import com.mirkocaserta.example.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderService implements OrderService {

    @Override
    @Debug // NOTE: annotate methods you want to enable logging for
    public Order order(Customer customer, Product product) {
        return new Order(Order.Status.PROCESSED, customer, product);
    }

}
