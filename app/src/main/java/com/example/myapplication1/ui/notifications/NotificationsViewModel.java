package com.example.myapplication1.ui.notifications;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication1.MainActivity;
import com.example.myapplication1.db.*;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;
import java.util.List;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> proteinDataText;
    private DbManager dbManager;
    private Context context;

    public NotificationsViewModel() {
        dbManager = new DbManager();
        proteinDataText = new MutableLiveData<>();
    }

    public LiveData<String> setProteinsText() {
        dbManager.openDb();
        List<Integer> proteins = dbManager.getFromDbProteins();
        proteinDataText.setValue(String.valueOf(proteins));
        dbManager.closeDb();


        return proteinDataText;
    }
}
