package com.example.john.project1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Constructor_chapter extends AppCompatActivity {
    //Declare reference
    ImageView pointer,classCode_construct;
    TextView class_text_construct,object_text_construct,
            str_header,str_text_construct,num_header,num_text_construct;
    ImageButton playConstruct,pauseConstruct,stopConstruct;
    int a1=0;
    ObjectAnimator objLine1,objLine4,objLine6,objLine7,objLine9,objLine10,objLine11,objLine12,objLine13;
    String checkState_Construct="";
    AnimatorSet amMovingAnimations;
    ObjectAnimator strheaderGoY,strheaderGoX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constructor_chapter);
        //Views
        pointer = (ImageView)findViewById(R.id.pointer_construct);
        classCode_construct = (ImageView)findViewById(R.id.pic_construct);
        class_text_construct =(TextView)findViewById(R.id.class_text_Construct);
        object_text_construct =(TextView)findViewById(R.id.object_text_Construct);
        str_header =(TextView)findViewById(R.id.str_header);
        str_text_construct =(TextView)findViewById(R.id.text_str_construct);
        num_header =(TextView)findViewById(R.id.num_header);
        num_text_construct =(TextView)findViewById(R.id.num_construct);

        prepareScreen();

        //Buttons
        playConstruct = (ImageButton)findViewById(R.id.playbtnConstruct);
        pauseConstruct =(ImageButton)findViewById(R.id.pausebtnConstruct);
        stopConstruct = (ImageButton)findViewById(R.id.stopbtnConstruct);

        //playbutton
        playConstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Constructor_chapter.this, "Start!", Toast.LENGTH_SHORT).show();

                testPointerLine1();
            }
        });
    }
    //Prepare screen
    private void prepareScreen()
    {
        classCode_construct.setVisibility(View.INVISIBLE);
        class_text_construct.setVisibility(View.INVISIBLE);
        object_text_construct.setVisibility(View.INVISIBLE);
        str_header.setVisibility(View.INVISIBLE);
        str_text_construct.setVisibility(View.INVISIBLE);
        num_header.setVisibility(View.INVISIBLE);
        num_text_construct.setVisibility(View.INVISIBLE);
    }
    //Line 1
    private  void testPointerLine1()
    {
        checkState_Construct="line1";
        objLine1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,0);
        objLine1.setDuration(2000);
        objLine1.start();
        objLine1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                classCode_construct.setVisibility(View.VISIBLE);
                class_text_construct.setVisibility(View.VISIBLE);
                //Go to line2
                Log.d("State","line1 finished");
                testPointerLine9();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Line9
    private void testPointerLine9()
    {
        checkState_Construct="line9";
        objLine9 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,480);
        objLine9.setDuration(2000);
        objLine9.start();
        objLine9.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //go to line10
                Log.d("State","Line9 finished");
                testPointerLine10();

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
    private void testPointerLine10()
    {
        checkState_Construct="line10";
        objLine10 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,540);
        objLine10.setDuration(2000);
        objLine10.start();
        objLine10.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                str_header.setVisibility(View.VISIBLE);
                str_text_construct.setVisibility(View.VISIBLE);
                Log.d("State","Line10 finished");
                //Got to line11
                testPointerLine11();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line11
    private void testPointerLine11()
    {
        checkState_Construct="line11";
        objLine11 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,610);
        objLine11.setDuration(2000);
        objLine11.start();
        objLine11.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","Line11 finished");
                classCode_construct.setImageResource(R.drawable.shape_circle_class);
                object_text_construct.setVisibility(View.VISIBLE);
                //Moving animation
                movingAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //MovingAnimation method
    private void movingAnimation()
    {
        checkState_Construct="movingAnimation";
        strheaderGoY = ObjectAnimator.ofFloat(str_header,View.TRANSLATION_Y,-300);
        strheaderGoX = ObjectAnimator.ofFloat(str_header,View.TRANSLATION_X,300);

        //AnimatorSet
        amMovingAnimations = new AnimatorSet();
        amMovingAnimations.playTogether(strheaderGoX,strheaderGoY);
        amMovingAnimations.setDuration(2000);
        amMovingAnimations.start();

    }
    //Test moving pointer
    private void testMoving(int a1)
    {
        ObjectAnimator obj = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y,a1);
        obj.setDuration(2000);
        obj.start();
    }
}
