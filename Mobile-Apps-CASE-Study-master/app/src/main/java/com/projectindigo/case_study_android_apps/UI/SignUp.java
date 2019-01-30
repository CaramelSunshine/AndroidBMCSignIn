package com.projectindigo.case_study_android_apps.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.projectindigo.case_study_android_apps.R;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void Cancel(View v){
        Intent mIntent = new Intent(SignUp.this, Home_Screen.class);
        startActivity(mIntent);
    }

    public void Next(View v){
        Intent mIntent = new Intent(SignUp.this, Reason_For_Visit.class);
        startActivity(mIntent);
    }
}
