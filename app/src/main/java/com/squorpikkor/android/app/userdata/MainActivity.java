package com.squorpikkor.android.app.userdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button mAddButton, mReadButton;
    EditText mNewUserInput, mShowUser;
    UserController userController;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("myLog", "onCreate");

        userController = new UserController();

        mAddButton = (Button) findViewById(R.id.addButton);
        mReadButton = (Button) findViewById(R.id.readButton);
        mNewUserInput = (EditText) findViewById(R.id.newUserInput);
        mShowUser = (EditText) findViewById(R.id.showUser);
        listView = (ListView)findViewById(R.id.listView);

        ArrayList<String> catNames = new ArrayList<>();
        catNames.add("Vaska");
        catNames.add("Barsik");
        catNames.add("Leo");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userController.giveMeUserNameArray());

        listView.setAdapter(adapter);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addButton:
                        Log.e("myLog", "Button pressed");
                        //addUser
                        userController.createNewUser(mNewUserInput.getText().toString());
                        showToast("userAdded");
                        break;
                    case R.id.readButton:
                        //showUser
                        Log.e("myLog", "Read Pressed");
//                        mShowUser.setText(userController.giveMeUserByNumber(Integer.parseInt(mShowUser.getText().toString())).getName());
//                        mShowUser.setText("111111");
                        mShowUser.setText(userController.giveMeAllUsers());
                        //return name of the user with list number, equal of edit text
                        break;
                }
            }
        };

        mAddButton.setOnClickListener(onClickListener);
        mReadButton.setOnClickListener(onClickListener);

    }

    void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
