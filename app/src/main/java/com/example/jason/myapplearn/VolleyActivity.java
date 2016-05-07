package com.example.jason.myapplearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class VolleyActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnWeather;
    private TextView txtViewWeather,txtViewCity,txtViewWendu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        initView();

        final RequestQueue queue = Volley.newRequestQueue(this);

        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String URL="http://apicloud.mob.com/v1/weather/query?key=127672e894f58&city=";
                try {
                    URL=URL+URLEncoder.encode("上海","UTF-8");
                    URL=URL+"&province="+URLEncoder.encode("松江","UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        //txtViewWeather.setText(jsonObject.toString());
                        try {
                            String jsoncontent=jsonObject.getString("result");
                            //JSONObject result=new JSONObject(jsoncontent);
                            JSONArray array=new JSONArray(jsoncontent);
                            JSONObject jsonObjectSon= (JSONObject) array.opt(0);
                            txtViewCity.setText("城市："+jsonObjectSon.getString("city"));
                            txtViewWendu.setText("温度："+jsonObjectSon.getString("temperature"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });
                queue.add(request);
            }
        });

    }

    private void initView() {
        editText = (EditText) findViewById(R.id.editText4);
        btnWeather = (Button) findViewById(R.id.btnWeather);
        txtViewWeather = (TextView) findViewById(R.id.txtViewWeather);
        txtViewCity=(TextView)findViewById(R.id.txtViewCity);
        txtViewWendu=(TextView)findViewById(R.id.txtViewWendu);
    }
}
