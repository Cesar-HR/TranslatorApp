package com.devops.translatorapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.devops.translatorapp.ui.fragments.ConfiguracionFragment;
import com.devops.translatorapp.ui.fragments.HomeFragment;
import com.devops.translatorapp.ui.fragments.PerfilFragment;
import com.devops.translatorapp.ui.fragments.SobreNosotrosFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.layout_view_nav);
        navigationView = findViewById(R.id.view_nav);
        toolbar = findViewById(R.id.toolbar);

//        Toggle button to open navigation bar
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragments_view, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home_nav);
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home_nav) {
                replaceFragmentView(new HomeFragment());
                navigationView.setCheckedItem(R.id.home_nav);
            } else if (id == R.id.perfil_nav) {
                replaceFragmentView(new PerfilFragment());
                navigationView.setCheckedItem(R.id.perfil_nav);
            } else if (id == R.id.configuracion_nav) {
                replaceFragmentView(new ConfiguracionFragment());
                navigationView.setCheckedItem(R.id.configuracion_nav);
            } else if (id == R.id.sobre_nosotros_nav) {
                replaceFragmentView(new SobreNosotrosFragment());
                navigationView.setCheckedItem(R.id.sobre_nosotros_nav);
            }

            return true;
        });
    }

    private void replaceFragmentView(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragments_view, fragment);
        fragmentTransaction.commit();
    }
}