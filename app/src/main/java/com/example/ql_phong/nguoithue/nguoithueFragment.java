package com.example.ql_phong.nguoithue;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ql_phong.R;
import com.example.ql_phong.chitiet_user;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class nguoithueFragment extends Fragment {

    chitiet_Fragment chitiet;
    View root;
    ListView listView;
    Adater_nguoithue adater;
    ArrayList<Data_nguoithue> arrayList;
    String mPhone;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_nguoithue, container, false);
        listView = root.findViewById(R.id.list_nguoithue);
        // System.out.println(listView);
        arrayList = new ArrayList<>();

        Getdata();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), chitiet_user.class);
                intent.putExtra("ID",arrayList.get(i).id);
                startActivity(intent);
            }
        });

        return root;

    }
    void Getdata()
    {
        try {
            RequestQueue queue = Volley.newRequestQueue(root.getContext());
            String url = "http://192.168.1.124:8080/BTTCS/?action=nguoi_thue";
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
    public void Update(JSONArray jsonArray)
    {
        for (int i=0;i<jsonArray.length();i++)
        {
            try {
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                System.out.println(jsonObject);
                String image=jsonObject.getString("anh");
                arrayList.add(new Data_nguoithue(image, jsonObject.getString("ten_nt"), jsonObject.getString("sdt"), jsonObject.getString("cmt"),jsonObject.getString("id_nt")));
                adater = new Adater_nguoithue(root.getContext(), R.layout.list_custom_nguoithue, arrayList, this);
                listView.setAdapter(adater);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public  void ClickCallUser(int position){
            mPhone = arrayList.get(position).getPhone();
            makePhoneCall(mPhone);
    }

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    public void makePhoneCall(String phone ) {

        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phone));
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + mPhone));
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(intent);
                    }
                }
            }
        }
    }


}
