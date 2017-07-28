package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 05.07.2017.

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class UserController {
    private static final String TAG = "LOG";
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<String> userNameList = new ArrayList<>();

    void makeNameList() {
        for (User user : userList) {
            userNameList.add(user.getName());
        }
    }

    SaveLoad saveLoad = new SaveLoad();

    void createNewUser(String name) {
        if (!nameInList(name)) {
            userList.add(new User(name));
            Log.e(TAG, "user " + name + " added to userList!!");
        }
    }

    String stringOfAllUser() {
        String s = "";
        for (User user : userList) {
            s += user.getName() + " / ";
        }
        return s;
    }

    User giveMeTheUser(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                return userList.get(i);
            }
        }
        return null;
    }

    void removeCurrentUser(String name) { //It should be better
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                Log.e(TAG, "removeCurrentUser: " + userList.get(i).getName() + " will be REMOVED");
                userList.remove(i);
            }
        }
    }

    boolean nameInList(String name) {
        for (User user : userList) {
            if(user.getName().equals(name))return true;
        }
        return false;
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

    void saveUserList(SharedPreferences preferences) {
        saveLoad.saveUserList(userList, preferences);
    }

    void loadUserList(SharedPreferences preferences) {
        saveLoad.loadUserList(userList, preferences);
    }

}
