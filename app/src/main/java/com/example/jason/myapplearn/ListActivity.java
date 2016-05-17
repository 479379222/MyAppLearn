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

public class ListActivity extends AppCompatActivity {

    private ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();

        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.listitem_user, new String[]{
                "title", "subtitle", "userpic"
        }, new int[]{
                R.id.txtTitle, R.id.txtSubTitle, R.id.imgViewUser
        });
        lstView.setAdapter(adapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this," 测试",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lstView = (ListView) findViewById(R.id.lstViewUser);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> lstUser = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("title", "Summer BBQ 4");
        map.put("subtitle", "Ali Conners");
        map.put("userpic", R.mipmap.user1);
        lstUser.add(map);

        map = new HashMap<>();
        map.put("title", "Brunch this weekend?");
        map.put("subtitle", "Ali Conners");
        map.put("userpic", R.mipmap.user2);
        lstUser.add(map);

        map = new HashMap<>();
        map.put("title", "Oui Oui");
        map.put("subtitle", "andras adams");
        map.put("userpic", R.mipmap.user3);
        lstUser.add(map);

        map = new HashMap<>();
        map.put("title", "Brunch this weekend?");
        map.put("subtitle", "Ali Conners");
        map.put("userpic", R.mipmap.user2);
        lstUser.add(map);

        map = new HashMap<>();
        map.put("title", "Summer BBQ 4");
        map.put("subtitle", "Ali Conners");
        map.put("userpic", R.mipmap.user1);
        lstUser.add(map);

        map = new HashMap<>();
        map.put("title", "Summer BBQ 4");
        map.put("subtitle", "Ali Conners");
        map.put("userpic", R.mipmap.user1);
        lstUser.add(map);

        map = new HashMap<>();
        map.put("title", "Brunch this weekend?");
        map.put("subtitle", "Ali Conners");
        map.put("userpic", R.mipmap.user2);
        lstUser.add(map);

        return lstUser;

    }
}
