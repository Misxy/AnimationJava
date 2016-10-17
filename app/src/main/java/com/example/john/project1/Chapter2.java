package com.example.john.project1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Chapter2 extends AppCompatActivity {
    ImageButton playbtn,stopbtn,pausebtn;
    ImageView pointer,pic_class_chap2;
    ScrollView sv_code;
    LinearLayout layoutcode;
    Thread t1,t2;
    Boolean checkScrolling=false;
    String checkStateChap2="";
    TextView num1,num2,sign,result,text_returnChap2,
            output_text,text_num1,text_num2,object,
            text_plus,text_minus,text_multi,text_divide,class_chap2;
    AnimatorSet amMovingNum,amMovingNum2;
    ObjectAnimator objline1,objline2,objline3,objline17
            ,objline29,objline30,objline31,
            objline32,objline18,objline3_1,objline5,objline35,objline5_1,objLine6,objLine7,
            objLine39,objLine7_1,objLine8,objLine9,objLine20,objLine9_1,objLine10,objLine11,objLine23,objLine11_1,objLine12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        playbtn =(ImageButton)findViewById(R.id.playbtnChap2);
        pausebtn =(ImageButton)findViewById(R.id.pausebtnChap2);
        stopbtn =(ImageButton)findViewById(R.id.stopbtnChap2);
        pointer =(ImageView)findViewById(R.id.pointer);
        sv_code = (ScrollView)findViewById(R.id.sv_code);
        layoutcode = (LinearLayout)findViewById(R.id.layout_code2);
        num1 = (TextView)findViewById(R.id.num1_chap2);
        num2 = (TextView)findViewById(R.id.num2_chap2);
        sign = (TextView)findViewById(R.id.sign_chap2);
        result = (TextView)findViewById(R.id.result_chap2);
        text_returnChap2 = (TextView)findViewById(R.id.text_return_chap2);
        output_text =(TextView)findViewById(R.id.result_chap2_text);
        object = (TextView)findViewById(R.id.object);
        text_num1 = (TextView)findViewById(R.id.text_num1);
        text_num2 = (TextView)findViewById(R.id.text_num2);
        text_plus = (TextView)findViewById(R.id.text_plus);
        text_minus = (TextView)findViewById(R.id.text_minus);
        text_multi =(TextView)findViewById(R.id.text_multi);
        text_divide =(TextView)findViewById(R.id.text_divide);
        pic_class_chap2 =(ImageView)findViewById(R.id.pic_class_chap2);
        class_chap2 = (TextView)findViewById(R.id.class_chap2);
        sv_code.scrollTo(0,0);
        prepare();
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Chapter2.this, "Start!", Toast.LENGTH_SHORT).show();
                testPointerLine1();
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    //Method Prepare to hide all of objects
    private void prepare()
    {
        pic_class_chap2.setVisibility(View.INVISIBLE);
        text_returnChap2.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        num1.setVisibility(View.INVISIBLE);
        num2.setVisibility(View.INVISIBLE);
        sign.setVisibility(View.INVISIBLE);
        object.setVisibility(View.INVISIBLE);
        output_text.setVisibility(View.INVISIBLE);
        text_num1.setVisibility(View.INVISIBLE);
        text_num2.setVisibility(View.INVISIBLE);
        text_plus.setVisibility(View.INVISIBLE);
        text_minus.setVisibility(View.INVISIBLE);
        text_multi.setVisibility(View.INVISIBLE);
        text_divide.setVisibility(View.INVISIBLE);
    }


    private void testPointerLine1()
    {
        checkStateChap2="line1";
        objline1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,0);
        objline1.setDuration(500);
        objline1.start();
        objline1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pic_class_chap2.setVisibility(View.VISIBLE);
                class_chap2.setVisibility(View.VISIBLE);
                testPointerLine2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line2
    private void testPointerLine2()
    {
        objline2 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,60);
        objline2.setDuration(3000);
        objline2.start();
        objline2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                testPointerLine3();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private void testPointerLine3()
    {
        checkStateChap2="line3";
        objline3 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,125);
        objline3.setDuration(2000);
        objline3.setInterpolator(new LinearInterpolator());
        objline3.start();
        objline3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pic_class_chap2.setImageResource(R.drawable.shape_circle_class);
                object.setVisibility(View.VISIBLE);
                num1.setVisibility(View.VISIBLE);
                num2.setVisibility(View.VISIBLE);
                checkingnumbersmoving();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Checking number moving
    private void checkingnumbersmoving()
    {
        checkStateChap2="movingNums";
        ObjectAnimator objnum1_x = ObjectAnimator.ofFloat(num1,View.TRANSLATION_X,250);
        ObjectAnimator objnum1_y = ObjectAnimator.ofFloat(num1,View.TRANSLATION_Y,-350);
        amMovingNum = new AnimatorSet();
        amMovingNum.setDuration(3000);
        amMovingNum.setInterpolator(new LinearInterpolator());
        amMovingNum.playTogether(objnum1_x,objnum1_y);
        amMovingNum.start();
        amMovingNum.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_num1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator objnum2_x = ObjectAnimator.ofFloat(num2,View.TRANSLATION_X,-250);
        ObjectAnimator objnum2_y = ObjectAnimator.ofFloat(num2,View.TRANSLATION_Y,-350);
        amMovingNum2 = new AnimatorSet();
        amMovingNum2.setDuration(3000);
        amMovingNum2.setInterpolator(new LinearInterpolator());
        amMovingNum2.playTogether(objnum2_x,objnum2_y);;
        amMovingNum2.start();
        amMovingNum2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {


            }

            @Override
            public void onAnimationEnd(Animator animator) {
                text_num2.setVisibility(View.VISIBLE);
                scrollingDown(400);
                testPointerLine17();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //Line17
    private void testPointerLine17()
    {
        checkStateChap2="line17";
        objline17 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y,570);
        objline17.setDuration(4000);
        objline17.start();
        objline17.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                num1.setText("0");
                num2.setText("0");
                testScrolling();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line29
    private void testPointerLine29()
    {
        checkStateChap2="line29";
        objline29 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,195);
        objline29.setDuration(2000);
        objline29.start();
        objline29.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                testPointerLine30();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private  void testPointerLine30()
    {
        objline30 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,260);
        objline30.setDuration(2000);
        objline30.start();
        objline30.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                testPointerLine31();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line31
    private void testPointerLine31()
    {
        objline31 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,310);
        objline31.setDuration(2000);
        objline31.start();
        objline31.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                num1.setText("10");
                testPointerLine32();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private void testPointerLine32()
    {
        objline32 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,500);
        objline32.setDuration(2000);
        objline32.start();
        objline32.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                num2.setText("5");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    public void testScrolling()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(checkScrolling)
                {
                    checkScrolling =false;
                    while(!checkScrolling) {
                        try
                        {
                            runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    sv_code.scrollBy(0,1);

                                    if(sv_code.getScrollY()==800)
                                    {
                                        checkScrolling=true;
                                        /*Toast.makeText(Chap1.this, "Stop", Toast.LENGTH_SHORT).show();*/
                                    }
                                }
                            });

                            Thread.sleep(5);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    checkScrolling=true;
                }
            }
        }).start();
    }
    private void scrollingDown(int d)
    {
       final int d1=d;
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
                                    if (sv_code.getScrollY() == 400) {
                                        checkScrolling = true;
                                        Log.d("Thread","Down finished");
                                    }
                                }
                            });
                            Thread.sleep(5);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                            Log.d("Thread","Thread down 1500 have problems");
                        }
                    }
                }
                else
                {
                    checkScrolling=false;
                }
            }
        });t1.start();
    }
    private void scrollingDown2(int d)
    {
        final int d1=d;
        t2 = new Thread(new Runnable() {
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
                                    sv_code.scrollBy(0, -1);
                                    if (sv_code.getScrollY() ==800) {
                                        checkScrolling = true;
                                        Log.d("Thread","Down 800 finished");
                                    }
                                }
                            });
                            Thread.sleep(5);
                        }
                        catch (InterruptedException e)
                        {
                            Log.d("Thread","Thread down have problems");
                        }
                    }
                }
                else
                {
                    checkScrolling=false;
                }
            }
        });t2.start();
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
