package com.mac_available.youngstagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mac_available.youngstagram.bottomtab1.HomeFragment;
import com.mac_available.youngstagram.bottomtab2.SearchFragment;
import com.mac_available.youngstagram.bottomtab4.FavoriteFragment;
import com.mac_available.youngstagram.bottomtab3.MyPageFragment;
import com.mac_available.youngstagram.bottomtab5.SettingFragment;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE_FOR_PERMISSION = 0;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view_main);
        fragments = new Fragment[5];
        fragmentManager = getSupportFragmentManager();
        fragments[0] = new HomeFragment();

        fragmentManager.beginTransaction().add(R.id.main_fragment_container, fragments[0]).commit();

        String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_DENIED ) {
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_FOR_PERMISSION);
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                for (int i = 0; i < fragments.length; i++) {
                    if (fragments[i] != null) {
                        transaction.hide(fragments[i]);
                    }
                }

                switch (id) {
                    case R.id.bottom_main_home:
                        if (fragments[0] == null) {
                            fragments[0] = new HomeFragment();
                            transaction.add(R.id.main_fragment_container, fragments[0]);
                        }
                        transaction.show(fragments[0]);

                        break;
                    case R.id.bottom_main_search:
                        if (fragments[1] == null) {
                            fragments[1] = new SearchFragment();
                            transaction.add(R.id.main_fragment_container, fragments[1]);
                        }
                        transaction.show(fragments[1]);
                        break;
                    case R.id.bottom_main_my_page:
                        if (fragments[2] == null) {
                            fragments[2] = new MyPageFragment();
                            transaction.add(R.id.main_fragment_container, fragments[2]);
                        }
                        transaction.show(fragments[2]);
                        break;
                    case R.id.bottom_main_favorite:
                        if (fragments[3] == null) {
                            fragments[3] = new FavoriteFragment();
                            transaction.add(R.id.main_fragment_container, fragments[3]);
                        }
                        transaction.show(fragments[3]);
                        break;
                    case R.id.bottom_main_setting:
                        if (fragments[4] == null) {
                            fragments[4] = new SettingFragment();
                            transaction.add(R.id.main_fragment_container, fragments[4]);
                        }
                        transaction.show(fragments[4]);
                        break;
                }

                transaction.commit();

                return true;
            }
        });
    }

    public void clickBtn(View view) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        
    }
}