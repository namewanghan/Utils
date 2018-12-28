package com.wh.utilsapp.activity;

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

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("SUCCESS", "XXX   ");
        showHeAndWid = findViewById(R.id.show_heAndWid);
        colorPicker=new ColorPicker(MainActivity.this, 255, 0, 0);
    }

    //测试用按钮
    public void test(View view) {
        SuccessTest.SUCCESS();
    }

    //滤镜界面
    public void filterActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ImageFilterActivity.class);
        startActivity(intent);
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

    //ndk 测试
    public void ndkTestOnclick(View view) {
        Log.i("success","xxx  ");
        Log.i("success","xxx        "+getStr());
    }

    public native String getStr();

}
