package com.example.jason.myapplearn.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jason.myapplearn.R;
import com.example.jason.myapplearn.entity.Person;
import com.example.jason.myapplearn.utils.ToastUtils;

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
                SQLiteDatabase db=openOrCreateDatabase("test.db", Context.MODE_PRIVATE,null);
                db.execSQL("DROP TABLE IF EXISTS person");
                //创建person表
                db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");
                Person person = new Person();
                person.name = "john";
                person.age = 30;
                //插入数据
                db.execSQL("INSERT INTO person VALUES (NULL, ?, ?)", new Object[]{person.name, person.age});

                person.name = "david";
                person.age = 33;
                //ContentValues以键值对的形式存放数据
                ContentValues cv = new ContentValues();
                cv.put("name", person.name);
                cv.put("age", person.age);
                //插入ContentValues中的数据
                db.insert("person", null, cv);

                cv = new ContentValues();
                cv.put("age", 35);
                //更新数据
                db.update("person", cv, "name = ?", new String[]{"john"});

                Cursor c = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"33"});
                while (c.moveToNext()) {
                    int _id = c.getInt(c.getColumnIndex("_id"));
                    String name = c.getString(c.getColumnIndex("name"));
                    int age = c.getInt(c.getColumnIndex("age"));
                    Log.i("db", "_id=>" + _id + ", name=>" + name + ", age=>" + age);
                }
                c.close();

                //删除数据
                db.delete("person", "age < ?", new String[]{"35"});

                //关闭当前数据库
                db.close();

                ToastUtils.showLong(SqliteActivity.this,"Sqlite test,行数：!"+c.getCount());

            }
        });

    }

    private void initView(){
        btnSqliteCreate=(Button)findViewById(R.id.btnSqliteCreate);
        txtViewInfo=(TextView)findViewById(R.id.txtViewInfo);
    }
}
