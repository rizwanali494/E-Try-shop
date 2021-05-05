package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Mainsplash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mainsplash);
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                sta();
                finish();
            }
        },3000);
    }
    public void sta(){

        try {

            startActivity(new Intent(this,MainActivity.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}