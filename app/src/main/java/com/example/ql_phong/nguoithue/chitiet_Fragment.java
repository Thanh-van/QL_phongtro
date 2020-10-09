package com.example.ql_phong.nguoithue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ql_phong.R;

public class chitiet_Fragment extends Fragment {

    View rooView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rooView=inflater.inflate(R.layout.fragment_chitietuser,container,false);

        return rooView;
    }
}
