package com.example.john.project1;

import android.animation.Animator;
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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class dh_animation extends AppCompatActivity {
    ImageView pointer,class_DH;
    ImageButton playbtn,pausebtn,stopbtn;
    ScrollView sv_codeDH;
    TextView object_DH_text,class_DH_text,output_headerDH,output_resultDH,obj_name,error_text,obj_name_header;
    LinearLayout outputLayoutDH,layoutcode;
    int countPush=0;
    String CheckStateDataHiding="";
    Boolean checkScrolling=true;
    ObjectAnimator line7,line9,line17,line9_1,line10,line17_1,line18,line10_1,line11,line12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dh_animation);
        pointer = (ImageView)findViewById(R.id.pointer_PM);
        class_DH_text = (TextView)findViewById(R.id.classPM_text);
        object_DH_text = (TextView)findViewById(R.id.object_PM_text);
        output_headerDH = (TextView)findViewById(R.id.output_headerDH);
        output_resultDH = (TextView)findViewById(R.id.output_reseultDH);
        outputLayoutDH = (LinearLayout)findViewById(R.id.output_layoutPM);
        class_DH = (ImageView)findViewById(R.id.class_PM);
        playbtn = (ImageButton)findViewById(R.id.playbtnDatahide);
        pausebtn = (ImageButton)findViewById(R.id.pausebtnDatahide);
        stopbtn = (ImageButton)findViewById(R.id.stopbtn_Datahide);
        sv_codeDH = (ScrollView)findViewById(R.id.sv_codePM);
        layoutcode =(LinearLayout)findViewById(R.id.outputDH_code);
        obj_name = (TextView)findViewById(R.id.name);
        error_text = (TextView)findViewById(R.id.error_text);
        obj_name_header = (TextView)findViewById(R.id.name_header);
        //call method prepare
        prepare();

        //playbtn
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoLine7();
            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countPush += 1;
                try {
                    if (countPush % 2 != 0)
                    {
                        pause();
                    }
                    else if(countPush %2==0)
                    {
                        resume();
                    }
                }catch (Exception e)
                {
                    Log.d("State","Error happened");
                }
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread.currentThread().interrupt();
                recreate();
            }
        });
    }
    //pasue Metthod
    private void pause()
    {
        if(CheckStateDataHiding.equals("line7"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line7.pause();
            Log.d("State","line7 paused");
        }
        else if(CheckStateDataHiding.equals("line9"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line9.pause();
            Log.d("State","line9 paused");
        }
        else if(CheckStateDataHiding.equals("line17"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line17.pause();
            Log.d("State","line17 paused");
        }
        else if(CheckStateDataHiding.equals("line9_1"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line9_1.pause();
            Log.d("State","line9_1 paused");
        }
        else if(CheckStateDataHiding.equals("line10"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line10.pause();
            Log.d("State","line10 paused");
        }
        else if(CheckStateDataHiding.equals("line17_1"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line17_1.pause();
            Log.d("State","line17_1 paused");
        }
        else if(CheckStateDataHiding.equals("line18"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line18.pause();
            Log.d("State","line18 paused");
        }
        else if(CheckStateDataHiding.equals("line10"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line10.pause();
            Log.d("State","line10 paused");
        }
        else if(CheckStateDataHiding.equals("line11"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line11.pause();
            Log.d("State","line11 paused");
        }
        else if(CheckStateDataHiding.equals("line12"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line12.pause();
            Log.d("State","line12 paused");
        }
    }
    private void resume()
    {
        if(CheckStateDataHiding.equals("line7"))
        {
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            line7.resume();
            Log.d("State","line7 resume");
        }
        else if(CheckStateDataHiding.equals("line9"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line9.resume();
            Log.d("State","line9 resume");
        }
        else if(CheckStateDataHiding.equals("line17"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line17.resume();
            Log.d("State","line17 resume");
        }
        else if(CheckStateDataHiding.equals("line9_1"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line9_1.resume();
            Log.d("State","line9_1 resume");
        }
        else if(CheckStateDataHiding.equals("line10"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line10.resume();
            Log.d("State","line10 resume");
        }
        else if(CheckStateDataHiding.equals("line17_1"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line17_1.resume();
            Log.d("State","line17_1 resume");
        }
        else if(CheckStateDataHiding.equals("line18"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line18.resume();
            Log.d("State","line18 resume");
        }
        else if(CheckStateDataHiding.equals("line10"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line10.resume();
            Log.d("State","line10 resume");
        }
        else if(CheckStateDataHiding.equals("line11"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line11.resume();
            Log.d("State","line11 resume");
        }
        else if(CheckStateDataHiding.equals("line12"))
        {
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
            line12.resume();
            Log.d("State","line12 resume");
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,datahide_teach.class);
        startActivity(intent);
        finish();
    }
    //Method prepare to hide elements on screen.
    private void prepare()
    {
        class_DH_text.setVisibility(View.INVISIBLE);
        object_DH_text.setVisibility(View.INVISIBLE);
        output_headerDH.setVisibility(View.INVISIBLE);
        output_resultDH.setVisibility(View.INVISIBLE);
        outputLayoutDH.setVisibility(View.INVISIBLE);
        class_DH.setVisibility(View.INVISIBLE);
        obj_name.setVisibility(View.INVISIBLE);
        error_text.setVisibility(View.INVISIBLE);
        obj_name_header.setVisibility(View.INVISIBLE);
    }
    //go line1
    private void GoLine7()
    {
        CheckStateDataHiding="line7";
        line7 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,360);
        line7.setDuration(3000);
        line7.start();
        line7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                class_DH.setVisibility(View.VISIBLE);
                class_DH_text.setVisibility(View.VISIBLE);
                Toast.makeText(dh_animation.this, "โปรแกรมเริ่มทำงานที่เมธอด main", Toast.LENGTH_SHORT).show();
                Log.d("State","line7 finished");
                //goto line9
                GoLine9();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line9
    private  void GoLine9()
    {
        CheckStateDataHiding="line9";
        line9 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,480);
        line9.setDuration(3000);
        line9.start();
        line9.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                class_DH.setImageResource(R.drawable.shape_circle_class);
                object_DH_text.setVisibility(View.VISIBLE);
                Toast.makeText(dh_animation.this, "ประกาศ object จากคลาส Example_test", Toast.LENGTH_SHORT).show();
                Log.d("State","line9 finished");
                //Go line17
                testScrollingDown(1000);
                //GoLine17
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
        CheckStateDataHiding="line17";
        line17 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,700);
        line17.setDuration(3000);
        line17.start();
        line17.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(dh_animation.this, "คลาส Example_test อยู่ที่ package2" , Toast.LENGTH_SHORT).show();
                Log.d("State","line17 finished");
                //Goto Line9 Again
                testScrollingUp(1250);
                GoLine9_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //goline9
    private void GoLine9_1()
    {
        CheckStateDataHiding="line9_1";
        line9_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,480);
        line9_1.setDuration(3000);
        line9_1.start();
        line9_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(dh_animation.this, "object พร้อมใช้งาน", Toast.LENGTH_SHORT).show();
                Log.d("State","line9_1 finished");
                //Go to Line10
                GoLine10();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line10
    private void GoLine10()
    {
        CheckStateDataHiding="line10";
        line10 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,540);
        line10.setDuration(3000);
        line10.start();
        line10.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(dh_animation.this, "เข้าถึง public attribute ชื่อ name ของ class Example_test ผ่าน object ได้โดยตรง", Toast.LENGTH_LONG).show();
                Log.d("State","line10 finished");
                testScrollingDown(1000);
                //GoLine17 again
                GoLine17_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line17_1
    private  void GoLine17_1()
    {
        CheckStateDataHiding="line17_1";
        line17_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,700);
        line17_1.setDuration(3000);
        line17_1.start();
        line17_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line17_1 finished");
                //GoLine18
                GoLine18();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //GoLine18
    private  void GoLine18()
    {
        CheckStateDataHiding="line18";
        line18 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,760);
        line18.setDuration(3000);
        line18.start();
        line18.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line18 finished");
                testScrollingUp(1250);
                //GoLine10 Again
                GoLine10_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //GoLine10 again
    private void GoLine10_1()
    {
        CheckStateDataHiding="line10_1";
        line10_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,540);
        line10_1.setDuration(4000);
        line10_1.start();
        line10_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                obj_name_header.setVisibility(View.VISIBLE);
                obj_name.setVisibility(View.VISIBLE);
                output_headerDH.setVisibility(View.VISIBLE);
                outputLayoutDH.setVisibility(View.VISIBLE);
                output_resultDH.setVisibility(View.VISIBLE);
                Toast.makeText(dh_animation.this, "แสดงผลลัพธ์ออกทางหน้าจอ", Toast.LENGTH_SHORT).show();
                Log.d("State","line10_1 finished");
                //GoLine11
                GoLine11();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //GoLine11
    private void GoLine11()
    {
        CheckStateDataHiding="line11";
        line11 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,600);
        line11.setDuration(3000);
        line11.start();
        line11.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                obj_name.setVisibility(View.INVISIBLE);
                obj_name_header.setVisibility(View.INVISIBLE);
                obj_name_header.setText("Error!");
                obj_name_header.setTextColor(Color.parseColor("#D50000"));
                obj_name_header.setVisibility(View.VISIBLE);
                Toast.makeText(dh_animation.this, "โปรแกรมเกิดข้อผิดพลาด กรุณาดูคำอธิบายข้อผิดพลาดที่มุมล่างขวา", Toast.LENGTH_SHORT).show();
                output_resultDH.setText("Attribute id ต้องเข้าถึงผ่านGetter/Setter Method เท่านั้น");
                Log.d("State","line11 finished");
                //GoLine12
                GoLine12();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line12
    private void GoLine12()
    {
        CheckStateDataHiding="line12";
        line12 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,660);
        line12.setDuration(3000);
        line12.start();
        line12.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(dh_animation.this, "โปรแกรมเกิดข้อผิดพลาด กรุณาดูคำอธิบายข้อผิดพลาดที่มุมล่างขวา", Toast.LENGTH_SHORT).show();
                output_resultDH.setText("Attribute salary ต้องเข้าถึงผ่านGetter/Setter Method เท่านั้น");
                Log.d("State","Application Finished");
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
                if(checkScrolling)
                {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    checkScrolling = false;
                    //Looping when 'CheckControl' is false.
                    while(!checkScrolling)
                    {
                        try
                        {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_codeDH.scrollBy(0,1);
                                    //If reachs the bottom line of code then stops it.
                                    if(sv_codeDH.getScrollY()==layoutcode.getBottom()-a)
                                    {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        checkScrolling=true;
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
                    checkScrolling =true;
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
                if(checkScrolling)
                {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    checkScrolling = false;
                    //Looping when 'CheckControl' is false.
                    while(!checkScrolling)
                    {
                        try
                        {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_codeDH.scrollBy(0,-1);
                                    //If reachs the bottom line of code then stops it.
                                    if(sv_codeDH.getScrollY()==layoutcode.getHeight()-a)
                                    {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        checkScrolling=true;
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
                    checkScrolling =true;
                }
            }
        }//This statement for starting the new thread execution.
        ).start();
    }
}
