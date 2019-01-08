package com.wh.utilsapp.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wh.utilsapp.R;
import com.wh.utilsapp.utils.CommonDialog;
import com.wh.utilsapp.utils.LogUtils;

public class DialogUtilsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void baseDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Material Design Dialog");
        builder.setMessage("这是 android.support.v7.app.AlertDialog 中的样式");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LogUtils.showTestLog("on success on click");
            }
        });
        builder.show();
    }

    public void customDialog(View view) {
        final CommonDialog dialog=new CommonDialog(DialogUtilsActivity.this);
        dialog.setMessage("对于一个在北平住惯的人，像我，冬天要是不刮风，便觉得是奇迹");
        dialog.setImageResId(R.mipmap.ic_launcher);
        dialog.setSingle(false).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                Toast.makeText(DialogUtilsActivity.this,"xxxxx",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
                Toast.makeText(DialogUtilsActivity.this,"------",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
