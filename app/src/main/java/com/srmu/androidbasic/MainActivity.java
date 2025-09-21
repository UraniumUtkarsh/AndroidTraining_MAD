package com.srmu.androidbasic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //declare the java fields
    Button play, pause, stop, play2, pause2, stop2;
    //music play krne k liye class MediaPlayer ki jarurat padegi
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //below line (ViewCompact) when removed, may apply padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //create context helps to attach...
        //Context means application ka reference
        mediaPlayer=MediaPlayer.create(this,
                Uri.parse("https://gothic-amaranth-gel7sx8g6w.edgeone.app/Tu%20Hain%20Toh%20Mr%20And%20Mrs%20Mahi%20128%20Kbps.mp3 "));
        //to initialize the java fields from UI widgets
        play=findViewById(R.id.btn_play);
        pause=findViewById(R.id.btn_pause);
        stop=findViewById(R.id.btn_stop);

        //dont know how to set Mediaplayer for song2 ? -- Question ??
        play2=findViewById(R.id.song2_playbtn);
        pause2=findViewById(R.id.song2_pausebtn);
        stop2=findViewById(R.id.song2_stopbtn);
        //to click on the buttons
        //play button ka object hai 'play'

        //type play dot enter
        //type new O enter (shortcuts)
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Gaana bajna shuru hogya hai🎶", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Gaana rok diya gya hai", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Gaana band kar diya gaya hai", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Song2 have started", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Song2 paused", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });
        stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Song2 Stopped!", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
            }
        });
    }
}