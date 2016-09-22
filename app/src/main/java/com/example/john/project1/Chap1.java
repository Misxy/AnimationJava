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
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
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
            text_object,text_construct1,text_construct2,text_result_des;
    Boolean checkControl = true,checkControlGo=true;//Logically variable for controlling.
    Boolean checkPause=false;
    int timeThread=5; //Time for delaying pointer's moving.
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
                callingPause();
            }
        });
     }
    //Calling pause's function
    private void callingPause()
    {
        Toast.makeText(Chap1.this,"Paused",Toast.LENGTH_SHORT).show();
        checkPause=true;
    }
    //play function
    private void testPointerLine1()
    {
            Toast.makeText(Chap1.this, "Start!", Toast.LENGTH_SHORT).show();
            //Scroll to line1
            ObjectAnimator objline1 = ObjectAnimator.ofFloat(imgPointer, View.TRANSLATION_Y, 0);
            objline1.setDuration(3000);
            objline1.setInterpolator(new LinearInterpolator());
            objline1.start();
            objline1.addListener(new Animator.AnimatorListener() {
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
        ObjectAnimator objLine2 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y, 50);
        objLine2.setDuration(3000);
        objLine2.setInterpolator(new LinearInterpolator());
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
        ObjectAnimator objLine3 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,110);
        objLine3.setDuration(3000);
        objLine3.setInterpolator(new LinearInterpolator());
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
                        catch (InterruptedException e) {}
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
        ObjectAnimator objLine14 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,770);
        objLine14.setDuration(3000);
        objLine14.setInterpolator(new LinearInterpolator());
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
        ObjectAnimator objnum1_x = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_X,250);
        ObjectAnimator objnum1_y = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_Y,-350);
        AnimatorSet am = new AnimatorSet();
        am.setDuration(3000);
        am.setInterpolator(new LinearInterpolator());
        am.playTogether(objnum1_x,objnum1_y);
        am.start();

        ObjectAnimator objnum2_x = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_X,-250);
        ObjectAnimator objnum2_y = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_Y,-350);
        AnimatorSet am2 = new AnimatorSet();
        am2.setDuration(3000);
        am2.setInterpolator(new LinearInterpolator());
        am2.playTogether(objnum2_x,objnum2_y);
        am2.start();
        am2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
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
        ObjectAnimator objLine15 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,250);
        objLine15.setDuration(3000);

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
        ObjectAnimator objLine16 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,320);
        objLine16.setDuration(3000);

        objLine16.start();
        objLine16.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textnum1.setText("10");
                text_construct1.setVisibility(View.VISIBLE);
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
        ObjectAnimator objLine17 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,370);
        objLine17.setDuration(3000);
        objLine17.start();
        objLine17.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textnum2.setText("5");
                text_construct2.setVisibility(View.VISIBLE);
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
        Scrollingup();
        //Going to line4
        ObjectAnimator objLine4 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,170);
        objLine4.setDuration(3000);
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
        ObjectAnimator objLine5 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,220);
        objLine5.setDuration(3000);
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
        ObjectAnimator objLine19 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,500);
        objLine19.setDuration(3000);
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
        ObjectAnimator objLine20 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,560);
        objLine20.setDuration(3000);
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
        ObjectAnimator objMovingtext2 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,-450);
        //Fading in
        ObjectAnimator objmovingtext3 = ObjectAnimator.ofFloat(textReturn,View.ALPHA,0f);
        objmovingtext3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                    textResult.setTextColor(Color.parseColor("#ECF0F1"));
                    textResult.setText("15");
                    textReturn.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ObjectAnimator objMovingtext4 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,0);
        ObjectAnimator objMovingtext5 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,0);
        //Fading out
        ObjectAnimator objMovingtext6 = ObjectAnimator.ofFloat(textReturn,View.ALPHA,1f);

        AnimatorSet am = new AnimatorSet();
        am.setDuration(2000);
        am.playSequentially(objMovingtext,objMovingtext2,objmovingtext3,objMovingtext5,objMovingtext4,objMovingtext6);
        am.start();
        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textReturn.setText("=5");
                Scrollingup();
                //Goto line6
                testpointerLine6();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Line6
    private void testpointerLine6()
    {
        ObjectAnimator objLine6 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,290);
        objLine6.setDuration(3000);
        objLine6.start();
        objLine6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                movingToOutput();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //movingToOutput
    private void movingToOutput()
    {
        ObjectAnimator objToY = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,900);
        ObjectAnimator objToX = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,700);
        objToX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                output.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        //Fading in
        ObjectAnimator objHide = ObjectAnimator.ofFloat(textResult,View.ALPHA,0f);
        ObjectAnimator objReturnX = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,0);
        ObjectAnimator objReturnY = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,0);
        //Fading out
        ObjectAnimator objShow = ObjectAnimator.ofFloat(textResult,View.ALPHA,1f);
        AnimatorSet am = new AnimatorSet();
        am.playSequentially(objToY,objToX,objReturnX,objReturnY);
        am.setDuration(3000);
        am.start();
        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Go to line7
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
        ObjectAnimator objLine7 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,350);
        objLine7.setDuration(3000);
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
        ObjectAnimator objLine23 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,740);
        objLine23.setDuration(3000);
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
        ObjectAnimator objLine24 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,800);
        objLine24.setDuration(3000);
        objLine24.start();
        objLine24.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
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
        ObjectAnimator objGoY = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,-450);
        //Hidding
        ObjectAnimator objHide = ObjectAnimator.ofFloat(textReturn,View.ALPHA,0f);
        objHide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textResult.setText("5");
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ObjectAnimator objReturnX = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,0);
        ObjectAnimator objReturnY = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,0);
        //Showing
        ObjectAnimator objShow = ObjectAnimator.ofFloat(textReturn,View.ALPHA,1f);
        AnimatorSet am = new AnimatorSet();
        am.playSequentially(objGoX,objGoY,objHide,objReturnX,objReturnY,objShow);
        am.setDuration(3000);
        am.start();
        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Scrollingup();
                //Going to line8
                testpointerLine8();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //line8
    private void testpointerLine8()
    {
        ObjectAnimator objLine8 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,410);
        objLine8.setDuration(3000);
        objLine8.start();
        objLine8.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                movingToOutput2();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    // movingToOutput2's function
    private void  movingToOutput2()
    {
        ObjectAnimator objGoY = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,900);
        ObjectAnimator objGoX = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,700);
        objGoX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                output.setImageResource(R.drawable.result_class_object);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        //Fading in
        ObjectAnimator objHide = ObjectAnimator.ofFloat(textResult,View.ALPHA,0f);
        ObjectAnimator objBackX = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,0);
        ObjectAnimator objBackY = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,0);
        //Fading out
        ObjectAnimator objShow = ObjectAnimator.ofFloat(textResult,View.ALPHA,1f);

        AnimatorSet am = new AnimatorSet();
        am.setDuration(2000);
        am.playSequentially(objGoY,objGoX,objBackX,objBackY);
        am.start();
        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Show message notified user
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
    private void Scrollingup()
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
                            Log.v("TAG","Cannot run Thread ");
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
