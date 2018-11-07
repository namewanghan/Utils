package com.wh.utilsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wh.baseutils.SuccessTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SuccessTest.SUCCESS();
    }
}
