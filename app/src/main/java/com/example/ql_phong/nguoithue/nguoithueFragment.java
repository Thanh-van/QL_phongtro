package com.example.ql_phong.nguoithue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ql_phong.MainActivity;
import com.example.ql_phong.R;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class nguoithueFragment extends Fragment {

    View root;
    ListView listView;
    Adater_nguoithue adater;
    ArrayList<Data_nguoithue> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_nguoithue, container, false);
        listView = root.findViewById(R.id.list_nguoithue);
        System.out.println(listView);
        arrayList = new ArrayList<>();
        try {
            for (int i = 0 ; i < 10 ; i++)
            arrayList.add(new Data_nguoithue(R.drawable.van, "Bùi Thanh Văn", "0349.085.518", "Phòng 197"));
            adater = new Adater_nguoithue(root.getContext(), R.layout.list_custom_nguoithue, arrayList, this);
            listView.setAdapter(adater);
        } catch (Exception e) {
            Toast.makeText(root.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        return root;

    }

    public  void ClickCallUser(int position){
        System.out.println(position);
    }

}
