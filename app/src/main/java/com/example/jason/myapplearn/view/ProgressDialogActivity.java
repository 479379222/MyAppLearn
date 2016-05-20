package com.example.jason.myapplearn.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;

import com.example.jason.myapplearn.R;

public class ProgressDialogActivity extends AppCompatActivity {

    private Button button3, button4;
    private ProgressDialog pd1, pd2;
    private Context context;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

        initView();

    }

    private void initView() {
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        context = ProgressDialogActivity.this;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.button3) {
                pd1 = new ProgressDialog(context);
                pd1 = ProgressDialog.show(context, "自动关闭对话框", "Working,,,,,,1秒", true, false);
                Thread thread = new Thread();//开启一个线程来延时
                thread.start();//启动线程
            } else {
                pd1 = new ProgressDialog(context);// 创建ProgressDialog对象
                pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置进度条风格，风格为圆形，旋转的
                pd1.setTitle("提示");// 设置ProgressDialog 标题
                pd1.setMessage("这是一个条状进度条对话框");// 设置ProgressDialog提示信息
                //pd1.setIcon(R.drawable.secondback);// 设置ProgressDialog标题图标
                // 设置ProgressDialog 的进度条是否不明确 false 就是不设置为不明确
                pd1.setIndeterminate(false);
                pd1.setCancelable(true); // 设置ProgressDialog 是否可以按退回键取消
                pd1.setProgress(100);// 设置ProgressDialog 进度条进度
                pd1.show(); // 让ProgressDialog显示
                count = 0;
                new Thread() {
                    public void run() {
                        try {
                            while(count <= 100) {
                                // 由线程来控制进度
                                pd1.setProgress(count++);
                                Thread.sleep(100);
                            }
                            pd1.cancel();
                        } catch (Exception e) {
                            pd1.cancel();
                        }
                    }
                }.start();
            }
        }
    };

}
