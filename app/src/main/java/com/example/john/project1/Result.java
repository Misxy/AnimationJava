
package com.example.john.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView scoreshow, est_string;
        Bundle bundle = getIntent().getExtras();
        int score_int = bundle.getInt("myScore");
        String estimate;
        scoreshow = (TextView) findViewById(R.id.textView7);
        est_string = (TextView) findViewById(R.id.textView);
        scoreshow.setText("คะแนน = " + String.valueOf(score_int) + "/10");
        if (score_int >= 9) {
            est_string.setText("ดีเยี่ยม");
        } else if (score_int >= 6) {
            est_string.setText("ดี");
        } else if (score_int >= 3) {
            est_string.setText("ปานกลาง");
        } else {
            est_string.setText("ควรปรับปรุง");
        }
        Button btn_quiz;
        btn_quiz = (Button) findViewById(R.id.button2);
        btn_quiz.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(Result.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
        finish();
    }
}

