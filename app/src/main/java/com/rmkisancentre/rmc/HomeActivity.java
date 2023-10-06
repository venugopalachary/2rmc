package com.rmkisancentre.rmc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity  implements  TrainingData.OnFragmentInteractionListener , NavigationView.OnNavigationItemSelectedListener{

    FragmentManager fragmentManager;

    Fragment fragment = null;

    private Context context;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;



    FrameLayout frameLayout;

    Toolbar toolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* setSupportActionBar(toolbar);*/

        drawerLayout = findViewById(R.id.drawer_layout);

        frameLayout=findViewById(R.id.fragment_container);

        toolbar=findViewById(R.id.toolbar);

        fragmentManager=getSupportFragmentManager();
        loadFragment(new MainActivity());
        context = this;


        navigationView = findViewById(R.id.nav_view);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_item1:
                        // Handle item 1 click

                        loadFragment(new TrainingData());

                        break;
                    case R.id.nav_item2:
                        // Handle item 2 click
                        loadFragment(new SoilFragment());
                        break;
                    // Add more cases for other items


                }

                return false;
            }
        });


        // To toggle the navigation drawer when the hamburger icon is clicked
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }





    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.notifications) {
            // Handle the camera action


            loadFragment(new NotificationsFragment());



        } else if (id == R.id.tc) {

            loadFragment(new termsAndConditionsFragment());

        } else if (id == R.id.pp) {

            loadFragment(new PrivacyPolicyFragment());

        } else if (id == R.id.rp) {

            loadFragment(new RefundPolicyFragment());

        } else if (id == R.id.contactus) {

            loadFragment(new ContactUsFragment());

        } else if (id == R.id.home) {

            loadFragment(new MainActivity());

        }



        // Close the drawer when an item is selected
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //here we are loading fragments
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    /*  .addToBackStack(null)*/
                    .commit();


            return true;
        }
        return false;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
