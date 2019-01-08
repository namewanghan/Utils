package com.wh.utilsapp.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.wh.baseutils.SuccessTest;
import com.wh.utilsapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView showHeAndWid;
    private ColorPicker colorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showHeAndWid = findViewById(R.id.show_heAndWid);
        colorPicker=new ColorPicker(MainActivity.this, 255, 0, 0);
    }

    //测试用按钮
    public void test(View view) {
        SuccessTest.SUCCESS();
    }

    public void widAndaHeight(View view) {
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        showHeAndWid.setText("宽     "+width+"       高   "+height);
    }

    //颜色选择器
    public void colorpick(View view) {
        colorPicker.show();
    }

    //tcp 链接
    public void tcpClient(View view) {
        Intent intent=new Intent(MainActivity.this,SocketActivity.class);
        startActivity(intent);
    }

    //日志工具
    public void logUtils(View view) {
        Intent intent=new Intent(MainActivity.this,LoginUtilsUserDemoActivity.class);
        startActivity(intent);
    }

    //网络请求工具
    public void httpUtils(View view) {
        Intent intent=new Intent(MainActivity.this,HttpUtilsActivity.class);
        startActivity(intent);
    }

    //dialog 相关工具
    public void dialogUtils(View view) {
        Intent intent=new Intent(MainActivity.this,DialogUtilsActivity.class);
        startActivity(intent);
    }
}
