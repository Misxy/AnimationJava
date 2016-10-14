package com.example.john.project1;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class Chapter2 extends AppCompatActivity {
    ImageButton playbtn,stopbtn;
    ImageView pointer;
    ScrollView sv_code;
    LinearLayout layoutcode;
    String a;
    int b;
    Thread t1;
    Boolean checkScrolling=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        playbtn =(ImageButton)findViewById(R.id.playbtnChap2);
        stopbtn =(ImageButton)findViewById(R.id.stopbtnChap2);
        pointer =(ImageView)findViewById(R.id.pointer);
        sv_code = (ScrollView)findViewById(R.id.sv_code);
        layoutcode = (LinearLayout)findViewById(R.id.layout_code2);

        sv_code.scrollTo(0,0);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                testPointer();
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollingDown();
            }
        });
    }
    private void testPointer()
    {

        ObjectAnimator objpointer = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,500);
        objpointer.setDuration(2000);
        objpointer.setInterpolator(new LinearInterpolator());
        objpointer.start();
    }
    private void scrollingDown()
    {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!checkScrolling)
                {
                    while (!checkScrolling)
                    {
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sv_code.scrollBy(0, 1);
                                    if (sv_code.getScrollY() == 800) {
                                        checkScrolling = true;
                                        Log.d("Tag","Stopped");
                                    }
                                }
                            });
                            Thread.sleep(5);
                        }
                        catch (InterruptedException e)
                        {
                            Log.d("Thread","Thread have problems");
                        }
                    }
                }
                else
                {
                    checkScrolling=false;
                }
            }
        });
        t1.start();
    }
    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,List_chapter.class);
        startActivity(intent);
        finish();
    }
}
