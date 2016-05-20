package com.example.jason.myapplearn.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jason.myapplearn.R;
import com.example.jason.myapplearn.dialog.CustomProgressDialog;
import com.example.jason.myapplearn.utils.ToastUtils;

public class LoadingActivity extends AppCompatActivity {

    private Button btnmeituan,btnshunfeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        btnmeituan=(Button)findViewById(R.id.btnmeituan);
        btnshunfeng=(Button)findViewById(R.id.btnshunfeng);
    }

    /**
     * 显示美团进度对话框
     * @param v
     */
    public void showmeidialog(View v){
        CustomProgressDialog dialog =new CustomProgressDialog(this, "正在加载中",R.anim.frame);
        dialog.show();
        ToastUtils.showLong(LoadingActivity.this,"直通车");
    }
    /**
     * 显示顺丰快递员进度对话框
     * @param v
     */
    public void showsfdialog(View v){
        CustomProgressDialog dialog =new CustomProgressDialog(this, "正在加载中",R.anim.frame2);
        dialog.show();
    }

    public void mobiletest(View v){
        CustomProgressDialog dialog =new CustomProgressDialog(this, "正在加载中",R.anim.frame3);
        dialog.show();
    }
}
