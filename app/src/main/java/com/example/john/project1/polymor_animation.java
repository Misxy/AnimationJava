package com.example.john.project1;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class polymor_animation extends AppCompatActivity {
    ImageButton playbtnPM,pausebtnPM,stopbtnPM;
    TextView output_resultPM,output_headerPM,classPM_text,objectPM_text;
    LinearLayout output_layoutPM,layoutcode;
    ImageView code,cat,cat_meow,pointer,class_PM;
    ScrollView sv_codePM;
    int countPush=0;
    String CheckStatePoly="";
    Boolean CheckScrolling=true;
    ObjectAnimator line21,line14,line1,line14_1,line21_1,line22,line16,line17,line23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polymor_animation);
        pointer =(ImageView)findViewById(R.id.pointer_PM);
        playbtnPM = (ImageButton)findViewById(R.id.playbtnPM);
        pausebtnPM = (ImageButton)findViewById(R.id.pausebtnPM);
        stopbtnPM = (ImageButton)findViewById(R.id.stopbtn_PM);
        output_headerPM = (TextView)findViewById(R.id.output_headerPM);
        output_resultPM = (TextView)findViewById(R.id.output_reseultPM);
        classPM_text = (TextView)findViewById(R.id.classPM_text);
        objectPM_text =(TextView)findViewById(R.id.object_PM_text);
        output_layoutPM = (LinearLayout)findViewById(R.id.output_layoutPM);
        code = (ImageView)findViewById(R.id.code_PM);
        cat = (ImageView)findViewById(R.id.cat);
        cat_meow =(ImageView)findViewById(R.id.cat_meow);
        sv_codePM = (ScrollView)findViewById(R.id.sv_codePM);
        class_PM = (ImageView)findViewById(R.id.class_PM);
        layoutcode = (LinearLayout)findViewById(R.id.Linear_codePM);
        //prepare
        prepare();
        start();
    }
    private void prepare()
    {
        cat_meow.setVisibility(View.INVISIBLE);
        cat.setVisibility(View.INVISIBLE);
        class_PM.setVisibility(View.INVISIBLE);
        output_layoutPM.setVisibility(View.INVISIBLE);
        objectPM_text.setVisibility(View.INVISIBLE);
        classPM_text.setVisibility(View.INVISIBLE);
        output_resultPM.setVisibility(View.INVISIBLE);
        output_headerPM.setVisibility(View.INVISIBLE);
    }
    //start method
    private void start()
    {
        playbtnPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(polymor_animation.this, "Start!", Toast.LENGTH_SHORT).show();
                //Go Line20
                GoLine21();
            }
        });
        pausebtnPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countPush +=1;
                try {
                    if (countPush % 2 != 0) {
                        pause();
                    }
                    else if(countPush %2==0)
                    {
                        resume();
                    }
                }
                catch (Exception e)
                {
                    Log.d("State","Error");
                    e.printStackTrace();
                }
            }
        });
        stopbtnPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread.currentThread().interrupt();
                Toast.makeText(polymor_animation.this, "Stop", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });
    }
    private void pause()
    {
        if(CheckStatePoly.equals("line21"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line21.pause();
            Log.d("State","line21 paused");
        }
        else if(CheckStatePoly.equals("line14"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line14.pause();
            Log.d("State","line14 paused");
        }
        else if(CheckStatePoly.equals("line1"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line1.pause();
            Log.d("State","line1 paused");
        }
        else if(CheckStatePoly.equals("line14_1"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line14_1.pause();
            Log.d("State","line14_1 paused");
        }
        else if(CheckStatePoly.equals("line21"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line21.pause();
            Log.d("State","line21 paused");
        }
        else if(CheckStatePoly.equals("line22"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line22.pause();
            Log.d("State","line22 paused");
        }
        else if(CheckStatePoly.equals("line16"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line16.pause();
            Log.d("State","line16 paused");
        }
        else if(CheckStatePoly.equals("line17"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line17.pause();
            Log.d("State","line17 paused");
        }
        else if(CheckStatePoly.equals("line23"))
        {
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line23.pause();
            Log.d("State","line23 paused");
        }
    }
    private void resume()
    {
        if(CheckStatePoly.equals("line21"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line21.resume();
            Log.d("State","line21 resume");
        }
        else if(CheckStatePoly.equals("line14"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line14.resume();
            Log.d("State","line14 resume");
        }
        else if(CheckStatePoly.equals("line1"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line1.resume();
            Log.d("State","line1 resume");
        }
        else if(CheckStatePoly.equals("line14_1"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line14_1.resume();
            Log.d("State","line14_1 resume");
        }
        else if(CheckStatePoly.equals("line21"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line21.resume();
            Log.d("State","line21 resume");
        }
        else if(CheckStatePoly.equals("line22"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line22.resume();
            Log.d("State","line22 resume");
        }
        else if(CheckStatePoly.equals("line16"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line16.resume();
            Log.d("State","line16 resume");
        }
        else if(CheckStatePoly.equals("line17"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line17.resume();
            Log.d("State","line17 resume");
        }
        else if(CheckStatePoly.equals("line23"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line23.resume();
            Log.d("State","line23 resume");
        }
    }
    //Go Line20
    private void GoLine21()
    {
        CheckStatePoly="line21";
        testScrollingDown(1000);
        line21 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,770);
        line21.setDuration(3000);
        line21.start();
        line21.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                classPM_text.setVisibility(View.VISIBLE);
                objectPM_text.setVisibility(View.VISIBLE);
                class_PM.setImageResource(R.drawable.shape_circle_class);
                class_PM.setVisibility(View.VISIBLE);
                cat.setVisibility(View.VISIBLE);
                Log.d("State","line21 finished");
                //Go line14
                GoLine14();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
    //Line14
    private void GoLine14()
    {
        CheckStatePoly="line14";
        line14 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,350);
        line14.setDuration(3000);
        line14.start();
        line14.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line14 finished");
                //GoLine1
                testScrollingUp(1420);
                //GoLine1
                GoLine1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Goline1
    private void GoLine1()
    {
        CheckStatePoly="line1";
        line1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,0);
        line1.setDuration(3000);
        line1.start();
        line1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line1 finished");
                //Go Line 14 again
                GoLine14_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line14_1
    private void GoLine14_1()
    {
        testScrollingDown(1000);
        CheckStatePoly="line14_1";
        line14_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,350);
        line14_1.setDuration(3000);
        line14_1.start();
        line14_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line14_1 finished");
                //goline21 again
                GoLine21_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line21_1
    private void GoLine21_1()
    {
        CheckStatePoly="line21_1";
        line21_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,770);
        line21_1.setDuration(3000);
        line21_1.start();
        line21_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line21_1 finished");
                //Go line22
                GoLine22();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line22
    private void GoLine22()
    {
        CheckStatePoly="line22";
        line22 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,830);
        line22.setDuration(3000);
        line22.start();
        line22.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line22 finished");
                //goLine16
                GoLine16();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line16
    private  void GoLine16()
    {
        CheckStatePoly="line16";
        line16 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,470);
        line16.setDuration(3000);
        line16.start();
        line16.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line16 finished");
                //Goline17
                GoLine17();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line17
    private void GoLine17()
    {
        CheckStatePoly="line17";
        line17 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,530);
        line17.setDuration(3000);
        line17.start();
        line17.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                cat_meow.setVisibility(View.VISIBLE);
                Log.d("State","line17 finished");
                //GoLine23
                GoLine23();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line23
    private void GoLine23()
    {
        testScrollingDown(980);
        CheckStatePoly="line23";
        line23 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,860);
        line23.setDuration(3000);
        line23.start();
        line23.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                output_headerPM.setVisibility(View.VISIBLE);
                output_layoutPM.setVisibility(View.VISIBLE);
                output_resultPM.setVisibility(View.VISIBLE);
                Toast.makeText(polymor_animation.this, "Finished!", Toast.LENGTH_SHORT).show();
                Log.d("State","Application finished");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //SCrolling down
    private void testScrollingDown(final int a)
    {
        new Thread(new Runnable() {
            @Override
            public void run()
            {

                //Checking what 'CheckingControl' is ?
                if(CheckScrolling)
                {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    CheckScrolling = false;
                    //Looping when 'CheckControl' is false.
                    while(!CheckScrolling)
                    {
                        try
                        {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_codePM.scrollBy(0,1);
                                    //If reachs the bottom line of code then stops it.
                                    if(sv_codePM.getScrollY()==layoutcode.getBottom()-a)
                                    {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        CheckScrolling=true;
                                    }
                                }
                            });
                            //Slowing speed of scroll down.
                            Thread.sleep(5);
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
                    CheckScrolling =true;
                }
            }
        }//This statement for starting the new thread execution.
        ).start();
    }
    private void testScrollingUp(final int a)
    {
        new Thread(new Runnable() {
            @Override
            public void run()
            {

                //Checking what 'CheckingControl' is ?
                if(CheckScrolling)
                {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    CheckScrolling = false;
                    //Looping when 'CheckControl' is false.
                    while(!CheckScrolling)
                    {
                        try
                        {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_codePM.scrollBy(0,-1);
                                    //If reachs the bottom line of code then stops it.
                                    if(sv_codePM.getScrollY()==layoutcode.getHeight()-a)
                                    {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        CheckScrolling=true;
                                    }
                                }
                            });
                            //Slowing speed of scroll down.
                            Thread.sleep(5);
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
                    CheckScrolling =true;
                }
            }
        }//This statement for starting the new thread execution.
        ).start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,polymor_teach.class);
        startActivity(intent);
        finish();
    }
}
