package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 05.07.2017.

public class User {
    public String name;
    public double userMoneyLeft;

    User(String name) {
        this.name = name;
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
}
