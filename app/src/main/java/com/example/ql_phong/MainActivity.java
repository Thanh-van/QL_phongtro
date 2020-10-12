package com.example.ql_phong;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ql_phong.Retrofit.Post;
import com.example.ql_phong.Retrofit.Retrofit_Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    com.example.ql_phong.nguoithue.nguoithueFragment nguoithueFragment;
    public Toolbar toolbar;
    List<Post> post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_nguoithue)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //nguoithueFragment=new nguoithueFragment();
        //nguoithueFragment.Getdata();

        //Retrofit_Client.retrofit();
        //toolbar.setTitle("Dmm");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Retrofit_Data retrofit_data=retrofit.create(Retrofit_Data.class);

        Call<List<Post>> call= retrofit_data.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                System.out.println(response);
                List<Post> posts=response.body();
                post=posts;
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
        //System.out.println("check : "+post);
        System.out.println("check : ");
    }

    public  void LoadData(){
        new Thread(){
            @Override
            public void run() {
                super.run();

            }
        };
    }

}