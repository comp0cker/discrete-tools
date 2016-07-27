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

public class BaseConverter extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public final static String A = "com.mycompany.myfirstapp.A";
    public final static String B = "com.mycompany.myfirstapp.B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_converter);
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

        Intent intent = new Intent(this, BaseDisplay.class);

        EditText le_number = (EditText) findViewById(R.id.number);
        String number = le_number.getText().toString();

        if(TextUtils.isEmpty(number)) {
            le_number.setError("You cannot leave this empty.");
            empty = true;
        }

        EditText le_base = (EditText) findViewById(R.id.base);
        String base = le_base.getText().toString();

        if(TextUtils.isEmpty(base)) {
            le_base.setError("You cannot leave this empty.");
            empty = true;
        }

        if (empty)
            return;

        intent.putExtra(A, number);
        intent.putExtra(B, base);

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

        } else if (id == R.id.nav_induction) {
            Intent intent = new Intent(this, Induction.class);
            startActivity(intent);
        } else if (id == R.id.nav_expansion) {
            Intent intent = new Intent(this, BinomialExpansion.class);
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
