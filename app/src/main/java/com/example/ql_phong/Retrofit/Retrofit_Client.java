package com.example.ql_phong.Retrofit;

import retrofit2.Retrofit;

public class Retrofit_Client {

    public static Retrofit retrofit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.124:8080/BTTCS/?action=nguoi_thue")
                .build();
        Retrofit_Data service = retrofit.create(Retrofit_Data.class);
        return  retrofit;
    }


}
