package com.projectindigo.case_study_android_apps.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.projectindigo.case_study_android_apps.DBHandler;
import com.projectindigo.case_study_android_apps.PasswordDialog;
import com.projectindigo.case_study_android_apps.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get & set toolbar, icon and Title
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        //Database
        db = new DBHandler(this, null);
        db.getWritableDatabase(); //test
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.admin_portal:
                Intent mIntent = new Intent(MainActivity.this, PasswordDialog.class);
                startActivity(mIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void Signin(View v){
        Intent mIntent = new Intent(MainActivity.this, Home_Screen.class);
        startActivity(mIntent);
    }

    public void Signout(View v){

    }
}
