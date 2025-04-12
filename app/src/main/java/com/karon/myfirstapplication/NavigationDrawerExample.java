package com.karon.myfirstapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.karon.myfirstapplication.fragments.HomeFragment;
import com.karon.myfirstapplication.fragments.SettingsFragment;

public class NavigationDrawerExample extends AppCompatActivity {


    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView drawer_menu;
    Button btncall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigation_drawer_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadFragment(new HomeFragment());
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer_menu = (NavigationView) findViewById(R.id.drawer_menu);
        setSupportActionBar(toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                NavigationDrawerExample.this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        btncall = (Button) findViewById(R.id.btncall);
        
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Snackbar.make(findViewById(android.R.id.content), "Item Deleted", Snackbar.LENGTH_LONG)
                        .setAction("Undo", v -> {
                            Toast.makeText(NavigationDrawerExample.this, "Hiii", Toast.LENGTH_SHORT).show();
                        })
                        .show();
               // Toast.makeText(NavigationDrawerExample.this, "Hiii", Toast.LENGTH_SHORT).show();
            }
        });


//        drawer_menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if(item.getItemId() == R.id.nav_home)
//                {
//                    loadFragment(new HomeFragment());
//                }
//                else if(item.getItemId() == R.id.nav_setting)
//                {
//                    loadFragment(new SettingsFragment());
//
//                }
//                drawerLayout.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });

    }
    public void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,fragment);
        fragmentTransaction.commit();
    }
}