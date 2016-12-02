
package com.example.john.project1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, scoreset;
    int num = 0;
    int qesYes = 0;
    int qY = 0;
    int score = 0;
    int num1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.textView3);
        t2 = (Button) findViewById(R.id.button3);
        t3 = (Button) findViewById(R.id.button4);
        t4 = (Button) findViewById(R.id.button5);
        t5 = (Button) findViewById(R.id.button6);

        scoreset = (TextView) findViewById(R.id.textView6);

        markQes();
    }

    public void nextQes(View view) {
        markQes();
    }

    public void markQes() {
        scoreset.setText("คะแนน = " + String.valueOf(score) + "/10");
        num++;
        if (num == 1) {
            question1();
        } else if (num == 2) {
            question2();
        } else if (num == 3) {
            question3();
        } else if (num == 4) {
            question4();
        } else if (num == 5) {
            question5();
        } else if (num == 6) {
            question6();
        } else if (num == 7) {
            question7();
        } else if (num == 8) {
            question8();
        } else if (num == 9) {
            question9();
        } else if (num == 10) {
            question10();
        } else if (num == 11) {
            question11();
        } else {
            Intent intent = new Intent(MainActivity.this, Result.class);
            intent.putExtra("myScore", score);
            startActivity(intent);
        }
    }

    public void selQes1(View v) {
        Log.i("LOGG", "==> Process");
        qY = 1;
        summary();
    }

    public void selQes2(View v) {
        qY = 2;
        summary();
    }

    public void selQes3(View v) {
        qY = 3;
        summary();
    }

    public void selQes4(View v) {
        qY = 4;
        summary();
    }

    public void summary() {
        num1++;
        if (qY == qesYes) {
            score = score + 1;
            MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                    getResources().getString(R.string.title_Correct),
                    getResources().getString(R.string.message_Correct));
            myAlert.myDialog();
            markQes();
        } else {
            if (num1 == 1) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong1));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 2) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong2));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 3) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong3));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 4) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong4));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 5) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong5));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 6) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong6));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 7) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong7));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 8) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong8));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 9) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong9));
                myAlert.myDialog();
                markQes();
            } else if (num1 == 10) {
                MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.doremon48,
                        getResources().getString(R.string.title_Wrong),
                        getResources().getString(R.string.message_Wrong10));
                myAlert.myDialog();
                markQes();
            }
        }

    }

    public void question1() {
        qesYes = 2;//
        t1.setText("    1.Class เปรียบเสมือนอะไร");

        t2.setText("วัตถุ");
        t3.setText("พิมพ์เขียว");
        t4.setText("เมล็ดถั่ว");
        t5.setText("ฟองน้ำ");
    }

    public void question2() {

        qesYes = 3; //ข้อ 3 ถูก
        t1.setText(" 2.Sample s = new Sample(); คำสั่งข้างต้นใช้ทำอะไร");

        t2.setText("สร้าง Class");  //1
        t3.setText("สร้าง Constructor"); //2
        t4.setText("สร้าง Object"); //3 ข้อถูก 3
        t5.setText("สืบทอด Class"); //4
    }

    public void question3() {
        qesYes = 1;//
        t1.setText(" 3.extends คือคำสั่งที่ใช้สำหรับอะไร");

        t2.setText("สืบทอดคุณสมบัติ");
        t3.setText("เรียกใช้ค่า");
        t4.setText("ประกาศตัวแปร");
        t5.setText("กำหนดค่าคงที่");
    }

    public void question4() {
        qesYes = 1;//
        t1.setText("    4.Constructor ใช้ทำอะไร");

        t2.setText("กำหนดค่าเริ่มต้นให้ตัวแปร");
        t3.setText("คืนค่าทั้งหมดสู่ค่าเดิม");
        t4.setText("ส่งพารามิเตอร์");
        t5.setText("สร้างช่องทางเข้าถึง\nข้อมูลที่ปกปิดไว้");
    }

    public void question5() {
        qesYes = 4;//
        t1.setText("5.encapsulation ใช้ควบคู่กับ \nData hinding ได้อย่างไร");

        t2.setText("กำหนดค่าเริ่มต้นให้ตัวแปร");
        t3.setText("คืนค่าทั้งหมดสู่ค่าเดิม");
        t4.setText("ส่งพารามิเตอร์");
        t5.setText("สร้างช่องทางเข้าถึง\nข้อมูลที่ปกปิดไว้");
    }

    public void question6() {
        qesYes = 4;//
        t1.setText("6.การจำกัดการเข้าถึงแบบ public สามารถเข้าถึงจากที่ไหนได้บ้าง");

        t2.setText("Class เดียวกัน");
        t3.setText("Subclass เดียวกัน");
        t4.setText("Package เดียวกัน");
        t5.setText("เข้าถึงได้ทั้งหมด");
    }

    public void question7() {
        qesYes = 1;//
        t1.setText("7.การจำกัดการเข้าถึงแบบ private สามารถเข้าถึงจากที่ไหนได้บ้าง");

        t2.setText("Class เดียวกัน");
        t3.setText("Subclass เดียวกัน");
        t4.setText("Package เดียวกัน");
        t5.setText("เข้าถึงได้ทั้งหมด");
    }

    public void question8() {
        qesYes = 3;//
        t1.setText("8.การจำกัดการเข้าถึงแบบ protected สามารถเข้าถึงจากที่ไหนได้บ้าง");

        t2.setText("Class เดียวกันเท่านั้น");
        t3.setText("Class และ Subclass เดียวกัน");
        t4.setText("Class, Subclass และ Package เดียวกัน");
        t5.setText("เข้าถึงได้ทั้งหมด");
    }

    public void question9() {
        qesYes = 4;//
        t1.setText(" 9.\"มีความสามารถเดียวกัน แต่ผลลัพธ์ในการดำเนินการไม่\nเหมือนกัน\" ถูกกล่าวถึงในบทใด");

        t2.setText("classes and objects");
        t3.setText("encapsulation");
        t4.setText("inheritance");
        t5.setText("polymorphism");
    }

    public void question10() {
        qesYes = 2;//
        t1.setText("10.ประโยชน์ของ Inheritance คืออะไร");

        t2.setText("สามารถทำคำสั่งวนซ้ำ");
        t3.setText("เรียกใช้คำสั่งจาก\nคลาสแม่ได้ทันที");
        t4.setText("จำกัดการเข้าถึงได้");
        t5.setText("ถูกทุกข้อ");
    }

    public void question11() {
        qesYes = 2;//
        t1.setText("10.ประโยชน์ของ Inheritance คืออะไร");

        t2.setText("สามารถทำคำสั่งวนซ้ำ");
        t3.setText("เรียกใช้คำสั่งจาก\nคลาสแม่ได้ทันที");
        t4.setText("จำกัดการเข้าถึงได้");
        t5.setText("ถูกทุกข้อ");

        //test
        t2.setEnabled(false);
        t3.setEnabled(false);
        t4.setEnabled(false);
        t5.setEnabled(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
        finish();
    }
}
