package com.example.sriram.colorapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    View view;
    int i=0;
    int j=0;
    int k=0;




    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {SharedPreferences sharedPref=getSharedPreferences("bginfo",0);

        int ir,jr,kr;
        ir=sharedPref.getInt("bgr",0);
        view=this.findViewById(android.R.id.content);
        jr=sharedPref.getInt("bgg",0);
        kr=sharedPref.getInt("bgb",0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view.setBackgroundColor(Color.rgb(ir,jr,kr));
        textView=(TextView) findViewById(R.id.textView);
    }


    public void chred(View v) {
        SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        SharedPreferences.Editor editor=sharedPref.edit();
        i=sharedPref.getInt("bgr",0);
        j=sharedPref.getInt("bgg",0);
        k=sharedPref.getInt("bgb",0);
        if (i == 256)
            i = 0;
        else {
            view.setBackgroundColor(Color.rgb(i, j, k));
            i=i+1;
            textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
            editor.putInt("bgr",i);
            editor.apply();

        }
    }

    public void chgreen(View v)
    {SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        SharedPreferences.Editor editor=sharedPref.edit();
        i=sharedPref.getInt("bgr",0);
        j=sharedPref.getInt("bgg",0);
        k=sharedPref.getInt("bgb",0);
        if (j == 256)
        j = 0;
    else {
        view.setBackgroundColor(Color.rgb(i, j, k));
        j=j+1;
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
        editor.putInt("bgg",j);
        editor.apply();
    }}


    public void chblue(View v)
    {SharedPreferences sharedPref=getSharedPreferences("bginfo",0);
        SharedPreferences.Editor editor=sharedPref.edit();
        i=sharedPref.getInt("bgr",0);
        j=sharedPref.getInt("bgg",0);
        k=sharedPref.getInt("bgb",0);
        if (k == 256)
        k = 0;
    else {
        view.setBackgroundColor(Color.rgb(i, j, k));
        k=k+1;
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
        editor.putInt("bgb",k);
        editor.apply();
    }
    }

}
