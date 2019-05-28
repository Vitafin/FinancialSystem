package com.example.lijuan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

public class StaffNav extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_nav);

        Intent intent1 = getIntent();
        final String staffname = intent1.getStringExtra("staffname");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_staff);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_staff);

        NavigationView navigationView = (NavigationView) findViewById(R.id.staff_type_view);
        if(navigationView.getHeaderCount() > 0){
            View header = navigationView.inflateHeaderView(R.layout.nav_header);
            TextView user = (TextView) header.findViewById(R.id.username);
            user.setText(staffname);
        }


        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_view_list_white_24dp);
        }

//        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawer.closeDrawers();
                return true;
            }
        });

        ImageButton accountApply = (ImageButton) findViewById(R.id.account_apply);
        ImageButton progressCheck = (ImageButton) findViewById(R.id.progress_check);
        ImageButton accountQuery = (ImageButton) findViewById(R.id.account_query_go);

        accountApply.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffNav.this,AccountApplyStaff.class);
                intent.putExtra("staffname",staffname);
                startActivity(intent);
            }
        });

        progressCheck.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffNav.this,ProgressCheckStaff.class);
                intent.putExtra("staffname",staffname);
                startActivity(intent);
            }
        });

        accountQuery.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffNav.this,AccountQueryStaff.class);
                intent.putExtra("staffname",staffname);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_staff);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.staff_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_staff);

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_staff);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
