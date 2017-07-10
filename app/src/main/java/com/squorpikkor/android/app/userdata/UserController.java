package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 05.07.2017.

import java.util.ArrayList;

public class UserController {
    private ArrayList<User> userList = new ArrayList<>();

    void createNewUser(String name) {
        userList.add(new User(name));
    }

    User giveMeTheUser(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                return userList.get(i);
            }
        }
        return null;
    }

    User giveMeUserByNumber(int number) {
        return userList.get(number);
    }

    String giveMeAllUsers() {
        String s = "";
        for (User user : userList) {
            s += " " + user.getName();
        }
        return s;
    }

    ArrayList<String> giveMeUserNameArray() {
        ArrayList<String> list = new ArrayList<>();
        for (User user : userList) {
            list.add(user.getName());
        }
        return list;
    }

    void saveUser() {

    }

    void loadUser() {

    }

}
