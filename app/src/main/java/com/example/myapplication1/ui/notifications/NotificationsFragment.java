package com.example.myapplication1.ui.notifications;

import static android.content.Context.MODE_PRIVATE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import android.database.Cursor;
import android.database.sqlite.*;
import android.view.View;

import com.example.myapplication1.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //database/////////////////////////////////////////////////////////////////////
/*
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("app.db", null);
        db.execSQL("CREATE TABLE IF NOT EXISTS products (name TEXT, proteins INTEGER, fats INTEGER, carbohydrates INTEGER)");
        Cursor query = db.rawQuery("SELECT * FROM products;", null);

        String name = query.getString(0);
        int proteins = query.getInt(1);
        int fats = query.getInt(2);
        int carbohydrates = query.getInt(3);
        query.close();
        db.close();
*/

        //database/////////////////////////////////////////////////////////////////////

        final TextView textView = binding.caloriesMain;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void AddCal()
    {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("app.db", null);
        db.execSQL("CREATE TABLE IF NOT EXISTS productsCurrent (name TEXT, proteins INTEGER, fats INTEGER, carbohydrates INTEGER)");
        Cursor query = db.rawQuery("SELECT * FROM products;", null);

        String name = query.getString(0);
        int proteins = query.getInt(1);
        int fats = query.getInt(2);
        int carbohydrates = query.getInt(3);
        query.close();
        db.close();
    }
}