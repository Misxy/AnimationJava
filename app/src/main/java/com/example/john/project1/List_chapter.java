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
    ImageButton buttonChapter1,buttonChapter5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chapter);
        buttonChapter1=(ImageButton)findViewById(R.id.Chapter1);
        buttonChapter5 = (ImageButton)findViewById(R.id.Chapter5);
        buttonChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this,Java_Detail.class);
                startActivity(intent);
                finish();
            }
        });
        //button2
        buttonChapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_chapter.this,Chapter2.class);
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
        Intent intent = new Intent(List_chapter.this,home.class);
        startActivity(intent);
        finish();
    }
}
