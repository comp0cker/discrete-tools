package com.synnebit.myfirstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InductionProof extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_induction_proof);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String a_string = intent.getStringExtra(Induction.A);
        String b_string = intent.getStringExtra(Induction.B);
        String c_string = intent.getStringExtra(Induction.C);
        String d_string = intent.getStringExtra(Induction.D);

        double a = Integer.parseInt(a_string.trim());
        double b = Integer.parseInt(b_string.trim());
        double c = Integer.parseInt(c_string.trim());
        double d = Integer.parseInt(d_string.trim());

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);

        double w = a / 4, x = a / 2 + b / 3, y = a / 4 + b / 2 + c / 2, z = b / 6 + c / 2 + d;

        String proof = "\n\nGiven\n\nSum of a constant = n\nSum of i = n(n + 1)/2 = (n² + n)/2\nSum of i² = (n * (n + 1)(2n + 1)) / 6 = (2n³ + 3n² + n) / 6\nSum of i³ = [(n * (n + 1)) / 2]² = [(n² + n) / 2]² = (n² + n)² / 4 = (n⁴ + 2n³ + n²) / 4"
                + "\nFinding the Sum of " + a + "n³ + " + b + "n² + " + c + "n + " + d + "\n\n"
                + "Sum = " + a + "[(n⁴ + 2n³ + n²) / 4] + " + b + "[(2n³ + 3n² + n) / 6] + " + c + "[(n² + n)/2] + " + d + "n\n"
                + "    = " + a / 4 + "n⁴ + " + a / 2 + "n³ + " + a / 4 + "n² + " + b / 3 + "n³ + " + b / 2 + "n² + " + b / 6 + "n + " + c / 2 + "n² + " + c / 2 + "n + " + d + "n\n"
                + "    = " + w + "n⁴ + " + x + "n³ + " + y + "n² + " + z
                + "n\n\nProof by Induction\n\n"
                + "Sneak Peek\n\nSum of n + 1 = " + w + "(n + 1)⁴ + " + x + "(n + 1)³ + " + y + "(n + 1)² + " + z + "(n + 1)\n"
                + "             = " + w + "(n⁴ + 4n³ + 6n² + 4n + 1) + " + x + "(n³ + 3n² + 3n + 1) + " + y + "(n² + 2n + 1) + " + z + "(n + 1)\n"
                + "             = " + w + "n⁴ + " + w * 4 + "n³ + " + w * 6 + "n² + " + w * 4 + "n + " + w + " + " + x + "n³ + " + 3 * x + "n² + " + 3 * x + "n + " + x + " + " + y + "n² + " + y * 2 + "n + " + y + " + " + z + "n + " + z + "\n"
                + "             = " + w + "n⁴ + " + (w * 4) + x + "n³ + " + (w * 6) + (3 * x) + y + "n² + " + (4 * w) + (3 * x) + (2 * y) + z + "n + " + w + x + y + z + "\n"
                + "\n\nProof\n\nSum of n + term n + 1 = [" + w + "n⁴ + " + x + "n³ + " + y + "n² + " + z + "n] + [" + a + "(n + 1)³ + " + b + "(n + 1)² + " + c + "(n + 1) + " + d + "]\n"
                + "                      = " + w + "n⁴ + " + x + "n³ + " + y + "n² + " + z + "n + " + a + "n³ + " + 3 * a + "n² + " + 3 * a + "n + " + a + " + " + b + "n² + " + 2 * b + "n + " + b + " + " + c + "n + " + c + " + " + d + "\n"
                + "                      = " + w + "n⁴ + " + (w * 4) + x + "n³ + " + (w * 6) + (3 * x) + y + "n² + " + (4 * w) + (3 * x) + (2 * y) + z + "n + " + w + x + y + z + "\n\n";

        textView.setText(proof);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.proof);
        layout.addView(textView);
    }

}
