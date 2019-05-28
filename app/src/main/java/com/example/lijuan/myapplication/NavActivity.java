package com.example.lijuan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

public class NavActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent2 = getIntent();
        final String staffname = intent2.getStringExtra("staffname");

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        /*if(navigationView.getHeaderCount() > 0){
            View header = navigationView.inflateHeaderView(R.layout.nav_header);
            TextView user = (TextView) header.findViewById(R.id.username);
            user.setText(staffname);
        }*/


        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_view_list_white_24dp);
        }

//        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawers();
                return true;
            }
        });

        ImageButton subjectManage = (ImageButton) findViewById(R.id.subject_manage);
        ImageButton voucherInput = (ImageButton) findViewById(R.id.voucher_input);
        ImageButton accountProduce = (ImageButton) findViewById(R.id.account_produce);
        ImageButton accountQuery = (ImageButton) findViewById(R.id.account_query);

        subjectManage.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, SubjectManage.class);
                startActivity(intent);
            }
        }));

        voucherInput.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, VoucherInput.class);
                startActivity(intent);
            }
        });

        accountQuery.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, AccountQuery.class);
                startActivity(intent);
            }
        });

        accountProduce.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this, AccountProduce.class);
                startActivity(intent);
            }
        });

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
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            ActivityCollector.finishAll();
            return true;
        }

        if(id == android.R.id.home){
            drawer.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_advice) {
            // Handle the camera action
        } else if (id == R.id.nav_contact) {

        } else if (id == R.id.nav_update) {

        } else if(id == R.id.nav_view){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
