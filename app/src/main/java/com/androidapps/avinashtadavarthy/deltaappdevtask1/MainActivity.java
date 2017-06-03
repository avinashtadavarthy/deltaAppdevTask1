package com.androidapps.avinashtadavarthy.deltaappdevtask1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout activity_main;
    Button red,green,blue,black;
    int r,g,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = getred();
        g = getgreen();
        b = getblue();

        activity_main = (RelativeLayout) findViewById(R.id.activity_main);

        red = (Button) findViewById(R.id.red);
        green = (Button) findViewById(R.id.green);
        blue = (Button) findViewById(R.id.blue);
        black = (Button) findViewById(R.id.black);

        activity_main.setBackgroundColor(Color.rgb(r,g,b));

        red.setText(String.valueOf(r));
        blue.setText(String.valueOf(b));
        green.setText(String.valueOf(g));

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                r=r+25;
                if(r>250)
                    r=0;

                activity_main.setBackgroundColor(Color.rgb(r,g,b));
                red.setText(String.valueOf(r));
                savedata(r,g,b);
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                g=g+25;
                if(g>250)
                    g=0;

                activity_main.setBackgroundColor(Color.rgb(r,g,b));
                green.setText(String.valueOf(g));
                savedata(r,g,b);
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                b=b+25;
                if(b>250)
                    b=0;

                activity_main.setBackgroundColor(Color.rgb(r,g,b));
                blue.setText(String.valueOf(b));
                savedata(r,g,b);
            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                r = g = b = 0;

                activity_main.setBackgroundColor(Color.rgb(r,g,b));

                red.setText(String.valueOf(r));
                blue.setText(String.valueOf(b));
                green.setText(String.valueOf(g));
            }
        });

    }

    public void savedata(int r1, int g1, int b1) {
        SharedPreferences sharedpref = getSharedPreferences("color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putInt("red", r1);
        editor.putInt("green", g1);
        editor.putInt("blue", b1);
        editor.commit();

    }

    public  int getred()
    {
        SharedPreferences sharedpref = getSharedPreferences("color", Context.MODE_PRIVATE);
        int r2 = sharedpref.getInt("red",0);
        return r2;

    }

    public  int getgreen()
    {
        SharedPreferences sharedpref = getSharedPreferences("color", Context.MODE_PRIVATE);
        int g2 = sharedpref.getInt("green",0);
        return g2;

    }

    public  int getblue()
    {
        SharedPreferences sharedpref = getSharedPreferences("color", Context.MODE_PRIVATE);
        int b2 = sharedpref.getInt("blue",0);
        return b2;

    }
}
