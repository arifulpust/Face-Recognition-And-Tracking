package com.oceanize.facerecognization.oceanizelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.oceanize.facerecognization.R;

import butterknife.BindView;
import ocuiparts.com.library.Activities.MainActivity;

public class LibaryActivity extends AppCompatActivity {
//@BindView(R.id.LoginHeaderView)
//    LoginHeaderView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libary);
        Intent in=new Intent(LibaryActivity.this, MainActivity.class);
        startActivity(in);
    }
}
