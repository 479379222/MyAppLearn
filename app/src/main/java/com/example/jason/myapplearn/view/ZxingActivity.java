package com.example.jason.myapplearn.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jason.myapplearn.R;

public class ZxingActivity extends AppCompatActivity {

    private Button btnScan,btnCreateScan;
    private TextView txtViewResult;
    private ImageView imgViewBarCode;
    private final static int SCANNIN_GREQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        initView();
        //点击按钮跳转到二维码扫描界面，这里用的是startActivityForResult跳转
        //扫描完了之后调到该界面
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ZxingActivity.this, CaptureActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SCANNIN_GREQUEST_CODE:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    //显示扫描到的内容
                    txtViewResult.setText(bundle.getString("result"));
                    //显示
                    imgViewBarCode.setImageBitmap((Bitmap) data.getParcelableExtra("bitmap"));
                }
                break;
        }

    }

    private void initView(){
        btnScan=(Button)findViewById(R.id.btnScan);
        btnCreateScan=(Button)findViewById(R.id.btnCreateCode);
        txtViewResult=(TextView)findViewById(R.id.txtScanResult);
        imgViewBarCode=(ImageView)findViewById(R.id.imgViewBarCode);
    }

}
