package com.wh.utilsapp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.wh.baseutils.SuccessTest;
import com.wh.utilsapp.R;
import com.wh.utilsapp.utils.DeviceInfoUtils;

public class MainActivity extends AppCompatActivity {

    private TextView showHeAndWid,deviceInfo;
    private ColorPicker colorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showHeAndWid = findViewById(R.id.show_heAndWid);
        deviceInfo=findViewById(R.id.device_info);
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

    public void deviceUtils(View view) {
        StringBuilder sb=new StringBuilder();
        sb.append("device info :").append("\n");
        sb.append("IMSI: ").append(DeviceInfoUtils.getIMSI(MainActivity.this)).append("\n");
        sb.append("ID: ").append(DeviceInfoUtils.ID(MainActivity.this)).append("\n");
        sb.append("MAC: ").append(DeviceInfoUtils.MAC(MainActivity.this)).append("\n");
        sb.append("BRAND: ").append(Build.BRAND).append("\n");
        sb.append("MODEL: ").append(Build.MODEL);
        deviceInfo.setText(sb.toString());
    }
}
