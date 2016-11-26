package com.example.john.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class polymor_animation extends AppCompatActivity {
    ImageButton playbtnPM,pausebtnPM,stopbtnPM;
    TextView output_resultPM,output_headerPM,classPM_text,objectPM_text;
    LinearLayout output_layoutPM;
    ImageView code,cat,cat_meow,pointer,class_PM;
    ScrollView sv_codePM;
    int countPush=0;
    String CheckStatePoly="";
    Boolean CheckScrolling=true;

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
        //prepare
        prepare();
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
}
