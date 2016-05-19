package com.example.jason.myapplearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jason.myapplearn.view.BannerActivity;
import com.example.jason.myapplearn.view.BottomActivity;
import com.example.jason.myapplearn.view.DownloadmanagerActivity;
import com.example.jason.myapplearn.view.DrawerlayoutActivity;
import com.example.jason.myapplearn.view.PtrActivity;
import com.example.jason.myapplearn.view.ReactionbarActivity;
import com.example.jason.myapplearn.view.RegisterActivity;
import com.example.jason.myapplearn.view.SqliteActivity;
import com.example.jason.myapplearn.view.StarActivity;
import com.example.jason.myapplearn.view.VersionUpdateActivity;
import com.example.jason.myapplearn.view.ZxingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstViewSample;
    private SampleConfig[] sampleConfigs = new SampleConfig[]{
            new SampleConfig(R.string.listtest, ListActivity.class),
            new SampleConfig(R.string.colortest, ColorActivity.class),
            new SampleConfig(R.string.inputtext, InputActivity.class),
            new SampleConfig(R.string.volleytest, VolleyActivity.class),
            new SampleConfig(R.string.circleimage, CircleimageActivity.class),
            new SampleConfig(R.string.userinfo, UserActivity.class),
            new SampleConfig(R.string.Zxing, ZxingActivity.class),
            new SampleConfig(R.string.Downloadmanager, DownloadmanagerActivity.class),
            new SampleConfig(R.string.RegisterLayout, RegisterActivity.class),
            new SampleConfig(R.string.SqliteTest, SqliteActivity.class),
            new SampleConfig(R.string.UltralPtr, PtrActivity.class),
            new SampleConfig(R.string.Drawerlayout,DrawerlayoutActivity.class),
            new SampleConfig(R.string.Toolbar,ToolbarActivity.class),
            new SampleConfig(R.string.Bottom,BottomActivity.class),
            new SampleConfig(R.string.RedActionbar, ReactionbarActivity.class),
            new SampleConfig(R.string.VersionUpdate, VersionUpdateActivity.class),
            new SampleConfig(R.string.Banner, BannerActivity.class),
            new SampleConfig(R.string.Star, StarActivity.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();

        lstViewSample.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getTitles()));
        lstViewSample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, sampleConfigs[position].TargetClass);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        lstViewSample = (ListView) findViewById(R.id.lstViewSample);
    }

    private List<String> getTitles() {
        List<String> lstSample = new ArrayList<>();
        for (SampleConfig sampleConfig : sampleConfigs) {
            lstSample.add(getString(sampleConfig.TitleID));
        }
        return lstSample;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static class SampleConfig {
        private int TitleID;
        private Class TargetClass;

        public SampleConfig(int TitleID, Class TargetClass) {
            this.TitleID = TitleID;
            this.TargetClass = TargetClass;
        }
    }
}
