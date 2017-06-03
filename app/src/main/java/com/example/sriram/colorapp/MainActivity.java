package com.example.sriram.colorapp;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(0,0,0));
        textView=(TextView) findViewById(R.id.textView);
    }

    public void chred(View v) {
        if (i == 256)
            i = 0;
        else {
            view.setBackgroundColor(Color.rgb(i, j, k));
            i=i+1;
            textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
        }
    }

    public void chgreen(View v)
    {if (j == 256)
        j = 0;
    else {
        view.setBackgroundColor(Color.rgb(i, j, k));
        j=j+1;
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
    }}


    public void chblue(View v)
    {if (k == 256)
        k = 0;
    else {
        view.setBackgroundColor(Color.rgb(i, j, k));
        k=k+1;
        textView.setText("red:"+String.valueOf(i)+"   green:"+String.valueOf(j)+"  blue:"+String.valueOf(k));
    }
    }

}
