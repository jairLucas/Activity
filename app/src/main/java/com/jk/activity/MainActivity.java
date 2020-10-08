package com.jk.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mPlayer;
    Button btnMusicPause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(mPlayer != null){
            mPlayer.release();
        }
       mPlayer =  MediaPlayer.create(this,R.raw.one);
       mPlayer.seekTo(0);
       mPlayer.start();
        btnMusicPause= (Button) findViewById(R.id.btnMusicPause);
        btnMusicPause.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mPlayer != null){
            mPlayer.release();
        }
        mPlayer =  MediaPlayer.create(this,R.raw.one);
        mPlayer.seekTo(0);
        mPlayer.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.pause();
        //La app esta en segundo plano (background).
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
        mPlayer.release();
        //liberacion de recursos
    }
}