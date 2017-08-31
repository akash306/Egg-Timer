package com.example.akash.eggtimer;

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

    public void stop(View view) {



    }

    public void setTextView() {
        
        new CountDownTimer(m,1000) {


            @Override
            public void onTick(long l) {

                String time;
                if (l% 60 < 10) {

                    time = l / 60 + ":0" + l %60;

                }
                else {

                    time = l / 60 + ":" + l %60;

                }
                Log.i("Info",time);
                timer.setText(time);

            }

            @Override
            public void onFinish() {

                Log.i("Info","Finished countdown");

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

                setTextView();

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
