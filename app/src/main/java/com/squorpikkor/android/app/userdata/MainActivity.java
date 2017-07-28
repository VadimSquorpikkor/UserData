package com.squorpikkor.android.app.userdata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button mAddButton, mReadButton;
    EditText mNewUserInput, mShowUser;
    UserController userController;
    ListView listView;
    public static final String USER_NAME = "userName";
    SharedPreferences preferences;




    @Override
    protected void onPause() {
        super.onPause();

        Log.e("MyLog", "onPause: userListIs: " + userController.stringOfAllUser());
        userController.saveUserList(preferences);//or use saveLoad class

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("MyLog", "onResume: userList BEFORE load: " + userController.stringOfAllUser());
        userController.loadUserList(preferences);//or use saveLoad class
        Log.e("MyLog", "onResume: userList AFTER load: " + userController.stringOfAllUser());
        makeAdapter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("myLog", "onCreate");

        userController = new UserController();

        preferences = getSharedPreferences("mainPref", Context.MODE_PRIVATE);

        mAddButton = (Button) findViewById(R.id.addButton);
        mReadButton = (Button) findViewById(R.id.readButton);
        mNewUserInput = (EditText) findViewById(R.id.newUserInput);
        mShowUser = (EditText) findViewById(R.id.showUser);
        listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userController.giveMeUserNameArray());

        listView.setAdapter(adapter);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addButton:
                        addNewUser();
                        break;
                    case R.id.readButton:
                        //showUser
                        Log.e("myLog", "Read Pressed");
//                        mShowUser.setText(userController.giveMeUserByNumber(Integer.parseInt(mShowUser.getText().toString())).getName());
//                        mShowUser.setText("111111");
//                        mShowUser.setText(userController.giveMeAllUsers());
                        makeAdapter();
                        //return name of the user with list number, equal of edit text
                        break;
                }
            }
        };

        mAddButton.setOnClickListener(onClickListener);
        mReadButton.setOnClickListener(onClickListener);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                sendIntentToUserInfoActivity(((TextView) view).getText().toString());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removeUser(((TextView) view).getText().toString());
                return false;
            }
        });

//        userController.loadUserList(preferences);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    void makeAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userController.giveMeUserNameArray());

        listView.setAdapter(adapter);

    }

    void sendIntentToUserInfoActivity(String userName) {
        Intent intent = new Intent(this, UserInfoActivity.class);
        intent.putExtra(USER_NAME, userName);
        startActivity(intent);
    }

    void addNewUser() {
//        Log.e("myLog", "Button pressed");
        userController.createNewUser(mNewUserInput.getText().toString());
        mNewUserInput.setText("");
//        showToast("userAdded");
        makeAdapter();
    }

    void removeUser(String name) {
        userController.removeCurrentUser(name);
        makeAdapter();
    }

}
