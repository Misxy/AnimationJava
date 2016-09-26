package com.example.john.project1;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by John on 9/26/2016.
 */

public class Playsongs extends AppCompatActivity
{
    //Audio for button clicked
    final MediaPlayer mp1 = MediaPlayer.create(this,R.raw.enigma);
    //Audio for Application opened
    final MediaPlayer mp2 = MediaPlayer.create(this,R.raw.disceate_tone);

    public void playAppSong()
    {
       mp2.start();
    }

    public  void playButtonSong()
    {
        mp1.start();
    }

    public void releaseButtonsong()
    {
        mp1.release();
    }
    public void releaseAppSong()
    {
        mp2.release();
    }
}
