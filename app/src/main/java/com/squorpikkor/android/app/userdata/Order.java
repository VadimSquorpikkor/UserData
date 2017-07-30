package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 18.07.2017.

import java.util.ArrayList;

public class Order {
    //Maybe it should be single ArrayList of parent class objects
    private ArrayList<Juice> juiceList = new ArrayList<>();
    private ArrayList<SomeStuff> someStuffList = new ArrayList<>();
    private String orderName;

    Order(String name) {
        orderName = name;
    }

    void addJuiceToOrder(String name) {
        juiceList.add(new Juice(name));
    }

    /*Juice getJuiceFromList() {
        return juiceList.get
    }*/

    ArrayList<Juice> getJuiceList() {
        return juiceList;
    }

    void addSomeStuffToOrder(String name) {
        someStuffList.add(new SomeStuff(name));
    }

    ArrayList<SomeStuff> getSomeStuffList() {
        return someStuffList;
    }

    double howMuchIsTheOrder() {
        double sum = 0;
        for (Juice juice : juiceList) {
            sum += juice.getPrice() * (double)juice.getCount();
        }
        for (SomeStuff someStuff : someStuffList) {
            sum += someStuff.getPrice() * (double)someStuff.getCount();
        }
        return sum;
    }

    /////////////////////////////////////////////////////////////

    /*private double orderPrice;

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }*/
}
