package com.wh.utilsapp.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.utilsapp.R;

public class CommonDialog extends Dialog {

    private ImageView imageIv;

    private TextView titleTv;

    private TextView messageTv;

    private Button negtiveBn, positiveBn;

    private View columnLineView;

    public CommonDialog(Context context) {
        super(context, R.style.CustomDialog);
    }

    private String message;
    private String title;
    private String positive, negtive;
    private int imageResId = -1;
    private boolean isSingle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_bg);
        setCanceledOnTouchOutside(false);
        initView();
        refreshView();
        initEvent();
    }

    private void initEvent() {
        positiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener != null) {
                    onClickBottomListener.onPositiveClick();
                }
            }
        });
        negtiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener != null) {
                    onClickBottomListener.onNegtiveClick();
                }
            }
        });
    }

    private void refreshView() {
        if (!TextUtils.isEmpty(title)) {
            titleTv.setText(title);
            titleTv.setVisibility(View.VISIBLE);
        } else {
            titleTv.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(message)) {
            messageTv.setText(message);
        }
        if (!TextUtils.isEmpty(positive)) {
            positiveBn.setText(positive);
        } else {
            positiveBn.setText("确定");
        }
        if (!TextUtils.isEmpty(negtive)) {
            negtiveBn.setText(negtive);
        } else {
            negtiveBn.setText("取消");
        }

        if (imageResId != -1) {
            imageIv.setImageResource(imageResId);
            imageIv.setVisibility(View.VISIBLE);
        } else {
            imageIv.setVisibility(View.GONE);
        }

        if (isSingle) {
            columnLineView.setVisibility(View.GONE);
            negtiveBn.setVisibility(View.GONE);
        } else {
            negtiveBn.setVisibility(View.VISIBLE);
            columnLineView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void show() {
        super.show();
        refreshView();
    }

    private void initView() {
        negtiveBn = findViewById(R.id.negtive);
        positiveBn = findViewById(R.id.positive);
        titleTv = findViewById(R.id.title);
        messageTv = findViewById(R.id.message);
        imageIv = findViewById(R.id.image);
        columnLineView = findViewById(R.id.column_line);
    }

    public OnClickBottomListener onClickBottomListener;

    public CommonDialog setOnClickBottomListener(OnClickBottomListener onClickBottomListener) {
        this.onClickBottomListener = onClickBottomListener;
        return this;
    }

    public interface OnClickBottomListener {

        public void onPositiveClick();

        public void onNegtiveClick();
    }

    public String getMessage() {
        return message;
    }

    public CommonDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CommonDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPositive() {
        return positive;
    }

    public CommonDialog setPositive(String positive) {
        this.positive = positive;
        return this;
    }

    public String getNegtive() {
        return negtive;
    }

    public CommonDialog setNegtive(String negtive) {
        this.negtive = negtive;
        return this;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public CommonDialog setSingle(boolean single) {
        isSingle = single;
        return this;
    }

    public CommonDialog setImageResId(int imageResId) {
        this.imageResId = imageResId;
        return this;
    }
}
