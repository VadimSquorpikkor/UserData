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

    void saveUser() {

    }

    void loadUser() {

    }
    
}
