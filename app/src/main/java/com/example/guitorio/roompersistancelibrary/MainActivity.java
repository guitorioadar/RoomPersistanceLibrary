package com.example.guitorio.roompersistancelibrary;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    public static MyAppDatabase myAppDatabse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        myAppDatabse = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"user_db").build();
        //myAppDatabse = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"user_db").build();
        Log.d("Database", "onCreate: Database Created...");

        if(findViewById(R.id.fragmentContainer) != null){
            if(savedInstanceState != null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragmentContainer,new HomeFragment(),null).commit();

        }

    }
}
