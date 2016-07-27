package com.synnebit.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class BinomialExpansion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public final static String X = "com.mycompany.myfirstapp.X";
    public final static String Y = "com.mycompany.myfirstapp.Y";
    public final static String A = "com.mycompany.myfirstapp.A";
    public final static String B = "com.mycompany.myfirstapp.B";
    public final static String N = "com.mycompany.myfirstapp.N";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binomial_expansion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void sendMessage(View view) {

        boolean empty = false;

        Intent intent = new Intent(this, BinomialPrint.class);

        EditText variable_x = (EditText) findViewById(R.id.x);
        String x = variable_x.getText().toString();

        EditText variable_y = (EditText) findViewById(R.id.y);
        String y = variable_y.getText().toString();

        EditText variable_a = (EditText) findViewById(R.id.a);
        String a = variable_a.getText().toString();

        EditText variable_b = (EditText) findViewById(R.id.b);
        String b = variable_b.getText().toString();

        EditText variable_n = (EditText) findViewById(R.id.n);
        String n = variable_n.getText().toString();

        if(TextUtils.isEmpty(x))
            intent.putExtra(X, "x");
        else
            intent.putExtra(X, x);

        if(TextUtils.isEmpty(y))
            intent.putExtra(Y, "y");
        else
            intent.putExtra(Y, y);

        if(TextUtils.isEmpty(a))
            intent.putExtra(A, "a");
        else
            intent.putExtra(A, 1);

        if(TextUtils.isEmpty(b))
            intent.putExtra(B, "b");
        else
            intent.putExtra(B, 1);

        if(TextUtils.isEmpty(n)) {
            variable_n.setError("You cannot leave this empty.");
            return;
        }

        intent.putExtra(N, n);

        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_pascal) {
            Intent intent = new Intent(this, Pascal.class);
            startActivity(intent);
        } else if (id == R.id.nav_base) {
            Intent intent = new Intent(this, BaseConverter.class);
            startActivity(intent);
        } else if (id == R.id.nav_induction) {
            Intent intent = new Intent(this, Induction.class);
            startActivity(intent);
        } else if (id == R.id.nav_quadratic) {
            Intent intent = new Intent(this, Quadratic.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
