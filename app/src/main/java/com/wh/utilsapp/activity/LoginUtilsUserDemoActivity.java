package com.wh.utilsapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wh.utilsapp.R;
import com.wh.utilsapp.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginUtilsUserDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger_utils);
    }

    public void loggFormatJson(View view) {
        //{"data":[{"is_playing":"1","template_info":[{"address":"0","dataList":[{"file_path":"/upload/EJLEIV[VTP@157BTLYD09T61545730239619.png","filetype":"png","type":"pic"},{"file_path":"/upload/R[NE]VBKWE$`SCYH7}]H(U1545730277440.png","filetype":"png","type":"pic"},{"file_path":"/upload/X[$CY1(`0FC~TO{A_CFA2AL1545730415542.png","filetype":"png","type":"pic"},{"file_path":"/upload/wx_camera_15455579439681545731257138.mp4","filetype":"mp4","type":"video"}]},{"address":"1","dataList":[{"file_path":"/upload/wx_camera_15454484962981545731319322.mp4","filetype":"mp4","type":"video"}]}],"templateid":"0"},{"is_playing":"0","template_info":[{"address":"0","dataList":[]},{"address":"1","dataList":[]},{"address":"2","dataList":[]},{"address":"3","dataList":[]}],"templateid":"1"}],"msg":"璇锋眰鎴愬姛锛�","status":"1"}
        String jsonData = "{\"data\":[{\"is_playing\":\"1\",\"template_info\":[{\"address\":\"0\",\"dataList\":[{\"file_path\":\"/upload/EJLEIV[VTP@157BTLYD09T61545730239619.png\",\"filetype\":\"png\",\"type\":\"pic\"},{\"file_path\":\"/upload/R[NE]VBKWE$`SCYH7}]H(U1545730277440.png\",\"filetype\":\"png\",\"type\":\"pic\"},{\"file_path\":\"/upload/X[$CY1(`0FC~TO{A_CFA2AL1545730415542.png\",\"filetype\":\"png\",\"type\":\"pic\"},{\"file_path\":\"/upload/wx_camera_15455579439681545731257138.mp4\",\"filetype\":\"mp4\",\"type\":\"video\"}]},{\"address\":\"1\",\"dataList\":[{\"file_path\":\"/upload/wx_camera_15454484962981545731319322.mp4\",\"filetype\":\"mp4\",\"type\":\"video\"}]}],\"templateid\":\"0\"},{\"is_playing\":\"0\",\"template_info\":[{\"address\":\"0\",\"dataList\":[]},{\"address\":\"1\",\"dataList\":[]},{\"address\":\"2\",\"dataList\":[]},{\"address\":\"3\",\"dataList\":[]}],\"templateid\":\"1\"}],\"msg\":\"xxxxxxx\",\"status\":\"1\"}\n";
        LogUtils.showFormatJson(jsonData);
    }

    public void loggFormatList(View view) {
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(4);
        LogUtils.showObjectList(list);
    }

    public void loggFormatMap(View view) {
        Map<Object, Object> map = new HashMap<>();
        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        map.put("杨康", "穆念慈");
        map.put("陈玄风", "梅超风");
        LogUtils.showObjectMap(map);
    }

    public void loggFormatArr(View view) {
        String [] arr = {"a", "b", "c"};//数组的静态定义方式，只试用于数组首次定义的时候
        LogUtils.showArr(arr);
    }
}
