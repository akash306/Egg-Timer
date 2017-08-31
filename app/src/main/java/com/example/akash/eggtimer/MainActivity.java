package com.example.akash.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView eggImageView;
    SeekBar eggSeekBar;
    TextView timer;
    int m,s;

    public void updateTimer(int tim) {

        m = tim / 60;
        s = tim % 60;
        String time = "";
        if (s < 10) {

            time = "0";

        }
        timer.setText(m + ":" + time + s);

    }

    public void stop(View view) {

        new CountDownTimer(eggSeekBar.getProgress() * 1000 + 100, 1000) {

            @Override
            public void onTick(long l) {

                updateTimer((int) l /1000);

            }

            @Override
            public void onFinish() {

                timer.setText("0:00");
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.air_horn);
                mediaPlayer.start();

            }
        }.start();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eggImageView = (ImageView) findViewById(R.id.eggImageView);
        eggSeekBar = (SeekBar)findViewById(R.id.timerSeekBar);
        timer = (TextView) findViewById(R.id.timeTextView);
        Button stopButton = (Button) findViewById(R.id.stopButton);

        eggSeekBar.setMax(300);
        eggSeekBar.setProgress(5);

        eggSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
