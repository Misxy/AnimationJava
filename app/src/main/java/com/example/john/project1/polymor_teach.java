package com.example.john.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by John on 11/8/2016.
 */

public class polymor_teach extends AppCompatActivity {
    ImageButton goPoly_animation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutpolymor);
        goPoly_animation = (ImageButton)findViewById(R.id.goDatahide);
        goPoly_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(polymor_teach.this,polymor_animation.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,List_chapter.class);
        startActivity(intent);
        finish();
    }
}
