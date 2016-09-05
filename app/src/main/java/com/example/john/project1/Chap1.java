package com.example.john.project1;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class Chap1 extends AppCompatActivity {
    //Creating objects.
    Intent intent;
    ImageView imgPointer;
    ImageButton playbtn,stopbtn;
    ScrollView sv_code;
    LinearLayout layout_code;
    Chap1 obj_chap1;
    EditText edt;
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
        obj_chap1 = new Chap1();

        edt = (EditText)findViewById(R.id.testText);


        //Using method onClickListener for event handler on play button.
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calling method 'startPointer()'.
               /* startMoving();*/

                try {
                    a = Integer.parseInt(edt.getText().toString());
                }
                catch(NumberFormatException e)
                {
                    System.out.print("Cannot parse to Integer."+e);
                }

                testPointer(a);
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
                                        Toast.makeText(Chap1.this, "Finished", Toast.LENGTH_SHORT).show();
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
        obj_chap1.testPointer(0);

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
