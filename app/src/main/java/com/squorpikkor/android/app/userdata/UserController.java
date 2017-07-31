package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 05.07.2017.

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

class UserController {
    private static final String TAG = "LOG";
    private ArrayList<User> userList = new ArrayList<>();
    private SaveLoad saveLoad;

    UserController(Context context) {//Constructor for get content to SaveLoad class
         saveLoad = new SaveLoad(context);
    }

    private boolean nameInList(String name) {
        for (User user : userList) {
            if(user.getName().equals(name))return true;
        }
        return false;
    }

    void createUser(String name) {
        if (!nameInList(name)) {
            userList.add(new User(name));
            Log.e(TAG, "user " + name + " added to userList!!");
        }
    }

    String stringOfAllUser() {//This method for testing only
        String s = "";
        for (User user : userList) {
            s += user.getName() + " / ";
        }
        return s;
    }

    void removeUser(String name) { //It should be better
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                Log.e(TAG, "removeUser: " + userList.get(i).getName() + " will be REMOVED");
                userList.remove(i);
            }
        }
        Log.e(TAG, "removeUser: " + stringOfAllUser());
        saveUserList();
    }

    ArrayList<String> giveMeUserNameArray() {
        ArrayList<String> list = new ArrayList<>();
        for (User user : userList) {
            list.add(user.getName());
        }
        return list;
    }

    void saveUserList() {
        saveLoad.saveUserListToFile(userList);
    }

    void loadUserList() {
        saveLoad.loadUserListFromFile(userList);
    }

    void saveUser(String name) {


    }

    void loadUser() {

    }

    void removeUser() {

    }

    //region OLD METHODS
    /////////////////////////////////////////////////////////////////////



    /*void loadAndGiveMeUserList(SharedPreferences preferences) {
        userList = saveLoad.giveMeUserListFromFile(preferences);
    }*/

    /*String giveMeUsersFromFile(SharedPreferences preferences) {

    }*/

    //    private ArrayList<String> userNameList = new ArrayList<>();

    /*void makeNameList() {
        for (User user : userList) {
            userNameList.add(user.getName());
        }
    }*/

    /*void removeUser(String name) {
        for (User user : userList) {

        }
    }*/


    /*void saveUser() {

    }

    void loadUser() {

    }*/

    /*User giveMeTheUser(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                return userList.get(i);
            }
        }
        return null;
    }*/

    /*User giveMeUserByNumber(int number) {
        return userList.get(number);
    }*/
    //endregion

}
