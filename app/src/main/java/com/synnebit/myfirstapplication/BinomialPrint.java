package com.synnebit.myfirstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BinomialPrint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binomial_print);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String x = intent.getStringExtra(BinomialExpansion.X);
        String y = intent.getStringExtra(BinomialExpansion.Y);
        String a_string = intent.getStringExtra(BinomialExpansion.A);
        String b_string = intent.getStringExtra(BinomialExpansion.B);
        String n_string = intent.getStringExtra(BinomialExpansion.N);

        int a = Integer.parseInt(a_string.trim());
        int b = Integer.parseInt(b_string.trim());
        int n = Integer.parseInt(n_string.trim());

        TextView textView = new TextView(this);
        textView.setTextSize(24);
        textView.setTextColor(Color.BLACK);

        int row = n, diff, otherdiff;
        String text = "", str, str2;

        for (int i = 0; i <= row; i++)
        {
            int term = 1;
            for (int k = 0; k <= i; k++)
            {
                diff = a * (n - k);
                otherdiff = b * k;

                str = Integer.toString(diff);
                str2 = Integer.toString(otherdiff);

                str = str.replaceAll("0", "⁰");
                str = str.replaceAll("1", "¹");
                str = str.replaceAll("2", "²");
                str = str.replaceAll("3", "³");
                str = str.replaceAll("4", "⁴");
                str = str.replaceAll("5", "⁵");
                str = str.replaceAll("6", "⁶");
                str = str.replaceAll("7", "⁷");
                str = str.replaceAll("8", "⁸");
                str = str.replaceAll("9", "⁹");

                str2 = str2.replaceAll("0", "⁰");
                str2 = str2.replaceAll("1", "¹");
                str2 = str2.replaceAll("2", "²");
                str2 = str2.replaceAll("3", "³");
                str2 = str2.replaceAll("4", "⁴");
                str2 = str2.replaceAll("5", "⁵");
                str2 = str2.replaceAll("6", "⁶");
                str2 = str2.replaceAll("7", "⁷");
                str2 = str2.replaceAll("8", "⁸");
                str2 = str2.replaceAll("9", "⁹");

                String term_string = Integer.toString(term);

                if (term == 1) { // If the constant equals one, don't show the 1 in 1x or 1y
                    term_string = "";
                }
                if (i == row && k == 0) // Only show x^n in the first term
                    text = text + x + str + " + ";
                else if(i == row && k < i) // algorithm for all terms
                    text = text + term_string + x + str  + y + str2 + " + ";
                else if (i == row && k == i)
                    text = text + y + str2;

                term = term * (i - k) / (k + 1);
            }
        }

        textView.setText(text);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
