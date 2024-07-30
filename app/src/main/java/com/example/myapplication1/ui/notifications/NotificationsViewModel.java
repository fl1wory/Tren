package com.example.myapplication1.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import com.example.myapplication1.DatabaseHelper.DatabaseHelper;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> nameDataText;
    private final MutableLiveData<Integer> proteinsDataText;
    private final MutableLiveData<Integer> fatsDataText;
    private final MutableLiveData<Integer> carbohydratesDataText;

    public NotificationsViewModel() {
        nameDataText = new MutableLiveData<>();
        proteinsDataText = new MutableLiveData<>();
        fatsDataText = new MutableLiveData<>();
        carbohydratesDataText = new MutableLiveData<>();


        ArrayList<String> name = new ArrayList<>();
        ArrayList proteins;
        ArrayList fats;
        ArrayList carbohydrates;

        NotificationsFragment ntf = new NotificationsFragment();
        DatabaseHelper dbh = ntf.dbhelper;
        try {
            ArrayList<ArrayList> data = dbh.setProductData();
            proteins = data.get(0);
            fats = data.get(1);
            carbohydrates = data.get(2);
        }
        catch (NullPointerException nullPointerException)
        {
            proteins = null;
            fats = null;
            carbohydrates = null;
            System.out.println(nullPointerException);
        }


        nameDataText.setValue("hfjhdjfh");
        proteinsDataText.setValue((Integer) 0);
        fatsDataText.setValue((Integer) 1);
        carbohydratesDataText.setValue((Integer) 3);
    }

    public LiveData<String> getNameText() {
        return nameDataText;
    }

    public LiveData<Integer> getProteinsText() {
        return proteinsDataText;
    }

    public LiveData<Integer> getFatsText() {
        return fatsDataText;
    }

    public LiveData<Integer> getCarbohydratesText() {
        return carbohydratesDataText;
    }
}