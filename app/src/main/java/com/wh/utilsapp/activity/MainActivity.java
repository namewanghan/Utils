package com.wh.utilsapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wh.baseutils.SuccessTest;
import com.wh.utilsapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("SUCCESS","XXX   ");
    }

    //测试用按钮
    public void test(View view) {
        SuccessTest.SUCCESS();
    }

    //滤镜界面
    public void filterActivity(View view) {
        Intent intent=new Intent(MainActivity.this,ImageFilterActivity.class);
        startActivity(intent);
    }
}
