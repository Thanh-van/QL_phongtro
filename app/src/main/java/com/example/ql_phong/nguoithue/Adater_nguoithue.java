package com.example.ql_phong.nguoithue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ql_phong.R;

import java.util.ArrayList;

public class Adater_nguoithue extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Data_nguoithue> arrayList;
    nguoithueFragment fragment ;
    public Adater_nguoithue(Context context, int layout, ArrayList<Data_nguoithue> arrayList , nguoithueFragment fragment) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        ImageView imageView = convertView.findViewById(R.id.img_user);

        TextView textView = convertView.findViewById(R.id.name_user);

        TextView textView1 = convertView.findViewById(R.id.phone_user);

        TextView textView2 = convertView.findViewById(R.id.phong_user);

        imageView.setImageResource(arrayList.get(position).getImg());

        textView.setText(arrayList.get(position).getName());
        textView1.setText(arrayList.get(position).getPhone());
        textView2.setText(arrayList.get(position).getPhong());

        ImageView imageCall = convertView.findViewById(R.id.btnCall);

        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.ClickCallUser(position);
            }
        });
        return convertView;
    }
}
