package com.pack.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        Intent intent = getIntent();
        String value = intent.getStringExtra("data");

        // globally
        TextView myAwesomeTextView = (TextView)findViewById(R.id.dataView);

        //in your OnCreate() method
        myAwesomeTextView.setText(value);
    }
}