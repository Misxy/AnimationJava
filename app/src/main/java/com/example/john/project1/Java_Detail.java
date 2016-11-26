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

public class Java_Detail extends AppCompatActivity {
    ImageButton btn_goChap1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdetail);
        btn_goChap1 = (ImageButton)findViewById(R.id.goDatahide);
        btn_goChap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Java_Detail.this,Chap1.class);
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
    Intent intent = new Intent(Java_Detail.this,List_chapter.class);
        startActivity(intent);
        finish();
    }
}
