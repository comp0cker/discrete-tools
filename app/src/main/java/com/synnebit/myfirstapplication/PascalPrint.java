package com.synnebit.myfirstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PascalPrint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_induction_proof);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String row_string = intent.getStringExtra(Pascal.ROW);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);

        int row = Integer.parseInt(row_string.trim());
        String pascal = "\n\nPascals Triangle with " + row + " rows:\n\n";

        for (int i = 0; i <= row; i++)
        {
            long term = 1;
            for (int k = 0; k <= i; k++)
            {
                pascal = pascal + term + "     ";
                term = term * (i - k) / (k + 1);
            }
            pascal =  pascal + "\n";
        }

        textView.setText(pascal);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.proof);
        layout.addView(textView);
    }

}
