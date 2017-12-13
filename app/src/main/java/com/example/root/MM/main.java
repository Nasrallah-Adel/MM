package com.example.root.MM;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.root.MM.R;

public class main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout dl;

    ActionBarDrawerToggle ad;
    NavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dl = (DrawerLayout) findViewById(R.id.m2);
        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
        nav.setItemIconTintList(null);
        ad=new ActionBarDrawerToggle(
                this,
                dl,

                R.string.open,
                R.string.close
        ) {

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(main.this, "Drawer Opened",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(main.this, "Drawer Closed",
                        Toast.LENGTH_SHORT).show();
            }
        };

        dl.addDrawerListener(ad);
        ad.syncState();
     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (ad.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mid) {
            Intent i = new Intent(main.this, Shannon.class);
            startActivity(i);
        } if (id == R.id.mid2) {
            Intent i = new Intent(main.this, huffman_activity.class);
            startActivity(i);
        }if (id == R.id.mid3) {
            Intent i = new Intent(main.this, run_len.class);
            startActivity(i);
        }
        return false;
    }
}
