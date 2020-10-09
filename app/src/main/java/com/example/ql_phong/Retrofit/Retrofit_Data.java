package com.example.ql_phong.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface Retrofit_Data {
    @GET("/BTTCS/?action=nguoi_thue")
    Call<String> listRepos();
}
