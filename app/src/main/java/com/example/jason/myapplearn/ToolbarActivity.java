package com.example.jason.myapplearn;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ToolbarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        ActionBar ab=this.getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);


    }
}
