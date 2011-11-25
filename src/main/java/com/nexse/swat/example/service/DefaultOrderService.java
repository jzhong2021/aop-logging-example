package com.nexse.swat.example.service;

import com.nexse.swat.example.domain.Customer;
import com.nexse.swat.example.domain.Order;
import com.nexse.swat.example.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderService implements OrderService {

    @Override
    public Order order(Customer customer, Product product) {
        return new Order(Order.Status.PROCESSED, customer, product);
    }

}
