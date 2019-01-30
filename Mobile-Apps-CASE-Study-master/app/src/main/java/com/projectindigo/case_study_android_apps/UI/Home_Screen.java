package com.projectindigo.case_study_android_apps.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.projectindigo.case_study_android_apps.ExistinguserFragment;
import com.projectindigo.case_study_android_apps.R;

public class Home_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
    }

    public void NewVistor(View v){
        Intent mIntent = new Intent(Home_Screen.this, SignUp.class);
        startActivity(mIntent);
    }

    public void ReturningVistor(View v){
        Intent mIntent = new Intent(Home_Screen.this, ExistinguserFragment.class);
        startActivity(mIntent);
    }

    public void Appointment(View v){
        //Intent mIntent = new Intent(Home_Screen.this, Appointment.class);
        //startActivity(mIntent);
    }
}
