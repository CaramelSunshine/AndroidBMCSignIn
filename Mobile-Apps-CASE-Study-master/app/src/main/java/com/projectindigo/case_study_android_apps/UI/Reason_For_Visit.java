package com.projectindigo.case_study_android_apps.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.projectindigo.case_study_android_apps.R;

public class Reason_For_Visit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason__for__visit);
    }


    public void Cancel(View v){
        Intent mIntent = new Intent(Reason_For_Visit.this, Home_Screen.class);
        startActivity(mIntent);
    }

    public void Next(View v){
        //Intent mIntent = new Intent(SignUp.this, Signiture.class);
        //startActivity(mIntent);
    }
}
