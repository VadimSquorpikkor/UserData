package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 24.07.2017.

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

public class SaveLoad {

    public static final String TAG = "LOG!";

    void saveStringArray(ArrayList<String> stringList, SharedPreferences sPref) {
        int count = 1;
        SharedPreferences.Editor editor = sPref.edit();
        for (String s : stringList) {
            editor.putString("setting" + count, s);
            count++;
        }
        editor.apply();
    }

    void loadStringArray(ArrayList<String> stringList, SharedPreferences sPref) {
        stringList.clear();
        int count = 1;
        while (sPref.contains("setting" + count)) {
            stringList.add("setting" + count);
            count++;
        }
    }

    void saveUserList(ArrayList<User> userList, SharedPreferences sPref) {
        int count = 1;
        SharedPreferences.Editor editor
                = sPref.edit();
        for (User user : userList) {
            editor.putString("setting" + count, user.getName());
            count++;
        }
        editor.apply();
    }

    void loadUserList(ArrayList<User> userList, SharedPreferences sPref) {
        if (sPref != null) {
            Log.e(TAG, "sPref NOT NULL!!!");
            userList.clear();
            if (userList.isEmpty()) {
                Log.e(TAG, "loadUserList: USER LIST IS EMPTY!");
            }
            int count = 1;
            while (sPref.contains("setting" + count)) {
                userList.add(new User(sPref.getString("setting" + count, "")));
                Log.e(TAG, "loadUserList: " + sPref.getString("setting" + count, ""));
                count++;
            }
        } else {
            Log.e("LOOGGG!", "loadUserList: sPref = NULL!!!");
        }
    }
}
