package com.example.ql_phong.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ql_phong.LinkRoter;
import com.example.ql_phong.R;

public class Home_Fragement extends Fragment {

    View root;
    SharedPreferences sP;
    EditText text_ip;
    Button send_ip;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        AnhXa();
        onClick_send_ip();
        sP= root.getContext().getSharedPreferences("LINK_ROTER", Context.MODE_PRIVATE);
        LinkRoter.IP=sP.getString("IP","192.168.1.2");
        return root;
    }

    /// Ánh Xạ Biến
    private void AnhXa()
    {
        send_ip=root.findViewById(R.id.send_ip);
        text_ip=root.findViewById(R.id.text_ip);
    }
    private  void onClick_send_ip()
    {
        Toast.makeText(getActivity(), "Đã Bấm", Toast.LENGTH_SHORT).show();
        send_ip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sP.edit();
                editor.putString("IP",text_ip.getText().toString());
                editor.commit();
            }
        });
    }
}
