package com.example.jason.myapplearn.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jason.myapplearn.R;

public class ProgressDialogActivity extends AppCompatActivity {

    private Button button3, button4;
    private ProgressDialog myDialog;
    private Context context;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

        initView();
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
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
                circle();
            } else {
                rec();
            }
        }
    };

    /**
     * 圆形进度条测试..
     */
    public void circle() {
        myDialog = new ProgressDialog(context); // 获取对象
        myDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // 设置样式为圆形样式
        myDialog.setTitle("友情提示"); // 设置进度条的标题信息
        myDialog.setMessage("数据加载中，请稍后..."); // 设置进度条的提示信息
        myDialog.setIcon(R.mipmap.ic_launcher); // 设置进度条的图标
        myDialog.setIndeterminate(false); // 设置进度条是否为不明确
        myDialog.setCancelable(true); // 设置进度条是否按返回键取消

        // 为进度条添加确定按钮 ， 并添加单机事件
        myDialog.setButton("确定", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                myDialog.cancel(); // 撤销进度条
            }
        });

        myDialog.show(); // 显示进度条
    }

    /**
     * 矩形进度条测试...
     */
    public void rec() {

        myDialog = new ProgressDialog(context); // 得到一个对象
        myDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); // 设置为矩形进度条
        myDialog.setTitle("提示");
        myDialog.setMessage("数据加载中，请稍后...");
        myDialog.setIcon(R.mipmap.ic_launcher);
        myDialog.setIndeterminate(false); // 设置进度条是否为不明确
        myDialog.setCancelable(true);
        myDialog.setMax(200); // 设置进度条的最大值
        myDialog.setProgress(0); // 设置当前默认进度为 0
        myDialog.setSecondaryProgress(1000); // 设置第二条进度值为100

        // 为进度条添加取消按钮
        myDialog.setButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                myDialog.cancel();
            }
        });

        myDialog.show(); // 显示进度条
        new Thread() {
            public void run() {
                while (count <= 200) {
                    myDialog.setProgress(count++);
                    try {
                        Thread.sleep(100);  //暂停 0.1秒
                    } catch (Exception e) {
                        Log.i("msg", "线程异常..");
                    }
                }
            }
        }.start();

    }

}
