package com.softwarica.esoftwarice_assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softwarica.esoftwarice_assignment.Fragments.HomeFragment;
import com.softwarica.esoftwarice_assignment.Fragments.StudentFragment;
import com.softwarica.esoftwarice_assignment.Model.Students;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Students> studentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.btnNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (studentsList.isEmpty()) {
            studentsList.add(new Students("Sabina Sunuwar", "female", 20, "Boudha"));
            studentsList.add(new Students("Bigem Maharjan", "male", 21, "Patan"));
            studentsList.add(new Students("Sumina Maharjan", "female", 21, "Sundhara"));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.navHome:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navStudent:
                    selectedFragment = new StudentFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame, selectedFragment).commit();
            return true;
        }
    };
}
