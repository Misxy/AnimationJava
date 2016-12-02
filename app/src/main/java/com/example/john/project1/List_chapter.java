package com.example.john.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by John on 9/20/2016.
 */

public class List_chapter extends AppCompatActivity {
    ImageButton buttonChapter1, buttonChapter2, buttonChapter5, buttonChapter3, buttonChapter4, buttonChapter6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chapter);
        buttonChapter1 = (ImageButton) findViewById(R.id.Chapter1);
        buttonChapter2 = (ImageButton) findViewById(R.id.Chapter2);
        buttonChapter3 = (ImageButton) findViewById(R.id.Chapter3);
        buttonChapter4 = (ImageButton) findViewById(R.id.Chapter4);
        buttonChapter5 = (ImageButton) findViewById(R.id.Chapter5);
        buttonChapter6 = (ImageButton) findViewById(R.id.Chapter6);

        buttonChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this, Java_Detail.class);
                startActivity(intent);
                finish();
            }
        });
        //button2
        buttonChapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this, inheritance_teach.class);
                startActivity(intent);
                finish();
            }
        });
        //button5
        buttonChapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this, constructor_teach.class);
                startActivity(intent);
                finish();
            }
        });
        //button3
        buttonChapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this, encap_teach.class);
                startActivity(intent);
                finish();
            }
        });
        //button4
        buttonChapter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this, datahide_teach.class);
                startActivity(intent);
                finish();
            }
        });
        //button6
        buttonChapter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this, polymor_teach.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(List_chapter.this, home.class);
        startActivity(intent);
        finish();
    }
}
