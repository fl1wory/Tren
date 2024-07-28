package com.example.myapplication1.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> proteinDataText;

    public NotificationsViewModel() {
        proteinDataText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return proteinDataText;
    }
}
