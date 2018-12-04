package com.wh.utilsapp.activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.wh.utilsapp.R;

import java.io.IOException;
import java.io.InputStream;

import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.GPUImageGrayscaleFilter;

public class ImageFilterActivity extends AppCompatActivity {
    //图片处理示列 滤镜  参考地址  https://blog.csdn.net/it_zjyang/article/details/52268918

    private GPUImage gpuImage;
    private ImageView resultIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        resultIv = findViewById(R.id.image);
        AssetManager as = getAssets();
        InputStream is;
        Bitmap bitmap = null;
        try {
            is = as.open("bg.jpg");
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            Log.i("GPUImage", "Error");
        }
        gpuImage = new GPUImage(this);
        gpuImage.setImage(bitmap);
        gpuImage.setFilter(new GPUImageGrayscaleFilter());
        bitmap = gpuImage.getBitmapWithFilterApplied();
        resultIv.setImageBitmap(bitmap);
    }
}
