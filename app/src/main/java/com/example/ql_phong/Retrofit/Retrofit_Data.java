package com.example.ql_phong.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface Retrofit_Data {
    @GET("/posts")
    Call<List<Post>> getPost();
}
