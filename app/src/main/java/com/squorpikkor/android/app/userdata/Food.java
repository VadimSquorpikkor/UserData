package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 14.07.2017.

abstract class Food {

    private String name;
    private double price;
    private  int count;
    private boolean isTaken;

    Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }


}
