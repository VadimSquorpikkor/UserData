package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 24.07.2017.

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

class SaveLoad {

    private SharedPreferences sharedPreferences;
    Context context;

    SaveLoad(Context context) {//Constructor to use shPref
        this.context = context;
        sharedPreferences = context.getSharedPreferences("mainPref", Context.MODE_PRIVATE);
    }

    private static final String TAG = "LOG!";

    void saveUserListFromFile(ArrayList<User> userList) {
        int count = 1;
        SharedPreferences.Editor editor
                = sharedPreferences.edit();
        editor.clear();
        for (User user : userList) {
            editor.putString("setting" + count, user.getName());
            count++;
        }
        editor.apply();
    }

    void loadUserListFromFile(ArrayList<User> userList) {
        if (sharedPreferences != null) {
            Log.e(TAG, "sPref NOT NULL!!!");
            userList.clear();
            Log.e(TAG, "loadUserListFromFile: USER LIST IS EMPTY!");

            int count = 1;
            while (sharedPreferences.contains("setting" + count)) {
                userList.add(new User(sharedPreferences.getString("setting" + count, "")));
                Log.e(TAG, "loadUserListFromFile: load user " + sharedPreferences.getString("setting" + count, ""));
                count++;
            }
        } else {
            Log.e("LOOGGG!", "loadUserListFromFile: sPref = NULL!!!");
        }
    }

    //region OLD METHODS
    ////////////////////////////////////////////////////////////////

    /*void removeUserFromFile(String name) {

    }*/

    /*ArrayList<User> giveMeUserListFromFile() {
        ArrayList<User> list = new ArrayList<>();
        if (sharedPreferences != null) {
            int count = 1;
            while (sharedPreferences.contains("setting" + count)) {
                list.add(new User(sharedPreferences.getString("setting" + count, "")));
                count++;
            }
        } else {
            Log.e("LOOGGG!", "loadUserListFromFile: sPref = NULL!!!");
        }
        return list;
    }*/

    /*void saveStringArray(ArrayList<String> stringList, SharedPreferences sPref) {
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
    }*/
    //endregion
}
