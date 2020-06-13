package com.example.qlbhcdio.model;

import java.io.Serializable;

public class Product implements Serializable {
    String id;
    String name;
    String description;
    double money;
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Product() {
    }

    public Product(String id, String name, String description, double money) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.money = money;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
