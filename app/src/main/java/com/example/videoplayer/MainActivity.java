package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView miVideo;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miVideo = findViewById(R.id.videoViewMiVideo);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(miVideo);
        miVideo.setMediaController(mediaController);
        miVideo.setVideoURI(Uri.parse("android.resource://" +getPackageName() + "/" +  R.raw.adicto));

        miVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaController.show(10000);
                miVideo.start();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        mediaController.show();
        return true;
    }
}