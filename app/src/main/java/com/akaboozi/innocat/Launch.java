package com.akaboozi.innocat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Launch extends AppCompatActivity {
    Thread   timer;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
        setTitle("");
        player =  MediaPlayer.create(Launch.this,R.raw.akaboozi);
        player.start();
           timer  = new Thread(){

            @Override
            public void run() {
               // super.run();
                try {
                sleep(5000);

                }catch (Exception e){}finally {

                    startActivity(new Intent(Launch.this,Dashboard.class));

                }

            }
        };
        timer.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        player.release();
        finish();
    }
}
