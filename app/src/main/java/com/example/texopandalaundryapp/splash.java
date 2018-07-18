package com.example.texopandalaundryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class splash extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 2000;
    final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_splash);


        if (settings.getBoolean("my_first_time", true)) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(splash.this, walkthrough.class));
                    finish();
                }
            }, SPLASH_TIME_OUT);

            settings.edit().putBoolean("my_first_time", false).commit();
        }
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent = new Intent(splash.this, HomeActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }
    }

