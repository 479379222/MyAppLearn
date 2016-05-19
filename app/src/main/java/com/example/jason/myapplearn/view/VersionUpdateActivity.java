package com.example.jason.myapplearn.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jason.myapplearn.R;
import com.example.jason.myapplearn.common.UpdateManager;

public class VersionUpdateActivity extends AppCompatActivity {

    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_update);

        initView();
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateManager manager = new UpdateManager(VersionUpdateActivity.this);
                // 检查软件更新
                manager.checkUpdate();
            }
        });

        //version.xml 内容
/*      <update>
        <version>2</version>
        <name>baidu_xinwen_1.1.0</name>
        <url>http://www.cheer-edu.net/UpdateSoftDemo.apk</url>
        </update>*/
    }

    private void initView() {
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
    }
}
