package com.example.jason.myapplearn.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.jason.myapplearn.BaseActivity;
import com.example.jason.myapplearn.R;
import com.example.jason.myapplearn.common.SystemBarTintManager;
import com.example.jason.myapplearn.utils.ToastUtils;

public class BottomActivity extends AppCompatActivity {

    private FrameLayout fragment_container;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            //通知栏所需颜色
            tintManager.setStatusBarTintResource(R.color.teal500);

        }*/

        initView();
        inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.fragment_index,null);
        fragment_container.addView(v);

    }

    private void initView() {
        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
    }

    public void onTabClicked(View v) {
        switch (v.getId()) {
            case R.id.re_weixin:
                ToastUtils.showLong(BottomActivity.this, "首页");
                break;
            case R.id.re_weixin1:
                ToastUtils.showLong(BottomActivity.this, "活动");
                break;
            case R.id.re_weixin2:
                ToastUtils.showLong(BottomActivity.this, "分类");
                break;
            case R.id.re_weixin3:
                ToastUtils.showLong(BottomActivity.this, "购物车");
                break;
            case R.id.re_weixin4:
                ToastUtils.showLong(BottomActivity.this, "我的");
                break;
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
