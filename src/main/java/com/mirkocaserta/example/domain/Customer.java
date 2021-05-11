package com.mirkocaserta.example.domain;

public class Customer {

    private final String fullName;
    private final String address;

    public Customer(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer" +
                "{fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
