package com.example.jason.myapplearn.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jason.myapplearn.R;

public class DownloadmanagerActivity extends AppCompatActivity {

    private ImageView imgViewPic;
    private Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloadmanager);

        initView();
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initView(){
        imgViewPic=(ImageView)findViewById(R.id.imgViewPic);
        btnDownload=(Button)findViewById(R.id.btnDownload);
    }
}
