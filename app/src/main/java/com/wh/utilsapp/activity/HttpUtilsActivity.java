package com.wh.utilsapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wh.utilsapp.R;
import com.wh.utilsapp.utils.LogUtils;
import com.yanzhenjie.kalle.Kalle;
import com.yanzhenjie.kalle.KalleConfig;
import com.yanzhenjie.kalle.OkHttpConnectFactory;
import com.yanzhenjie.kalle.cookie.DBCookieStore;
import com.yanzhenjie.kalle.simple.SimpleCallback;
import com.yanzhenjie.kalle.simple.SimpleResponse;
import com.yanzhenjie.kalle.simple.cache.DiskCacheStore;

import static com.wh.utilsapp.constant.NetConstant.BaseNetAddress;
import static com.wh.utilsapp.constant.NetConstant.testNetAddress;

public class HttpUtilsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
    }

    //post 请求
    public void post(View view) {
        KalleConfig config=KalleConfig.newBuilder()
                //.workThreadExecutor()//工作线程执行器
                //.mainThreadExecutor()//主线程执行器
                //.charset()//发送body 的编码格式
                .addHeader("","")//全局头文件
                //.proxy()//全局代理
                //.sslSocketFactory()//ssl
                //.hostnameVerifier()//host
                //.connectionTimeout()//连接时间
                //.readTimeout()//响应时间
                //.addParam("","")//全局参数
                .connectFactory(OkHttpConnectFactory.newBuilder().build())//配置全局连接生成工厂
                .cacheStore(DiskCacheStore.newBuilder("").build())//增删改查缓存
                //.network(new BroadcastNetwork(this))//配置全局网络，用来让Kalle检查网络是否可用
                .cookieStore(DBCookieStore.newBuilder(this).build())//增删改查Cookie
                //.addInterceptor(new LoggerInterceptor("KalleSample", true))//添加全局拦截器
                //.converter()//配置全局数据转换器
                .build();
        Kalle.setConfig(config);

        Kalle.get(BaseNetAddress+testNetAddress)
                //.removeParam("")//移除某一个公共参数
                .param("device_imsi","460028340620775")
                .perform(new SimpleCallback<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onResponse(SimpleResponse<String, String> response) {
                        LogUtils.showFormatJson(response.succeed());
                    }

                    @Override
                    public void onException(Exception e) {

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onEnd() {

                    }
                });
    }
}
