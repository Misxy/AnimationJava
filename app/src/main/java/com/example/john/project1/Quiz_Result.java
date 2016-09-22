package com.example.john.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by John on 9/20/2016.
 */

public class Quiz_Result extends AppCompatActivity {
    Button btn4,btn5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutresult);
        btn4=(Button)findViewById(R.id.button4);
        btn5 =(Button)findViewById(R.id.button5);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Result.this,Quiz.class);
                startActivity(intent);
                finish();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Result.this,java_stat.class);
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
        Intent intent = new Intent(this,home.class);
        startActivity(intent);
        finish();
    }
}
