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

            } else {

            }
        }
    };

}
