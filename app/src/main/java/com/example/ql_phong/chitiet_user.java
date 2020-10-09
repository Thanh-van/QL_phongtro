package com.example.ql_phong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ql_phong.nguoithue.Adater_nguoithue;
import com.example.ql_phong.nguoithue.Data_nguoithue;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class chitiet_user extends AppCompatActivity {

    TextView ten_nt;
    TextView cmt;
    TextView ngaysinh;
    RadioButton Nam;
    RadioButton nu;
    TextView email;
    TextView sdt;
    TextView quequan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_user);
        Intent intent= getIntent();
        Toast.makeText(this, intent.getStringExtra("ID"), Toast.LENGTH_SHORT).show();
        AnhXa();
        Getdata(intent.getStringExtra("ID"));
    }
    void AnhXa()
    {
        ten_nt=findViewById(R.id.ten_nt);
        cmt=findViewById(R.id.cmt);
        ngaysinh=findViewById(R.id.ngaysinh);
        Nam=findViewById(R.id.nam);
        nu=findViewById(R.id.nu);
        email=findViewById(R.id.email);
        sdt=findViewById(R.id.sdt);
        quequan=findViewById(R.id.quequan);
    }
    void Update(JSONArray jsonArray)
    {
        for (int i=0;i<jsonArray.length();i++)
        {
            try {
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                System.out.println(jsonObject);
                ten_nt.setText(jsonObject.getString("ten_nt"));
                cmt.setText(jsonObject.getString("cmt"));
                ngaysinh.setText(jsonObject.getString("ngaysinh"));
                Nam.setText(jsonObject.getString(""));
                nu.setText(jsonObject.getString(""));
                email.setText(jsonObject.getString("email"));
                sdt.setText(jsonObject.getString("sdt"));
                quequan.setText(jsonObject.getString("quequan"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    void Getdata(String ur)
    {
        try {
            RequestQueue queue = Volley.newRequestQueue(this);

            String url = "http://192.168.1.124:8080/BTTCS/?action=nguoi_thue_id&key="+ur;
            Log.d("TAG", url);
            JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Update(response);
                        }
                    },

                    new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    });

            queue.add(arrayRequest);
        } catch (Exception e) {
            Log.d("TAG", e.toString());
            e.printStackTrace();
        }
    }
}