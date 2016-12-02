package com.example.john.project1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Content extends AppCompatActivity {
    ImageButton btn_chap1; //Creating objects Imagebutton
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        //Using findViewById
        btn_chap1 = (ImageButton) findViewById(R.id.btn_chap1);
        //Using function 'SetonClickListener'
        btn_chap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Call function 'Chap1'
                Chap1();
            }
        });
    }

    private void Chap1() {
        intent = new Intent(Content.this, Chap1.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Going back to FirstPage's Activity
        intent = new Intent(this, FirstPage.class);
        startActivity(intent);
        finish();
    }
}
