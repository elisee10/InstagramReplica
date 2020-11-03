package com.example.instagramreplica;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.instagramreplica.fragments.ComposeFragment;
import com.example.instagramreplica.fragments.PostsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAinActivity";

    private BottomNavigationView bottomNavigationItemView;
    final FragmentManager fragmentManager = getSupportFragmentManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationItemView = findViewById(R.id.bottomNavigation);
        bottomNavigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        //TODO: Update the fragment
                        //Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_LONG).show();
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        //Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_LONG).show();
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                        //TODO: Update the action profile
                        //Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_LONG).show();
                        fragment = new ComposeFragment();
                    default:
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }

        });
        //Set default selection 
        bottomNavigationItemView.setSelectedItemId(R.id.action_home);
    }
}