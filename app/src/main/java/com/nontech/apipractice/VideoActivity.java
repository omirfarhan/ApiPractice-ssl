package com.nontech.apipractice;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class VideoActivity extends AppCompatActivity {

    PlayerView playerView;
    public static String channel="http://116.202.46.40:9023/ZEE_HINDI/index.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        playerView=findViewById(R.id.exoplayerview);



        try {

            SimpleExoPlayer player = new SimpleExoPlayer.Builder(VideoActivity.this).build();
            playerView.setPlayer(player);

            MediaItem mediaItem=MediaItem.fromUri(channel);
            player.addMediaItem(mediaItem);
            player.prepare();
            player.play();


        }catch (Exception e){
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerView.onPause();

    }

    @Override
    protected void onPause() {
        super.onPause();
        playerView.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        playerView.onPause();
    }
}