package com.example.john.project1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FirstPage extends AppCompatActivity {
    //Declaring ImageButton's object
    ImageButton btn_learn, btn_practice, btn_analysis;
    //Declaring Mediaplayer's object
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        //using findViewById() on btn_learn
        btn_learn = (ImageButton) findViewById(R.id.btnLearn);
        //using setOnClickListener's method
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calling method name 'gotoJava'
                gotoJava();
            }
        });
    }

    //Go to content list page
    private void gotoJava() {
        //Creating intent class
        Intent intent = new Intent(FirstPage.this, Content.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
