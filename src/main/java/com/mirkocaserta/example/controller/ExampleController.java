package com.mirkocaserta.example.controller;

import com.mirkocaserta.example.domain.Customer;
import com.mirkocaserta.example.domain.Order;
import com.mirkocaserta.example.domain.Product;
import com.mirkocaserta.example.service.OrderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ExampleController {

    private final OrderService orderService;

    public ExampleController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public ResponseEntity<String> service() {
        Customer customer = new Customer("Arthur Dent", "The Galaxy");
        Product product = new Product(42L, "Hitchhiker's Guide to the Galaxy");

        Order order = orderService.orderJZ(customer, product);

        String body = "Thank you, your order has been received. Here it is:\n\n" + order + "\n";

        return ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .body(body);
    }

}
