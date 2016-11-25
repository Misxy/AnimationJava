package com.example.john.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

public class dh_animation extends AppCompatActivity {
    ImageView pointer;
    ImageButton playbtn,pausebtn,stopbtn;
    ScrollView sv_codeDH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dh_animation);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,List_chapter.class);
        startActivity(intent);
        finish();
    }
}
