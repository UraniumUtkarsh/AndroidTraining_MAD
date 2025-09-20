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
    Button play, stop;
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
                Uri.parse("http://utkarshpandey.com/assets/sound/nuclear-siren.mp3"));
        //to initialize the java fields from UI widgets
        play=findViewById(R.id.btn_play);
        stop=findViewById(R.id.btn_stop);
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

    }
}