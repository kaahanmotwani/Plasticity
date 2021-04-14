package com.example.myapplication.ui.log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LogViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LogViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the log page!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}