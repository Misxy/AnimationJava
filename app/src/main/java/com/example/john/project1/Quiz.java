package com.example.john.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by John on 9/20/2016.
 */

public class Quiz extends AppCompatActivity {
    Button btn_choiceA, btn_choiceB, btn_choiceC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutquiz);
        btn_choiceA = (Button) findViewById(R.id.button);
        btn_choiceB = (Button) findViewById(R.id.button2);
        btn_choiceC = (Button) findViewById(R.id.button3);

        //Chosing choiceA
        btn_choiceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, Quiz_Incorrect.class);
                startActivity(intent);
                finish();
            }
        });

        //Chosing choiceB
        btn_choiceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, Quiz_Incorrect.class);
                startActivity(intent);
                finish();
            }
        });

        //Chosing choiceC
        btn_choiceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, Quiz_Correct.class);
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
        Intent intent = new Intent(Quiz.this, home.class);
        startActivity(intent);
        finish();
    }
}
