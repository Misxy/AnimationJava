package com.example.john.project1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
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


public class Chap1 extends AppCompatActivity {

    //Creating objects.
    Intent intent;
    ImageView imgPointer,pic_class,output;
    ImageButton playbtn,stopbtn,pausebtn;
    ScrollView sv_code;
    LinearLayout layout_code;
    TextView textnum1,textnum2,textResult,textsign,textReturn,text_class,
            text_object,text_construct1,text_construct2,text_result_des,textRes1,textRes2;
    Boolean checkControl = true,checkControlGo=true;//Logically variable for controlling.

    //State for resuming animation
    String  checkState ="";
    //ObjectAnimator's objects
    ObjectAnimator objLine1,objLine2,objLine3,objLine14,objLine15
            ,objLine16,objLine17,objLine4,objLine5,objLine19
            ,objLine20,objLine5_1,objLine6,objLine7,objLine23
            ,objLine24,objLine7_1,objLine8;
    //AnimatorSet
    AnimatorSet amMovingtextToResultBox2,amMovingtextToResultBox,amMovingNum,amMovingNum2;
    int timeThread=5; //Time for delaying pointer's moving.
    int timesPushPauseBtn =1; //Increasing it by one for pushing pause button each time.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap1);
       

        //Selecting view by use findviewById
        imgPointer = (ImageView)findViewById(R.id.pointer);
        playbtn = (ImageButton)findViewById(R.id.playbtn);
        stopbtn = (ImageButton)findViewById(R.id.stopbtn);
        pausebtn=(ImageButton)findViewById(R.id.pausebtn);
        sv_code =(ScrollView)findViewById(R.id.sv_code);
        layout_code=(LinearLayout)findViewById(R.id.layout_code);
        pic_class =(ImageView)findViewById(R.id.pic_class);
        textnum1 =(TextView) findViewById(R.id.text_num1);
        textnum2 =(TextView) findViewById(R.id.text_num2);
        textResult=(TextView)findViewById(R.id.text_result);
        textsign = (TextView)findViewById(R.id.text_sign);
        textReturn = (TextView)findViewById(R.id.textReturn);
        output = (ImageView)findViewById(R.id.output);
        text_class =(TextView)findViewById(R.id.text_class);
        text_object = (TextView)findViewById(R.id.text_object);
        text_construct1 =(TextView)findViewById(R.id.text_construct1);
        text_construct2 = (TextView)findViewById(R.id.text_construct2);
        text_result_des = (TextView) findViewById(R.id.text_result_des);
        textRes1 = (TextView)findViewById(R.id.result1);
        textRes2 = (TextView)findViewById(R.id.result2);

        //Fixing scroll on the top
        sv_code.scrollTo(0,0);

        //Using method onClickListener for event handler on play button.
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calling method 'startPointer()'.
                /*output.setVisibility(View.VISIBLE);
                movingtoOutput();*/
                //Show message notified user
               testPointerLine1();
            }
        });
        //Using method onClickListener for event handler on stop button.
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calling method 'stopPlaying()'
                stopPlaying();
            }
        });
        //Pause button
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timesPushPauseBtn % 2 != 0)
                {
                    callingPause();
                    timesPushPauseBtn +=1;
                }
                else if (timesPushPauseBtn %2==0)
                {
                    callingResume();
                    timesPushPauseBtn +=1;
                }
            }
        });
     }
    //Calling pause's function
    private void  callingPause()
    {
            if(checkState.equals("1"))
            {
                //Pausing animations
                objLine1.pause();
                Log.d("Success!","Pausing line1 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("2"))
            {
                //Pausing animations
                objLine2.pause();
                Log.d("Success!","Pausing line2 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("3"))
            {
                //Pausing animations
                objLine3.pause();
                Log.d("Success!","Pausing line3 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("14"))
            {
                scrollingup();
                //Pausing animations
                objLine14.pause();

                Log.d("Success!","Pausing line14 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("movingNums"))
            {
                //Pausing animations
                amMovingNum.pause();
                amMovingNum2.pause();
                Log.d("Success!","Pausing NumberAnimation success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("15"))
            {
                //Pausing animations
                objLine15.pause();
                Log.d("Success!","Pausing line15 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("16"))
            {
                //Pausing animations
                objLine16.pause();
                Log.d("Success!","Pausing line16 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("17"))
            {
                //Pausing animations
                objLine17.pause();
                Log.d("Success!","Pausing line17 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("4"))
            {
                //Pausing animations
                objLine4.pause();
                Log.d("Success!","Pausing line4 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("5"))
            {
                //Pausing animations
                objLine5.pause();
                Log.d("Success!","Pausing line5 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("19"))
            {
                //Pausing animations
                objLine19.pause();
                Log.d("Success!","Pausing line19 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("20"))
            {
                //Pausing animations
                objLine20.pause();
                Log.d("Success!","Pausing line20 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("amMovingtextToResultBox"))
            {
                //Pausing animations
                amMovingtextToResultBox.pause();
                Log.d("Success!","Pausing  result's showing success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("5_1"))
            {
                //Pausing animations
                objLine5_1.pause();
                Log.d("Success!","Pausing line 5_1 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("6"))
            {
                //Pausing animations
                objLine6.pause();
                Log.d("Success!","Pausing line 6 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("7"))
            {
                //Pausing animations
                objLine7.pause();
                Log.d("Success!","Pausing line 7 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("23"))
            {
                //Pausing animations
                objLine23.pause();
                Log.d("Success!","Pausing line 23 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("24"))
            {
                //Pausing animations
                objLine24.pause();
                Log.d("Success!","Pausing line 24 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("amMovingtextToResultBox2"))
            {
                //Pausing animations
                amMovingtextToResultBox2.pause();
                Log.d("Success!","Pausing  result2 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("7_1"))
            {
                //Pausing animations
                objLine7_1.pause();
                Log.d("Success!","Pausing  line7_1 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else if(checkState.equals("8"))
            {
                //Pausing animations
                objLine8.pause();
                Log.d("Success!","Pausing  line8 success.");
                //Showing pause text on the screen
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Log.d("Error!","Can't pause");
            }
    }
    //Resume function
    private void callingResume()
    {
        if(checkState.equals("1"))
        {
            //Resuming animations
            objLine1.resume();
            Log.d("Success!","Resume line1 success");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("2"))
        {
            //Resuming animations
            objLine2.resume();
            Log.d("Success!","Resume line2 success");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("3"))
        {
            //Resuming animations
            objLine3.resume();
            Log.d("Success!","Resume line3 success");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("14"))
        {
            //Resuming animations
            objLine14.resume();
            Log.d("Success!","Resume line14 success");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("movingNums"))
        {
            //Resuming animations
            amMovingNum.resume();
            amMovingNum2.resume();
            Log.d("Success!","Resuming NumberAnimation success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("15"))
        {
            //Resuming animations
            objLine15.resume();
            Log.d("Success!","Resuming line15 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("16"))
        {
            //Resuming animations
            objLine16.resume();
            Log.d("Success!","Resuming line16 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("17"))
        {
            //Resuming animations
            objLine17.resume();
            Log.d("Success!","Resuming line17 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("4"))
        {
            //Resuming animations
            objLine4.resume();
            Log.d("Success!","Resuming line4 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("5"))
        {
            //Resuming animations
            objLine5.resume();
            Log.d("Success!","Resuming line5 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("19"))
        {
            //Resuming animations
            objLine19.resume();
            Log.d("Success!","Resuming line19 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("20"))
        {
            //Pausing animations
            objLine20.resume();
            Log.d("Success!","Resuming line20 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("amMovingtextToResultBox"))
        {
            //Pausing animations
            amMovingtextToResultBox.resume();
            Log.d("Success!","Resuming  result's showing success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("5_1"))
        {
            //Pausing animations
            objLine5_1.resume();
            Log.d("Success!","Resuming line5_1 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("6"))
        {
            //Pausing animations
            objLine6.resume();
            Log.d("Success!","Resuming line6 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("7"))
        {
            //Pausing animations
            objLine7.resume();
            Log.d("Success!","Resuming line7 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("23"))
        {
            //Pausing animations
            objLine23.resume();
            Log.d("Success!","Resuming line23 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("24"))
        {
            //Pausing animations
            objLine24.resume();
            Log.d("Success!","Resuming line24 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("amMovingtextToResultBox2"))
        {
            //Pausing animations
            amMovingtextToResultBox2.resume();
            Log.d("Success!","Resuming result's showing success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("7_1"))
        {
            //Pausing animations
            objLine7_1.resume();
            Log.d("Success!","Resuming line7_1 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else if(checkState.equals("8"))
        {
            //Pausing animations
            objLine8.resume();
            Log.d("Success!","Resuming line8 success.");
            //Showing pause text on the screen
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Log.d("Error!","Can't resume");
        }
    }
    //play function
    private void testPointerLine1()
    {
            Toast.makeText(Chap1.this, "Start!", Toast.LENGTH_SHORT).show();
            //Scroll to line1
            objLine1 = ObjectAnimator.ofFloat(imgPointer, View.TRANSLATION_Y, 0);
            objLine1.setDuration(2000);
            objLine1.setInterpolator(new LinearInterpolator());
            checkState="1";
            objLine1.start();
            objLine1.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }
                @Override
                public void onAnimationEnd(Animator animator) {

                    pic_class.setVisibility(View.VISIBLE);
                    text_class.setVisibility(View.VISIBLE);
                    testPointerLine2();

                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }

    //testpointerLine2
    private void testPointerLine2()
    {
        //GotoLine2
         objLine2 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y, 50);
        objLine2.setDuration(2000);
        objLine2.setInterpolator(new LinearInterpolator());
        checkState="2";
        objLine2.start();
        objLine2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                pic_class.setImageResource(R.drawable.shape_circle_class);
                text_object.setVisibility(View.VISIBLE);
                testPointerLine3();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //testPointerLine3
    private void testPointerLine3()
    {
         objLine3 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,110);
        objLine3.setDuration(2000);
        objLine3.setInterpolator(new LinearInterpolator());
        checkState="3";
        objLine3.start();
        objLine3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
            //Scrolling down
                testPointerLine14();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //scrolling down
    private void scrollingDown()
    {
        new Thread(new Runnable() {
            @Override
            public void run()
            {

                //Checking what 'CheckingControl' is ?
                if(checkControl)
                {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    checkControl = false;
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //Scrolling the code to top edge.
                            sv_code.scrollTo(0,0);
                        }
                    });
                    //Looping when 'CheckControl' is false.
                    while(!checkControl)
                    {
                        try
                        {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_code.scrollBy(0,1);
                                    //If reachs the bottom line of code then stops it.
                                    if(sv_code.getScrollY()==layout_code.getBottom()-370)
                                    {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        checkControl=true;
                                    }
                                }
                            });
                            //Slowing speed of scroll down.
                            Thread.sleep(timeThread);
                        }
                        //To handle ThreadException by handler 'InteruptException'.
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                //If 'checkControl' is not 'true' then makes it 'true'.
                else
                {
                    checkControl =true;
                }
            }
        }//This statement for starting the new thread execution.
        ).start();
    }
    //testPointerLine14
    private void testPointerLine14()
    {
        objLine14 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,770);
        objLine14.setDuration(3000);
        objLine14.setInterpolator(new LinearInterpolator());
        checkState="14";
        objLine14.start();
        objLine14.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textnum1.setVisibility(View.VISIBLE);
                textnum2.setVisibility(View.VISIBLE);
                movingNums();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    private void movingNums()
    {
        checkState="movingNums";
        ObjectAnimator objnum1_x = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_X,250);
        ObjectAnimator objnum1_y = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_Y,-350);
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
                text_construct1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator objnum2_x = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_X,-250);
        ObjectAnimator objnum2_y = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_Y,-350);
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
                text_construct2.setVisibility(View.VISIBLE);
                scrollingDown();
                testpointerLine15();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //Line15
    private void testpointerLine15()
    {
        objLine15 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,250);
        objLine15.setDuration(2500);
        checkState="15";
        objLine15.start();
        objLine15.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                testpointerLine16();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //line16
    private void testpointerLine16()
    {
        objLine16 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,320);
        objLine16.setDuration(2500);
        checkState="16";
        objLine16.start();
        objLine16.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textnum1.setText("10");
                testpointerLine17();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //testLine17
    private void testpointerLine17()
    {
        objLine17 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,370);
        objLine17.setDuration(2500);
        checkState="17";
        objLine17.start();
        objLine17.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textnum2.setText("5");
                testpointerLine4();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //Line4
    private void testpointerLine4()
    {
        //Going to the top
        scrollingup();
        //Going to line4
        objLine4 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,160);
        objLine4.setDuration(3000);
        checkState="4";
        objLine4.start();
        objLine4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textResult.setVisibility(View.VISIBLE);
                text_result_des.setVisibility(View.VISIBLE);
                testpointerLine5();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //Go to Line5
    private  void testpointerLine5()
    {
        objLine5 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,225);
        objLine5.setDuration(3000);
        checkState="5";
        objLine5.start();
        objLine5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                scrollingDown();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                scrollingDown();
                testpointerLine19();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Line19
    private void testpointerLine19()
    {
        objLine19 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,490);
        objLine19.setDuration(3000);
        checkState="19";
        objLine19.start();
        objLine19.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textsign.setVisibility(View.VISIBLE);
                testpointerLine20();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //line20
    private void testpointerLine20()
    {
        objLine20 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,560);
        objLine20.setDuration(3000);
        checkState="20";
        objLine20.start();
        objLine20.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
            textReturn.setVisibility(View.VISIBLE);
                //Moving text into result's box
                movingTextToResultBox();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //movingTextToResultBox's function
    private void movingTextToResultBox()
    {
        ObjectAnimator objMovingtext = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,-500);
        objMovingtext.setDuration(1000);
        ObjectAnimator objMovingtext2 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,-450);
        objMovingtext2.setDuration(1000);
        //Fading in
        ObjectAnimator objmovingtext3 = ObjectAnimator.ofFloat(textReturn,View.ALPHA,0f);
        objmovingtext3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                    textReturn.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        //Moving back to original position
        ObjectAnimator objMovingtext4 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,0);
        objMovingtext4.setDuration(50);
        ObjectAnimator objMovingtext5 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,0);
        objMovingtext5.setDuration(50);
        //Fading out
        ObjectAnimator objMovingtext6 = ObjectAnimator.ofFloat(textReturn,View.ALPHA,1f);
        amMovingtextToResultBox = new AnimatorSet();
        amMovingtextToResultBox.playSequentially(objMovingtext,objMovingtext2,objmovingtext3,objMovingtext5,objMovingtext4,objMovingtext6);
        checkState="amMovingtextToResultBox";
        amMovingtextToResultBox.start();
        amMovingtextToResultBox.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Goto line5 again
                testPointerLine5_1();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void  testPointerLine5_1()
    {
        scrollingup();
        objLine5_1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,225);
        objLine5_1.setDuration(3000);
        checkState="5_1";
        objLine5_1.start();
        objLine5_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                textResult.setTextColor(Color.parseColor("#ECF0F1"));
                textResult.setText("15");
                testpointerLine6();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Line6
    private void testpointerLine6()
    {
        objLine6 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,290);
        objLine6.setDuration(2500);
        checkState="6";
        objLine6.start();
        objLine6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textRes1.setVisibility(View.VISIBLE);
                testpointerLine7();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //Line7
    private void testpointerLine7()
    {
        objLine7 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,340);
        objLine7.setDuration(3000);
        checkState="7";
        objLine7.start();
        objLine7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                scrollingDown();
                testpointerLine23();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Line23
    private void testpointerLine23()
    {
        objLine23 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,730);
        objLine23.setDuration(3000);
        checkState="23";
        objLine23.start();
        objLine23.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textsign.setText("-");
                testpointerLine24();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Line24
    private void testpointerLine24()
    {
        objLine24 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,800);
        objLine24.setDuration(3000);
        checkState="24";
        objLine24.start();
        objLine24.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textReturn.setText("=5");
                textReturn.setVisibility(View.VISIBLE);
                movingTextToResultBox2();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //movingTextToResultBox2
    private void movingTextToResultBox2()
    {
        ObjectAnimator objGoX = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,-500);
        objGoX.setDuration(1000);
        ObjectAnimator objGoY = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,-450);
        objGoY.setDuration(1000);
        //Hidding
        ObjectAnimator objHide = ObjectAnimator.ofFloat(textReturn,View.ALPHA,0f);
        objHide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ObjectAnimator objReturnX = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,0);
        objReturnX.setDuration(50);
        ObjectAnimator objReturnY = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,0);
        objReturnY.setDuration(50);
        //Showing
        ObjectAnimator objShow = ObjectAnimator.ofFloat(textReturn,View.ALPHA,1f);
        amMovingtextToResultBox2 = new AnimatorSet();
        amMovingtextToResultBox2.playSequentially(objGoX,objGoY,objHide,objReturnX,objReturnY,objShow);
        checkState="amMovingtextToResultBox2";
        amMovingtextToResultBox2.start();
        amMovingtextToResultBox2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Going to line8
                testpointerLine7_1();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //Line7 again
    private  void  testpointerLine7_1()
    {
        scrollingup();
        objLine7_1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,330);
        objLine7_1.setDuration(3500);
        checkState="7_1";
        objLine7_1.start();
        objLine7_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                textResult.setText("5");
                testpointerLine8();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line8
    private void testpointerLine8()
    {
        objLine8 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,410);
        objLine8.setDuration(3000);
        checkState="8";
        objLine8.start();
        objLine8.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textRes2.setVisibility(View.VISIBLE);
                Toast.makeText(Chap1.this, "Finished", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Stop playing
    private void stopPlaying()
    {
        //Show stop message
        Toast.makeText(Chap1.this, "Stop!", Toast.LENGTH_SHORT).show();
        sv_code.scrollTo(0,0);
        recreate();
    }
    //go up function
    private void scrollingup()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(checkControlGo)
                {
                    checkControlGo =false;
                    while(!checkControlGo) {
                        try
                        {
                            runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    sv_code.scrollBy(0,-1);
                                    if(sv_code.getScrollY()==layout_code.getHeight()-870)
                                    {
                                        checkControlGo=true;
                                        /*Toast.makeText(Chap1.this, "Stop", Toast.LENGTH_SHORT).show();*/
                                    }
                                }
                            });
                            Thread.sleep(timeThread);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    checkControl=true;
                }
            }
        }).start();
    }

    //Calling method 'OnBackPressed.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Going back to FirstPage's Activity.
        //Creating intent.
        intent = new Intent(this,List_chapter.class);
        //Going to that activity's name in the intent that created.
        startActivity(intent);
        //Closing this activity.
        finish();
    }

}
