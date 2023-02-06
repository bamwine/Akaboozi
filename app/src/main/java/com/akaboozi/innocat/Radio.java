package com.akaboozi.innocat;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class Radio extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    private ImageButton btnPlay;
    private ImageButton stop;

    // Media Player
    private  MediaPlayer mp;
    // Handler to update UI timer, progress bar etc,.
    private Handler mHandler = new Handler();;
    private Utilities utils;
    private final static String URL="http://185.105.4.50:7562";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        // All player buttons
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        stop = (ImageButton) findViewById(R.id.stop);


        // Mediaplayer
        mp = new MediaPlayer();
        utils = new Utilities();
        // Listeners

        mp.setOnCompletionListener(this); // Important



        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check for already playing
                if(mp.isPlaying()){
                    if(mp!=null){
                        mp.pause();
                        // Changing button image to play button
                        btnPlay.setImageResource(R.drawable.btn_play);
                    }
                }else{
                    // Resume song
                    if(mp!=null){
                        mp.reset();
                        try {
                            mp.setDataSource(URL);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            mp.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mp.start();
                        // Changing button image to pause button
                        btnPlay.setImageResource(R.drawable.btn_pause);
                    }
                }

            }
        });

        /**
         * Forward button click event
         * Forwards song specified seconds
         * */
        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    stopPlaying();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });





    }


    private void stopPlaying() throws IOException {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp.setDataSource(URL);
            mp.prepareAsync();

        }


    }

    public void  playSong(){
        // Play song
        try {
            mp.reset();
            mp.setDataSource(URL);
            mp.prepare();
            mp.start();
            // Changing Button Image to pause image
            btnPlay.setImageResource(R.drawable.btn_pause);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        mp.release();
//    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onPause() {
        super.onPause();
//        if (mp.isPlaying()) {
//            mp.stop();
//        }
    }
}