package com.example.instagramreplica;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAinActivity";


    private BottomNavigationView bottomNavigationItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationItemView = findViewById(R.id.bottomNavigation);
        bottomNavigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                //return false;
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_compose:
                        Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_profile:
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_LONG).show();
                    default:
                        break;
                }
                return true;
            }

        });
    }
}