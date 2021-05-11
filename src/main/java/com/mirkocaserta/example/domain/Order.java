package com.mirkocaserta.example.domain;

import java.util.Date;

public class Order {

    public enum Status {PROCESSED, FAILED}

    private final Status status;
    private final Date timestamp = new Date();
    private final Customer customer;
    private final Product product;

    public Order(Status status, Customer customer, Product product) {
        this.status = status;
        this.customer = customer;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order" +
                "{status=" + status +
                ", timestamp=" + timestamp +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }

}
