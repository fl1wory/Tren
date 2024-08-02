package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication1.databinding.ActivityMainBinding;

import db.DbManager;

public class MainActivity extends AppCompatActivity {
    private DbManager dbManager;
    private EditText edName, edDescription;
    private ActivityMainBinding binding;
    private TextView tvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbManager = new DbManager(this);
        edName = findViewById(R.id.edName);
        edDescription = findViewById(R.id.edDescription);
        tvTest = findViewById(R.id.tvTest);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for(String name : DbManager.getFromDb()){
            tvTest.append(name);
            tvTest.append("\n");
        }
        dbManager.openDb();
    }

    public void onClickSave(View view) {
        dbManager.insertToDb(edName.getText().toString(), edDescription.getText().toString());
        for(String name : DbManager.getFromDb()){
            tvTest.append(name);
            tvTest.append("\n");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDb();
    }
}