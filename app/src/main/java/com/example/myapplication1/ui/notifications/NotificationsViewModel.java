package com.example.myapplication1.ui.notifications;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication1.db.*;
import android.content.Context;

import java.sql.SQLDataException;
import java.util.List;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> proteinDataText;
    private DbManager dbManager;
    private Context context;

    public NotificationsViewModel()
    {
        proteinDataText = new MutableLiveData<>();
        dbManager = new DbManager(context);
    }

    public LiveData<String> setProteinsText()
    {
        try {
            dbManager.openDb();
            List<Integer> proteins = dbManager.getFromDbProteins();
            proteinDataText.setValue(String.valueOf(proteins));
            dbManager.closeDb();
        }finally {}


        return proteinDataText;
    }
}
