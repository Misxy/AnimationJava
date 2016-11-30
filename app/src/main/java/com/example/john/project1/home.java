package com.example.john.project1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by John on 9/20/2016.
 */

public class home extends AppCompatActivity {
    ImageButton btn_Go,btn_Test,btn_Score,btn_Exit;
    MediaPlayer mp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layouthome);
        btn_Go = (ImageButton)findViewById(R.id.imageButton14);
        btn_Test= (ImageButton)findViewById(R.id.imageButton15);
        //Going to Chapter_List page
        btn_Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,List_chapter.class);
                startActivity(intent);
                //Closing this layout
                finish();
            }
        });
        //going to test'layout
        btn_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,MainActivity.class);
                startActivity(intent);
                //Closing this layout
                finish();
            }
        });
         
    }
}
