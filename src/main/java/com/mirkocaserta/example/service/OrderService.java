package com.mirkocaserta.example.service;

import com.mirkocaserta.example.domain.Customer;
import com.mirkocaserta.example.domain.Order;
import com.mirkocaserta.example.domain.Product;

public interface OrderService {

    Order orderJZ(Customer customer, Product product);

}
