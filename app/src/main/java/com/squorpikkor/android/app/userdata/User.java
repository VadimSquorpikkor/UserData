package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 05.07.2017.

import java.util.ArrayList;

public class User {
    private String name;
    private double userMoneyLeft;
    //May be it should be "new order" there
    //private ArrayList<SomeStuff> stuffList = new ArrayList<>();
    //private ArrayList<Juice> juiceList = new ArrayList<>();
    private Order userOrder;

    User(String name) {
        this.name = name;
        userOrder = new Order(name);//create for new user new order
    }

    ArrayList<String> getAllVar() {//May be do it with HashMap?
        ArrayList<String> list = new ArrayList<>();
        list.add(name);
        list.add(String.valueOf(userMoneyLeft));
        return list;
    }

    void setAllVar(ArrayList<String> list) {
        name = list.get(0);
        userMoneyLeft = Double.parseDouble(list.get(1));
    }

    Order getOrder() {
        return userOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUserMoneyLeft() {
        return userMoneyLeft;
    }

    public void setUserMoneyLeft(double userMoneyLeft) {
        this.userMoneyLeft = userMoneyLeft;
    }


//    void addNewSomeStuff(String name) {
//        stuffList.add(new SomeStuff(name));
//    }

    /*void removeSomeStuff(String name) {
        for (SomeStuff someStuff : stuffList) {
            if(someStuff.getName().equals(name))stuffList.remove(someStuff);
        }

    }*/

    /*void addNewJuice(String name) {
        juiceList.add(new Juice(name));
    }
*/
    /*void removeJuice(String name) {
        for (Juice juice : juiceList) {
            if(juice.getName().equals(name))juiceList.remove(juice);
        }

    }*/
}
