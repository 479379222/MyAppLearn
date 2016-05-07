package com.example.jason.myapplearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CircleimageActivity extends AppCompatActivity {

    private ListView circleimageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circleimage);

        initView();

        SimpleAdapter adapter=new SimpleAdapter(this,getData(),R.layout.item_user,new String[]{
                "circleUser","title","subtitle"
        },new int[]{
                R.id.circleUser,R.id.txtTitle,R.id.txtSubTitle
        });

        circleimageview.setAdapter(adapter);
        circleimageview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CircleimageActivity.this,getData().get(position).get("title").toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(){
        circleimageview=(ListView)findViewById(R.id.lstViewUser);
    }

    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> lstUser=new ArrayList<>();

        Map<String,Object> map=new HashMap<>();
        map.put("circleUser", R.mipmap.hugh);
        map.put("title", "乔布斯");
        map.put("subtitle", "乔布斯是苹果公司CEO,是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.mht);
        map.put("title", "马化腾");
        map.put("subtitle", "马化腾是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.mayun);
        map.put("title", "马云");
        map.put("subtitle", "马云是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.wjl);
        map.put("title", "王健林");
        map.put("subtitle", "王健林是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.lqd);
        map.put("title", "刘强东");
        map.put("subtitle", "刘强东是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.hugh);
        map.put("title", "乔布斯");
        map.put("subtitle", "乔布斯是苹果公司CEO,是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.mht);
        map.put("title", "马化腾");
        map.put("subtitle", "马化腾是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.mayun);
        map.put("title", "马云");
        map.put("subtitle", "马云是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.mht);
        map.put("title", "马化腾");
        map.put("subtitle", "马化腾是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.mayun);
        map.put("title", "马云");
        map.put("subtitle", "马云是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.wjl);
        map.put("title", "王健林");
        map.put("subtitle", "王健林是一代...");
        lstUser.add(map);

        map = new HashMap<>();
        map.put("circleUser", R.mipmap.lqd);
        map.put("title", "刘强东");
        map.put("subtitle", "刘强东是一代...");
        lstUser.add(map);

        return lstUser;

    }
}
