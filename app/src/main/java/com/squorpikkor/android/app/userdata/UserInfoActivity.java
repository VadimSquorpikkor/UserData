package com.squorpikkor.android.app.userdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.squorpikkor.android.app.userdata.MainActivity.USER_NAME;

//import static com.squorpikkor.android.app.userdata.MainActivity.USER_NAME;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView textView = (TextView)findViewById(R.id.userInfoName);

        textView.setText(getIntent().getStringExtra(USER_NAME));//data that was sent from mainActivity

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                switch (v.getId()) {
//                    case
//                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
