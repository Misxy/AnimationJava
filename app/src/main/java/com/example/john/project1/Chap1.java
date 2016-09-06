package com.example.john.project1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
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
    ImageView imgPointer,pic_class;
    ImageButton playbtn,stopbtn;
    ScrollView sv_code;
    LinearLayout layout_code;
    TextView textnum1,textnum2,textResult,textsign;
    int a;

    //Declaring variables.
    Boolean checkControl = true; //Logically variable for controlling.
    int timeThread=5; //Time for delaying pointer's moving.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap1);

        //Selecting view by use findviewById
        imgPointer = (ImageView)findViewById(R.id.pointer);
        playbtn = (ImageButton)findViewById(R.id.playbtn);
        stopbtn = (ImageButton)findViewById(R.id.stopbtn);
        sv_code =(ScrollView)findViewById(R.id.sv_code);
        layout_code=(LinearLayout)findViewById(R.id.layout_code);
        pic_class =(ImageView)findViewById(R.id.pic_class);
        textnum1 =(TextView) findViewById(R.id.text_num1);
        textnum2 =(TextView) findViewById(R.id.text_num2);
        textResult=(TextView)findViewById(R.id.text_result);
        textsign = (TextView)findViewById(R.id.text_sign);

        //Using method onClickListener for event handler on play button.
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calling method 'startPointer()'.
               /* startMoving();*/
                /*testPointer(500);*/
                textnum1.setVisibility(View.VISIBLE);
                textnum2.setVisibility(View.VISIBLE);
                movingNums();
                movingresultPic();
                textsign.setVisibility(View.VISIBLE);
                movingSign();
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
     }
    //Method 'play'
    private void play()
    {
        //Showing class'picture and its constructors.
        pic_class.setVisibility(View.VISIBLE);
        textnum1.setVisibility(View.VISIBLE);
        textnum2.setVisibility(View.VISIBLE);

        testPointer(50); //Going to ine2.
        testPointer(110); //Going to line3.

        //Showing object's picture.
        pic_class.setImageResource(R.drawable.shape_circle_class);

        //Calling 'movingNums'
        movingNums();

        //Going to class 'Chapter' on line 11
        testPointer(595);

        //Going to line12.
        testPointer(650);

        //Going to line14.
        testPointer(775);

        //Scrolling down code's picture to the bottom.
        startMoving();

        //Going to line15 and playing animation on num1 and num2 's pictures
        testPointer(115);
        flipconstruct1();

        //Going to line16
        testPointer(215);
        flipconstruct2();

        //Scrolling the code's picture to the top
        sv_code.scrollTo(0,0);


        //Going to line4.
        testPointer(170);
        //Showing the result's picture and set its position.
        movingresultPic();


        //Going to line5.
        testPointer(235);
    }
    //movingSign's method
    private void movingSign()
    {
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textsign,View.TRANSLATION_X,-510);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textsign,View.TRANSLATION_Y,340);
        AnimatorSet am = new AnimatorSet();
        am.playTogether(t1,t2);
        am.setDuration(1000);
        am.start();
    }

    //movingresultPic's method
    private void movingresultPic()
    {
        /*textResult.setVisibility(View.VISIBLE);*/
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,505);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,570);
        AnimatorSet am = new AnimatorSet();
        am.playTogether(t1,t2);
        am.setDuration(1000);
        am.start();
        textResult.setVisibility(View.VISIBLE);
    }
    //method 'movingNums'
    private void movingNums()
    {
        //Moving num 1 and num 2 into center of circle by using AnimatorSet.
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_X,250);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_Y,-350);
        AnimatorSet am = new AnimatorSet();
        am.playTogether(t1,t2);
        am.setDuration(1000);
        am.start();

        ObjectAnimator u1 = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_X,-250);
        ObjectAnimator u2 = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_Y,-350);
        AnimatorSet am1 = new AnimatorSet();
        am1.playTogether(u1,u2);
        am1.setDuration(1000);
        am1.start();
    }
    //method'construct1'
    private void flipconstruct1()
    {
        textnum1.setVisibility(View.VISIBLE);
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textnum1,View.ROTATION_Y,360);
        t1.setDuration(2000);
        t1.start();
    }

    //method'construct2'
    private void flipconstruct2()
    {
        textnum2.setVisibility(View.VISIBLE);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textnum2,View.ROTATION_Y,360);
        t2.setDuration(2000);
        t2.start();
    }

    //methd 'startMoving'
    private void startMoving()
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
                                    if(sv_code.getScrollY()==layout_code.getBottom()-280)
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
        }
        //This statement for starting the new thread execution.
        ).start();
    }

    //method 'stopPlaying()'
    private void stopPlaying()
    {
        //Cancelling scroll down the code example's picture. By using boolean = 'true'
        checkControl=true;
        //taking a code's picture scrolls to the top.
        sv_code.scrollTo(0,0);
        /*Calling object of Class 'Chap1' then
        call method name 'testPointer' to make pointer go to startpoint*/
        testPointer(0);

    }

    //method 'testPointer'
    private void testPointer(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(1000);
        /*Starting a pointer's moving*/
        test1.start();
    }
    //Calling method 'OnBackPressed.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Going back to FirstPage's Activity.
        //Creating intent.
        intent = new Intent(this,Content.class);
        //Going to that activity's name in the intent that created.
        startActivity(intent);
        //Closing this activity.
        finish();
    }
}
