package com.example.jason.myapplearn.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jason.myapplearn.R;

public class SqliteActivity extends AppCompatActivity {

    private Button btnSqliteCreate;
    private TextView txtViewInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        initView();
        btnSqliteCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SqliteUtils.getInstance(SqliteActivity.this);

            }
        });

    }

    private void initView(){
        btnSqliteCreate=(Button)findViewById(R.id.btnSqliteCreate);
        txtViewInfo=(TextView)findViewById(R.id.txtViewInfo);
    }
}
