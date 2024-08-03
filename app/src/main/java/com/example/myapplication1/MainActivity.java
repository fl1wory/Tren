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

import com.example.myapplication1.db.DbManager;

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
        dbManager.openDb();
        for(String name : dbManager.getFromDb()){
            tvTest.append(name);
            tvTest.append("\n");
        }
    }

    public void onClickSave(View view) {
        dbManager.insertToDb(edName.getText().toString(), edDescription.getText().toString());
        for(String name : dbManager.getFromDb()){
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

