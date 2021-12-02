package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int starttime=0;
    int stoptime=0;
    int forwardtime=5000;
    int backwardtime=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1=findViewById(R.id.textView);
        Button play=findViewById(R.id.button8);
        Button forward=findViewById(R.id.button3);
        Button rewind=findViewById(R.id.button4);
        Button pause=findViewById(R.id.button2);
        Button restart=findViewById(R.id.button5);
        Button stop=findViewById(R.id.button6);


        MediaPlayer mediaPlayer;
        mediaPlayer= MediaPlayer.create(this,R.raw.first);
        t1.setText("first.mp3");
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Playing media now", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Song is paused", Toast.LENGTH_SHORT).show();
                 mediaPlayer.pause();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardtime) <= (stoptime =mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                }
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardtime) <= (stoptime =
                        mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                }
            }
        });


    }
}
