package com.nexse.swat.example.service;

import com.nexse.swat.example.domain.Customer;
import com.nexse.swat.example.domain.Order;
import com.nexse.swat.example.domain.Product;

public interface OrderService {

    Order order(Customer customer, Product product);

}
