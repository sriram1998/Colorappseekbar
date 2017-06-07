package com.example.sriram.colorapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    View view;
    int i=0;
    int j=0;
    int k=0;
    SeekBar seekbar1;
    SeekBar seekbar2;
    SeekBar seekbar3;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        view=this.findViewById(android.R.id.content);
        setContentView(R.layout.activity_main);

        seekbar1=(SeekBar) findViewById(R.id.seekBar);
        seekbar2=(SeekBar) findViewById(R.id.seekBar2);
        seekbar3=(SeekBar) findViewById(R.id.seekBar3);

        seekbar1.setMax(255);
        seekbar2.setMax(255);
        seekbar3.setMax(255);
        int ir,jr,kr;
        ir=sharedPref.getInt("bgr",0);

        jr=sharedPref.getInt("bgg",0);
        kr=sharedPref.getInt("bgb",0);
        view.setBackgroundColor(Color.rgb(ir,jr,kr));
        seekbar1.setProgress(ir);
        seekbar2.setProgress(jr);
        seekbar3.setProgress(kr);


        textView=(TextView) findViewById(R.id.textView);
        textView.setTextColor(Color.rgb(230,200,200));
        textView.setText("red:"+String.valueOf(ir)+"   green:"+String.valueOf(jr)+"  blue:"+String.valueOf(kr));
        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i=progress;
                chred(view);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                j=progress;
                chgreen(view);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                k=progress;
                chblue(view);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }



    public void reset(View v){
        SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        SharedPreferences.Editor editor=sharedPref.edit();
        i=0;
        j=0;
        k=0;
        view.setBackgroundColor(Color.rgb(i, j, k));
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
        seekbar1.setProgress(0);
        seekbar2.setProgress(0);
        seekbar3.setProgress(0);



        editor.putInt("bgr",i);
        editor.putInt("bgg",j);
        editor.putInt("bgb",k);
        editor.apply();
    }

    public void chred(View v) {
        SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        SharedPreferences.Editor editor=sharedPref.edit();

        i=sharedPref.getInt("bgr",0);
        j=sharedPref.getInt("bgg",0);
        k=sharedPref.getInt("bgb",0);
        i=seekbar1.getProgress();
        view.setBackgroundColor(Color.rgb(i, j, k));
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
        editor.putInt("bgr",i);
        editor.apply();
    }

    public void chgreen(View v)
    {SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        SharedPreferences.Editor editor=sharedPref.edit();

        i=sharedPref.getInt("bgr",0);
        j=sharedPref.getInt("bgg",0);
        k=sharedPref.getInt("bgb",0);

        j=seekbar2.getProgress();
       view.setBackgroundColor(Color.rgb(i, j, k));
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
        editor.putInt("bgg",j);
        editor.apply();
    }


    public void chblue(View v)
    {SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        SharedPreferences.Editor editor=sharedPref.edit();

        i=sharedPref.getInt("bgr",0);
        j=sharedPref.getInt("bgg",0);
        k=sharedPref.getInt("bgb",0);

        k=seekbar3.getProgress();
        view.setBackgroundColor(Color.rgb(i, j, k));
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
        editor.putInt("bgb",k);
        editor.apply();
    }

}
