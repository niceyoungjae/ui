package com.example.ui331;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuContact fragmentContact = new MainMenuContact();
    private MainMenuHome fragmentHome = new MainMenuHome();
    private MainMenuKeyPad fragmentKeyPad = new MainMenuKeyPad();
    private MainMenuRecent fragmentRecent = new MainMenuRecent();
    private MainMenuSetUp fragmentSetUp = new MainMenuSetUp();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new ItemSelectedListener());

    }
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            if (menuItem.getItemId() == R.id.menu_contact) {
                transaction.replace(R.id.menu_frame_layout, fragmentContact);
            } else if (menuItem.getItemId() == R.id.menu_home) {
                transaction.replace(R.id.menu_frame_layout, fragmentHome);
            } else if (menuItem.getItemId() == R.id.menu_keypad) {
                transaction.replace(R.id.menu_frame_layout, fragmentKeyPad);
            } else if (menuItem.getItemId() == R.id.menu_recent) {
                transaction.replace(R.id.menu_frame_layout, fragmentRecent);
            } else if (menuItem.getItemId() == R.id.menu_setup) {
                transaction.replace(R.id.menu_frame_layout, fragmentSetUp);
            }

            transaction.commitAllowingStateLoss();

            return true;
        }
    }
}