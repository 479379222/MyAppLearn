package com.example.jason.myapplearn.view;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jason.myapplearn.R;

public class AnimationActivity extends AppCompatActivity {

    private ImageView imgView;
    private Button btnShunxu,btnStop,btnDaoxu;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();
        btnShunxu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(R.drawable.xinhao);
                animationDrawable = (AnimationDrawable) imgView.getDrawable();
                animationDrawable.start();
            }
        });

        btnShunxu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable = (AnimationDrawable) imgView.getDrawable();
                animationDrawable.stop();
            }
        });

        btnDaoxu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //imgView.setImageResource(R.drawable.animation2);
                animationDrawable = (AnimationDrawable) imgView.getDrawable();
                animationDrawable.start();

            }
        });

    }

    private void initView(){
        btnShunxu=(Button)findViewById(R.id.btnShunxu);
        btnStop=(Button)findViewById(R.id.btnStop);
        btnDaoxu=(Button)findViewById(R.id.btnDaoxu);
        imgView=(ImageView)findViewById(R.id.imgView);
    }

}
