package com.squorpikkor.android.app.userdata;

// Created by VadimSquorpikkor on 24.07.2017.

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

class SaveLoad {

    private SharedPreferences sharedPreferences;
    Context context;

    private HashMap<String, SharedPreferences> userPrefList = new HashMap<>();

    SaveLoad(Context context) {//Constructor to use shPref
        this.context = context;
        sharedPreferences = context.getSharedPreferences("mainPref", Context.MODE_PRIVATE);
    }

    private static final String TAG = "LOG!";

    void saveUserListToFile(ArrayList<User> userList) {
        int count = 1;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        for (User user : userList) {
            editor.putString("setting" + count, user.getName());
            count++;
        }
        editor.apply();
    }

    void loadUserListFromFile(ArrayList<User> userList) {
        if (sharedPreferences != null) {
            userList.clear();
            int count = 1;
            while (sharedPreferences.contains("setting" + count)) {
                String name = sharedPreferences.getString("setting" + count, "");
                userList.add(new User(name));
                count++;
            }
        } else {
            Log.e("LOOGGG!", "loadUserListFromFile: sPref = NULL!!!");
        }
    }

    void createUserFile(String nameOfPref) {
        userPrefList.put(nameOfPref, (context.getSharedPreferences(nameOfPref, Context.MODE_PRIVATE)));
    }

    void saveUserFile(String nameOfPref, ArrayList<String> variableList) {
        SharedPreferences.Editor editor = userPrefList.get(nameOfPref).edit();
        int count = 0;
        for (String var : variableList) {
            editor.putString("count" + count, var);
            count++;
        }
        editor.apply();
    }

    ArrayList<String> loadUserFile(String userName, ArrayList<String> variableList) {
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        while (userPrefList.get(userName).contains("count" + count)) {
            String value = userPrefList.get(userName).getString("count" + count, "");//From HashMap "userPrefList" it takes preference for user with name "userName"
            list.add(value);            //and from its preference get value with key ""count"+count". Than add this value to ArrayList which returned by method
            count++;
        }
        return list;
    }

    /*ArrayList<String> loadUserFile(String userName, ArrayList<String> variableList) {
        ArrayList<String> list = new ArrayList<>();
        for (String vName : variableList) {
            String value = userPrefList.get(userName).getString(vName, "");//From HashMap "userPrefList" it takes preference for user with name "userName"
            list.add(value);            //and from its preference get value with key "vName". Than add this value to ArrayList which returned by method
        }
        return list;
    }*/

    void removeUserFile(String name) {
        userPrefList.get(name).edit().clear().apply();//It should be deleting a FILE, not only clear it and remove from list!
        userPrefList.remove(name);
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
