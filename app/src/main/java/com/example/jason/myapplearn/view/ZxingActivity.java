package com.example.jason.myapplearn.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jason.myapplearn.R;

public class ZxingActivity extends AppCompatActivity {

    private Button btnScan,btnCreateScan;
    private TextView txtViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        initView();
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initView(){
        btnScan=(Button)findViewById(R.id.btnScan);
        btnCreateScan=(Button)findViewById(R.id.btnCreateCode);
        txtViewResult=(TextView)findViewById(R.id.txtScanResult);
    }

}
