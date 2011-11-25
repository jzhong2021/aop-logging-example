package com.nexse.swat.example.domain;

import java.util.Date;

public class Order {
    
    public static enum Status { PROCESSED, FAILED }
    
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
        final StringBuilder sb = new StringBuilder();
        sb.append("Order");
        sb.append("{status=").append(status);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", customer=").append(customer);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }

}
