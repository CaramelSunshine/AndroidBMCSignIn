package com.projectindigo.case_study_android_apps.UI;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projectindigo.case_study_android_apps.R;

public class Splash extends AppCompatActivity {
    private int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
        Intent mIntent = new Intent(Splash.this, MainActivity.class);
        startActivity(mIntent);
        finish();
            }
        },SPLASH_TIME_OUT);
    }
}
