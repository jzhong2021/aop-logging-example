package com.mirkocaserta.example.domain;

public class Product {

    private final long id;
    private final String name;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product" +
                "{id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
