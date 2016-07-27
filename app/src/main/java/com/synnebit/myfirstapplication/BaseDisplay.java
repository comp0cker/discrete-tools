package com.synnebit.myfirstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BaseDisplay extends AppCompatActivity {

    public static String convert(int n, int b)
    {
        String s;
        int i = n % b;

        switch (i) {
            case 10:
                s = "A";
                break;
            case 11:
                s = "B";
                break;
            case 12:
                s = "C";
                break;
            case 13:
                s = "D";
                break;
            case 14:
                s = "E";
                break;
            case 15:
                s = "F";
                break;
            case 16:
                s = "G";
                break;
            case 17:
                s = "H";
                break;
            case 18:
                s = "I";
                break;
            case 19:
                s = "J";
                break;
            case 20:
                s = "K";
                break;
            case 21:
                s = "L";
                break;
            case 22:
                s = "M";
                break;
            case 23:
                s = "N";
                break;
            case 24:
                s = "O";
                break;
            case 25:
                s = "P";
                break;
            case 26:
                s = "Q";
                break;
            case 27:
                s = "R";
                break;
            case 28:
                s = "S";
                break;
            case 29:
                s = "T";
                break;
            case 30:
                s = "U";
                break;
            case 31:
                s = "V";
                break;
            case 32:
                s = "W";
                break;
            case 33:
                s = "X";
                break;
            case 34:
                s = "Y";
                break;
            case 35:
                s = "Z";
                break;
            default:
                s = Integer.toString(i);
        }

        if (i > 35)
            s = " '" + Integer.toString(i) + "' ";

        if (n / b == 0)
            return s;
        else
            return convert(n / b, b) + s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String number_string = intent.getStringExtra(BaseConverter.A);
        String base_string = intent.getStringExtra(BaseConverter.B);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);

        int number = Integer.parseInt(number_string.trim());
        int base = Integer.parseInt(base_string.trim());

        String answer = number + " in ";

        if (base == 2)
            answer+="binary";
        else if (base == 8)
            answer+="oct";
        else if (base == 16)
            answer+="hex";
        else
            answer+= "base " + base;

        answer+= " = " + convert(number, base);

        textView.setText(answer);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }
}


