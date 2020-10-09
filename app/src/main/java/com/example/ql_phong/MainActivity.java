package com.example.ql_phong;

import android.os.Bundle;

import com.example.ql_phong.Retrofit.Retrofit_Client;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    com.example.ql_phong.nguoithue.nguoithueFragment nguoithueFragment;
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
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        //nguoithueFragment=new nguoithueFragment();
        //nguoithueFragment.Getdata();

        Retrofit_Client.retrofit();


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