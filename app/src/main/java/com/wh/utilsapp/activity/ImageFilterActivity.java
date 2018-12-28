package com.wh.utilsapp.activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.wh.utilsapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.GPUImageColorBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageDilationFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageGrayscaleFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHueBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSketchFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSobelEdgeDetection;
import jp.co.cyberagent.android.gpuimage.GPUImageWeakPixelInclusionFilter;

public class ImageFilterActivity extends AppCompatActivity {
    //图片处理示列 滤镜  参考地址  https://blog.csdn.net/it_zjyang/article/details/52268918

    private GPUImage gpuImage;
    private ImageView resultIv;
    private int a = 0;
    private ArrayList<GPUImageFilter> filterList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        resultIv = findViewById(R.id.image);

        filterList = new ArrayList<>();
//        filterList.add(new GPUImage3x3ConvolutionFilter());
//        filterList.add(new GPUImage3x3TextureSamplingFilter());
//        filterList.add(new GPUImageAddBlendFilter());
//        filterList.add(new GPUImageAlphaBlendFilter());
//        filterList.add(new GPUImageBilateralFilter());
//        filterList.add(new GPUImageBoxBlurFilter());
//        filterList.add(new GPUImageBrightnessFilter());
//        filterList.add(new GPUImageBulgeDistortionFilter());
//        filterList.add(new GPUImageCGAColorspaceFilter());
//        filterList.add(new GPUImageChromaKeyBlendFilter());
//        filterList.add(new GPUImageColorBalanceFilter());
//        filterList.add(new GPUImageColorBlendFilter());
//        filterList.add(new GPUImageColorBurnBlendFilter());
//        filterList.add(new GPUImageColorDodgeBlendFilter());
//        filterList.add(new GPUImageColorInvertFilter());
//        filterList.add(new GPUImageColorMatrixFilter());
//        filterList.add(new GPUImageContrastFilter());
//        filterList.add(new GPUImageCrosshatchFilter());
//        filterList.add(new GPUImageDarkenBlendFilter());
//        filterList.add(new GPUImageDifferenceBlendFilter());
//        filterList.add(new GPUImageDilationFilter());
//        filterList.add(new GPUImageDirectionalSobelEdgeDetectionFilter());
//        filterList.add(new GPUImageDissolveBlendFilter());
//        filterList.add(new GPUImageDivideBlendFilter());
//        filterList.add(new GPUImageEmbossFilter());
//        filterList.add(new GPUImageExposureFilter());
//        filterList.add(new GPUImageExclusionBlendFilter());
//        filterList.add(new GPUImageFalseColorFilter());
//        filterList.add(new GPUImageGammaFilter());
//        filterList.add(new GPUImageGaussianBlurFilter());
//        filterList.add(new GPUImageGlassSphereFilter());
//        filterList.add(new GPUImageGrayscaleFilter());
//        filterList.add(new GPUImageHalftoneFilter());
//        filterList.add(new GPUImageHardLightBlendFilter());
//        filterList.add(new GPUImageHazeFilter());
//        filterList.add(new GPUImageHighlightShadowFilter());
//        filterList.add(new GPUImageHueBlendFilter());
//        filterList.add(new GPUImageHueFilter());
//        filterList.add(new GPUImageKuwaharaFilter());
//        filterList.add(new GPUImageLaplacianFilter());
//        filterList.add(new GPUImageLevelsFilter());
//        filterList.add(new GPUImageLightenBlendFilter());
//        filterList.add(new GPUImageLinearBurnBlendFilter());
//        filterList.add(new GPUImageLookupFilter());
//        filterList.add(new GPUImageLuminosityBlendFilter());
//        filterList.add(new GPUImageMixBlendFilter("xxxxx"));
//        filterList.add(new GPUImageMonochromeFilter());
//        filterList.add(new GPUImageMultiplyBlendFilter());
//        filterList.add(new GPUImageNonMaximumSuppressionFilter());
//        filterList.add(new GPUImageNormalBlendFilter());
//        filterList.add(new GPUImageOpacityFilter());
//        filterList.add(new GPUImageOverlayBlendFilter());
//        filterList.add(new GPUImagePixelationFilter());
//        filterList.add(new GPUImagePosterizeFilter());
//        filterList.add(new GPUImageRGBDilationFilter());
//        filterList.add(new GPUImageRGBFilter());
//        filterList.add(new GPUImageSaturationBlendFilter());
//        filterList.add(new GPUImageSaturationFilter());
//        filterList.add(new GPUImageScreenBlendFilter());
//        filterList.add(new GPUImageSepiaFilter());
//        filterList.add(new GPUImageSharpenFilter());
//        filterList.add(new GPUImageSketchFilter());
//        filterList.add(new GPUImageSmoothToonFilter());
//        filterList.add(new GPUImageSobelEdgeDetection());
//        filterList.add(new GPUImageSobelThresholdFilter());
//        filterList.add(new GPUImageSoftLightBlendFilter());
//        filterList.add(new GPUImageSourceOverBlendFilter());
//        filterList.add(new GPUImageSphereRefractionFilter());
//        filterList.add(new GPUImageSubtractBlendFilter());
//        filterList.add(new GPUImageSwirlFilter());
//        filterList.add(new GPUImageThresholdEdgeDetection());
//        filterList.add(new GPUImageToneCurveFilter());
//        filterList.add(new GPUImageToonFilter());
//        filterList.add(new GPUImageTransformFilter());
//        filterList.add(new GPUImageVignetteFilter());
//        filterList.add(new GPUImageWeakPixelInclusionFilter());
//        filterList.add(new GPUImageWhiteBalanceFilter());
//        filterList.add(new GPUImageTwoInputFilter("11111"));
//        filterList.add(new GPUImageTwoPassFilter("aaaa","bbbb","cccc","dddd"));
//        filterList.add(new GPUImageTwoPassTextureSamplingFilter("aaaa","bbbb","cccc","dddd"));


        filterList.add(new GPUImageColorBlendFilter());
        filterList.add(new GPUImageDilationFilter());
        filterList.add(new GPUImageGrayscaleFilter());
        filterList.add(new GPUImageHueBlendFilter());
        filterList.add(new GPUImageSketchFilter());
        filterList.add(new GPUImageSobelEdgeDetection());
        filterList.add(new GPUImageWeakPixelInclusionFilter());
    }

    public void addnumber(View view) {
        Log.i("success", "xxxx    " + a+"     "+filterList.get(a).getClass().getName());
        a++;
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
        gpuImage.setFilter(filterList.get(a));
        bitmap = gpuImage.getBitmapWithFilterApplied();
        resultIv.setImageBitmap(bitmap);
    }
}
