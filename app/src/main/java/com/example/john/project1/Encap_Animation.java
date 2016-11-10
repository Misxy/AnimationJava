package com.example.john.project1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Encap_Animation extends AppCompatActivity {
    ImageView pointer;
    ImageButton playbtnEncap,PauseBtnEncap,StopBtnEncap;
    ObjectAnimator line11,line13,line1,line13_1,line14,line6,line7,line8,line14_1,line15,line3,line4,line5;
    AnimatorSet movingAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encap__animation);
        pointer = (ImageView)findViewById(R.id.pointer_encap);
        playbtnEncap = (ImageButton)findViewById(R.id.playbtnEncap);
        PauseBtnEncap = (ImageButton)findViewById(R.id.pausebtnEncap);
        StopBtnEncap = (ImageButton)findViewById(R.id.stopbtn_encap);

        //play btn
        playbtnEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Encap_Animation.this, "Start!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void GoLine11(int distance)
    {
        ObjectAnimator obj = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,distance);
        obj.setDuration(2000);
        obj.start();
    }
}
