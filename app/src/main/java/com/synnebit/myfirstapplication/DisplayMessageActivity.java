package com.synnebit.myfirstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String a_string = intent.getStringExtra(Quadratic.A);
        String b_string = intent.getStringExtra(Quadratic.B);
        String c_string = intent.getStringExtra(Quadratic.C);

        int a = Integer.parseInt(a_string.trim());
        int b = Integer.parseInt(b_string.trim());
        int c = Integer.parseInt(c_string.trim());

        TextView textView = new TextView(this);
        textView.setTextSize(24);
        textView.setTextColor(Color.BLACK);

        double root_one = (-b + Math.sqrt((4 * a * c) - Math.pow(b, 2))) / (2 * a);
        double root_two = (-b - Math.sqrt((4 * a * c) - Math.pow(b, 2))) / (2 * a);

        String A = a + "x² + ";
        String B = b + "x + ";

        if (a == 0)
            A = "";
        if (a == 1)
            A = "x² + ";
        if (b == 0)
            B = "";
        if (b == 1)
            B = "x + ";

        String real_root = "The roots of " + A + B + c + " are " + root_one + " and " + root_two + ".";
        String complex_root = "The roots of " + A + B + c + " are " + root_one + "i and " + root_two + "i.";

        if (root_one == root_two)
        {
            real_root = "The root of " + A + B + c + " is " + root_one + ".";
            complex_root = "The root of " + A + B + c + " is " + root_one + "i.";
        }

        if (Math.pow(b, 2) - (4 * a * c) < 0)
            textView.setText(complex_root);
        else
            textView.setText(real_root);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

}
