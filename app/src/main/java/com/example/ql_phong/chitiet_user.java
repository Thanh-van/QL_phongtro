package com.example.ql_phong;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class chitiet_user extends AppCompatActivity {

    EditText ten_nt;
    EditText cmt;
    EditText ngaysinh;
    RadioButton Nam;
    RadioButton nu;
    EditText email;
    CallBack callBack;
    EditText sdt;
    EditText quequan;
    ImageView image;
    Toolbar toolbar;
    Intent intent;
    String id;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_user);
        intent = getIntent();
        AnhXa();
        Getdata(intent.getStringExtra("ID"));
        id=intent.getStringExtra("ID");
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    void AnhXa()
    {
        image=findViewById(R.id.anh);
        ten_nt=findViewById(R.id.ten_nt);
        cmt=findViewById(R.id.cmt);
        ngaysinh=findViewById(R.id.ngaysinh);
        Nam=findViewById(R.id.nam);
        nu=findViewById(R.id.nu);
        email=findViewById(R.id.email);
        sdt=findViewById(R.id.sdt);
        quequan=findViewById(R.id.que);
        toolbar=findViewById(R.id.toolbar);
    }
    void Update(JSONArray jsonArray)
    {
        for (int i=0;i<jsonArray.length();i++)
        {
            try {
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                System.out.println(jsonObject);
                Glide.with(chitiet_user.this)
                        .load(jsonObject.getString("anh"))
                        .into(image);
                ten_nt.setText(jsonObject.getString("ten_nt"));
                cmt.setText(jsonObject.getString("cmt"));
                ngaysinh.setText(jsonObject.getString("ngaysinh"));
                if (Integer.parseInt(jsonObject.getString("gioitinh"))==0)
                    Nam.setChecked(true);
                else
                    nu.setChecked(true);
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

            String url = "http://192.168.1.124:8080/ql_phongtro/?action=nguoi_thue_id&key="+ur;
            Log.d("TAG", url);
            JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Update(response);
                            Log.d("TAG", String.valueOf(response));

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
    public void sua(View view) {
        String url="http://192.168.1.124:8080/ql_phongtro/?action=update_nguoithue";

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("True"))
                {
                    Toast.makeText(chitiet_user.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                    //callBack.Getdata();
                    final Intent data = new Intent();

                    // Truyền data vào intent


                    // Đặt resultCode là Activity.RESULT_OK to
                    // thể hiện đã thành công và có chứa kết quả trả về
                    setResult(Activity.RESULT_OK, data);

                    // gọi hàm finish() để đóng Activity hiện tại và trở về MainActivity.
                    finish();

                }else{
                    Log.d("Date",ngaysinh.getText().toString());
                    Toast.makeText(chitiet_user.this, "Lỗi Sửa", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(chitiet_user.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> paramt= new HashMap<>();
                paramt.put("id_nt",id);
                paramt.put("ten_nt",ten_nt.getText().toString());
                paramt.put("cmt",cmt.getText().toString());
                paramt.put("ngaysinh",ngaysinh.getText().toString());
                if (Nam.isChecked())
                    paramt.put("gioitinh","0");
                else
                    paramt.put("gioitinh","1");
                paramt.put("email",email.getText().toString());
                paramt.put("sdt",sdt.getText().toString() );
                paramt.put("quequan",quequan.getText().toString());
                return paramt;
            }
        } ;
        requestQueue.add(stringRequest);

    }


    public void SetCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void xoa(View view) {
        String url="http://"+LinkRoter.IP+"/ql_phongtro/?action=delete_nguoithue";
        RequestQueue requestQueue= Volley.newRequestQueue(this);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("True"))
                {
                    Toast.makeText(chitiet_user.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    //callBack.Getdata();
                    final Intent data = new Intent();

                    // Truyền data vào intent


                    // Đặt resultCode là Activity.RESULT_OK to
                    // thể hiện đã thành công và có chứa kết quả trả về
                    setResult(Activity.RESULT_OK, data);

                    // gọi hàm finish() để đóng Activity hiện tại và trở về MainActivity.
                    finish();

                }else{
                    Log.d("Date",ngaysinh.getText().toString());
                    Toast.makeText(chitiet_user.this, "Lỗi Xóa", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(chitiet_user.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> paramt= new HashMap<>();
                paramt.put("id_nt",id);
                return paramt;
            }
        } ;
        requestQueue.add(stringRequest);
    }
}