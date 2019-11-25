/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

/**
 *  水果
 *@author : wuch
 *@date: 2019/11/25
 */
public class Fruit {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Fruit() {
    }
}
