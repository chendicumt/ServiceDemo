package com.panda.servicedemo;

import java.io.Serializable;

/**
 * Created by PC on 2017/9/6.
 */

public class Products implements Serializable {

    private String name;
    private float price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
