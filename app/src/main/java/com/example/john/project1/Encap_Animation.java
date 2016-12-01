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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Encap_Animation extends AppCompatActivity {
    ImageView pointer,code_encap,class_encap;
    TextView objEncap_text,classEncap_text,getter_text,setter_text,Getter_box,Setter_Box,output_header,output_result,text_parameter;
    LinearLayout output_layout;
    ImageButton PlaybtnEncap,PauseBtnEncap,StopBtnEncap;
    ObjectAnimator line11,line13,line1,line13_1,line14,line6,line7,line8,line14_1,line15,line3,line4,line5,line15_1;
    AnimatorSet movingAnimation,setAnimation,getAnimation;
    String CheckStateEncap="";
    int countPush=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encap__animation);
        //ImageView
        pointer = (ImageView)findViewById(R.id.pointer_PM);
        code_encap = (ImageView)findViewById(R.id.code_encap);
        class_encap = (ImageView)findViewById(R.id.class_PM);

        //TextView
        objEncap_text = (TextView)findViewById(R.id.object_PM_text);
        classEncap_text = (TextView)findViewById(R.id.classPM_text);
        getter_text =(TextView)findViewById(R.id.getter_text);
        setter_text =(TextView)findViewById(R.id.setter_text);
        Getter_box = (TextView)findViewById(R.id.GetterName_box);
        Setter_Box = (TextView)findViewById(R.id.SetterName_box);
        output_header = (TextView)findViewById(R.id.output_header);
        output_result = (TextView)findViewById(R.id.output_reseult);
        text_parameter = (TextView)findViewById(R.id.text_parameter);
        //Linearlayout
        output_layout = (LinearLayout)findViewById(R.id.output_layoutPM);

        //ImageButtons
        PlaybtnEncap = (ImageButton)findViewById(R.id.playbtnEncap);
        PauseBtnEncap = (ImageButton)findViewById(R.id.pausebtnEncap);
        StopBtnEncap = (ImageButton)findViewById(R.id.stopbtn_encap);
        hide();
        //play btn
        PlaybtnEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoLine11();
            }
        });
        //pause button
        PauseBtnEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    countPush +=1;
                    if(countPush%2!=0)
                    {
                        PauseAnimation();
                    }
                    else if (countPush%2==0)
                    {
                        ResumeAnimation();
                    }
                }
                catch (Exception e)
                {
                    Log.d("State","Error happening!");
                    e.printStackTrace();
                }
            }
        });
        StopBtnEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Encap_Animation.this, "stop", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });
    }
    //pauseAnimation
    private void PauseAnimation()
    {
        if(CheckStateEncap.equals("line11"))
        {
            Log.d("State","line11 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line11.pause();
        }
        else if(CheckStateEncap.equals("line13"))
        {
            Log.d("State","line13 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line13.pause();
        }
        else if(CheckStateEncap.equals("line1"))
        {
            Log.d("State","line1 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line1.pause();
        }
        else if(CheckStateEncap.equals("line13_1"))
        {
            Log.d("State","line13_1 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line13_1.pause();
        }
        else if(CheckStateEncap.equals("line14"))
        {
            Log.d("State","line14 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line14.pause();
        }
        else if(CheckStateEncap.equals("line6"))
        {
            Log.d("State","line6 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line6.pause();
        } else if(CheckStateEncap.equals("line7"))
        {
            Log.d("State","line7 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line7.pause();
        }else if(CheckStateEncap.equals("line8"))
        {
            Log.d("State","line8 paused");
            line8.pause();
        }else if(CheckStateEncap.equals("line14"))
        {
            Log.d("State","line14 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line14.pause();
        }else if(CheckStateEncap.equals("line15"))
        {
            Log.d("State","line15 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line15.pause();
        }else if(CheckStateEncap.equals("line3"))
        {
            Log.d("State","line3 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line3.pause();
        }else if(CheckStateEncap.equals("line4"))
        {
            Log.d("State","line4 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line4.pause();
        }else if(CheckStateEncap.equals("line5"))
        {
            Log.d("State","line5 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line5.pause();
        }else if(CheckStateEncap.equals("line15"))
        {
            Log.d("State","line15_1 paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            line15_1.pause();
        }else if(CheckStateEncap.equals("playAnimation_text"))
        {
            Log.d("State"," movingAnimation paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            movingAnimation.pause();
        }else if(CheckStateEncap.equals("playsetAnimation"))
        {
            Log.d("State","playsetAnimation paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            setAnimation.pause();
        }else if(CheckStateEncap.equals("playgetAnimation"))
        {
            Log.d("State","playgetAnimation paused");
            Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
            getAnimation.pause();
        }
    }
    //PauseAniamtion
    private void ResumeAnimation()
    {
        if(CheckStateEncap.equals("line11"))
        {
            Log.d("State","line11 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line11.resume();
        }
        else if(CheckStateEncap.equals("line13"))
        {
            Log.d("State","line13 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line13.resume();
        }
        else if(CheckStateEncap.equals("line1"))
        {
            Log.d("State","line1 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line1.resume();
        }
        else if(CheckStateEncap.equals("line13_1"))
        {
            Log.d("State","line13_1 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line13_1.resume();
        }
        else if(CheckStateEncap.equals("line14"))
        {
            Log.d("State","line14 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line14.resume();
        }
        else if(CheckStateEncap.equals("line6"))
        {
            Log.d("State","line6 resumed");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line6.resume();
        } else if(CheckStateEncap.equals("line7"))
        {
            Log.d("State","line7 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line7.resume();
        }else if(CheckStateEncap.equals("line8"))
        {
            Log.d("State","line8 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line8.resume();
        }else if(CheckStateEncap.equals("line14"))
        {
            Log.d("State","line14 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line14.resume();
        }else if(CheckStateEncap.equals("line15"))
        {
            Log.d("State","line15 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line15.resume();
        }else if(CheckStateEncap.equals("line3"))
        {
            Log.d("State","line3 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line3.resume();
        }else if(CheckStateEncap.equals("line4"))
        {
            Log.d("State","line4 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line4.resume();
        }else if(CheckStateEncap.equals("line5"))
        {
            Log.d("State","line5 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line5.resume();
        }else if(CheckStateEncap.equals("line15"))
        {
            Log.d("State","line15_1 resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line15_1.resume();
        }else if(CheckStateEncap.equals("playAnimation_text"))
        {
            Log.d("State"," movingAnimation resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            movingAnimation.resume();
        }else if(CheckStateEncap.equals("playsetAnimation"))
        {
            Log.d("State","playsetAnimation resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            setAnimation.resume();
        }else if(CheckStateEncap.equals("playgetAnimation"))
        {
            Log.d("State","playgetAnimation resume");
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            getAnimation.resume();
        }
    }
    //Hide object's method
    private void hide()
    {
        class_encap.setVisibility(View.INVISIBLE);
        classEncap_text.setVisibility(View.INVISIBLE);
        objEncap_text.setVisibility(View.INVISIBLE);
        getter_text.setVisibility(View.INVISIBLE);
        setter_text.setVisibility(View.INVISIBLE);
        Getter_box.setVisibility(View.INVISIBLE);
        Setter_Box.setVisibility(View.INVISIBLE);
        output_header.setVisibility(View.INVISIBLE);
        output_result.setVisibility(View.INVISIBLE);
        output_layout.setVisibility(View.INVISIBLE);
        text_parameter.setVisibility(View.INVISIBLE);
    }
    private void GoLine11()
    {
        CheckStateEncap="line11";
        line11 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,610);
        line11.setDuration(3000);
        line11.start();
        line11.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                class_encap.setVisibility(View.VISIBLE);
                classEncap_text.setVisibility(View.VISIBLE);
                Toast.makeText(Encap_Animation.this, "โปรแกรมเริ่มทำงานที่เมธอด main", Toast.LENGTH_SHORT).show();
                Log.d("State","line11 finished");
                GoLine13();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line13
    private void GoLine13()
    {
        CheckStateEncap="line13";
        line13 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,720);
        line13.setDuration(3000);
        line13.start();
        line13.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                class_encap.setImageResource(R.drawable.shape_circle_class);
                objEncap_text.setVisibility(View.VISIBLE);
                Toast.makeText(Encap_Animation.this, "มีการประกาศ object ของคลาส Employee ขึ้นมา", Toast.LENGTH_SHORT).show();
                Log.d("State","line13 finished");
                //Go to line1
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
    private void GoLine1()
    {
        CheckStateEncap="line1";
        line1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,0);
        line1.setDuration(3000);
        line1.start();
        line1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Encap_Animation.this, "คลาส Employee", Toast.LENGTH_SHORT).show();
                Log.d("State","line1 finished");
                //Goline13 again
                GoLine13_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private void GoLine13_1()
    {
        CheckStateEncap="line13_1";
        line13_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,720);
        line13_1.setDuration(3000);
        line13_1.start();
        line13_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Encap_Animation.this, "object พร้อมใช้งาน", Toast.LENGTH_SHORT).show();
                Log.d("State","line13_1 finished");
                //Goline14
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
    private void GoLine14()
    {
        CheckStateEncap="line14";
        line14 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,780);
        line14.setDuration(3000);
        line14.start();
        line14.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_parameter.setVisibility(View.VISIBLE);
                Toast.makeText(Encap_Animation.this, "เข้าถึงเมธอด setName()ของคลาส Employee ผ่าน object", Toast.LENGTH_SHORT).show();
                Log.d("State","line14 finished");
                //playAnimation
                playAnimation_text();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private void playAnimation_text()
    {
        CheckStateEncap="playAnimation_text";
        ObjectAnimator goX = ObjectAnimator.ofFloat(text_parameter,View.TRANSLATION_Y,-85);
        ObjectAnimator goY = ObjectAnimator.ofFloat(text_parameter,View.TRANSLATION_X,245);

        //AnimatorSet
        movingAnimation  = new AnimatorSet();
        movingAnimation.playSequentially(goX,goY);
        movingAnimation.setDuration(3000);
        movingAnimation.start();
        movingAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Encap_Animation.this, "ส่งสตริงที่เขียนว่า Torn ไปให้กับเมธอด setName(String empName)", Toast.LENGTH_LONG).show();
                Log.d("State","Animation_text finished");
                //Goto Line6
                GoLine6();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
    //GoLine6
    private void GoLine6()
    {
        CheckStateEncap="line6";
        line6 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,300);
        line6.setDuration(3000);
        line6.start();
        line6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                setter_text.setVisibility(View.VISIBLE);
                Setter_Box.setVisibility(View.VISIBLE);
                Toast.makeText(Encap_Animation.this, "เมธอด setName(String empName)รอบรับค่าสตริงที่จะถูกส่งเข้ามา", Toast.LENGTH_SHORT).show();
                Log.d("State","line6 finished");
                //Goto Line7
                GoLine7();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line7
    private void GoLine7()
    {
        CheckStateEncap="line7";
        line7 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,360);
        line7.setDuration(4000);
        line7.start();
        line7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line17 finished");
                //goLine8
                Toast.makeText(Encap_Animation.this, "เมธอด setName(String empName) รับสตริงที่เขียนว่า Torn เข้าสู่เมธอด()", Toast.LENGTH_LONG).show();
                GoLine8();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //play setAnimation
    private void playsetAnimation()
    {
        CheckStateEncap="playsetAnimation";
        ObjectAnimator goY = ObjectAnimator.ofFloat(text_parameter,View.TRANSLATION_Y,-250);
        ObjectAnimator hide = ObjectAnimator.ofFloat(text_parameter,View.ALPHA,0f);
        hide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Setter_Box.setText("Torn");
                Setter_Box.setTextColor(Color.parseColor("#FFFFFF"));
                Setter_Box.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator returnY = ObjectAnimator.ofFloat(text_parameter,View.TRANSLATION_Y,0);
        //AnimatorSet
        setAnimation = new AnimatorSet();
        setAnimation.playSequentially(goY,hide,returnY);
        setAnimation.setDuration(2000);
        setAnimation.start();
        setAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","playsetAnimation finished");
                //Go to Line14_1
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
    //GoLine8
    private void GoLine8()
    {
        CheckStateEncap="line8";
        line8 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,420);
        line8.setDuration(6000);
        line8.start();
        line8.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Encap_Animation.this, "ตัวแปร empName มีค่าเท่ากับ Torn ", Toast.LENGTH_LONG).show();
                Log.d("State","line8 finished");
                //play setanimation
                playsetAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Go Line14_1
    private void GoLine14_1()
    {
        CheckStateEncap="line14_1";
        line14_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,790);
        line14_1.setDuration(3000);
        line14_1.start();
        line14_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line14_1 finished");
                //Goline 15
                GoLine15();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //GoLine15
    private void GoLine15()
    {
        CheckStateEncap="line15";
        line15 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,840);
        line15.setDuration(3000);
        line15.start();
        line15.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Encap_Animation.this, "เข้าถึงเมธอด getName()ของคลาส Employee ผ่าน object", Toast.LENGTH_SHORT).show();
                Log.d("State","line15 finished");
                //GoLine3
                GoLine3();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //GoLine3
    private void GoLine3()
    {
        CheckStateEncap="line3";
        line3 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,120);
        line3.setDuration(3000);
        line3.start();
        line3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                getter_text.setVisibility(View.VISIBLE);
                Getter_box.setVisibility(View.VISIBLE);
                Toast.makeText(Encap_Animation.this, "เข้าสู่เมธอด getName()", Toast.LENGTH_SHORT).show();
                Log.d("State","line3 finished");
                //Go to line4
                GoLine4();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line4
    private void GoLine4()
    {
        CheckStateEncap="line4";
        line4 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,190);
        line4.setDuration(3000);
        line4.start();
        line4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line4 finished");
                Getter_box.setTextColor(Color.parseColor("#FFFFFF"));
                //Goto Line5
                GoLine5();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
    //Line5
    private  void GoLine5()
    {
        CheckStateEncap="line5";
        line5 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,250);
        line5.setDuration(3000);
        line5.start();
        line5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Getter_box.setText("Torn");
                Toast.makeText(Encap_Animation.this, "ส่งค่าของ empName กลับไปที่ object", Toast.LENGTH_LONG).show();
                Log.d("State","line5 finished");
                output_header.setVisibility(View.VISIBLE);
                output_layout.setVisibility(View.VISIBLE);
                GoLine15_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //playgetAnimation
    private void playgetAnimation()
    {
        CheckStateEncap="playgetAnimation";
        ObjectAnimator moveDown = ObjectAnimator.ofFloat(Getter_box,View.TRANSLATION_Y,600);
        ObjectAnimator hide = ObjectAnimator.ofFloat(Getter_box,View.ALPHA,0f);
        hide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        getAnimation = new AnimatorSet();
        getAnimation.setDuration(2500);
        getAnimation.playSequentially(moveDown,hide);
        getAnimation.start();
        getAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","playgetAnimation finished");
                //Go to line15
                GoLine15_1();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line15_1
    private void GoLine15_1()
    {
        CheckStateEncap="line15_1";
        line15_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,840);
        line15_1.setDuration(3000);
        line15_1.start();
        line15_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                output_result.setVisibility(View.VISIBLE);
                Toast.makeText(Encap_Animation.this, "แสดงค่าผลลัพธ์ออกทางหน้าจอ", Toast.LENGTH_SHORT).show();
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Encap_Animation.this,encap_teach.class);
        startActivity(intent);
        finish();
    }
}
