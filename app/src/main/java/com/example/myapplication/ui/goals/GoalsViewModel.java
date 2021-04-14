package com.example.myapplication.ui.goals;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GoalsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GoalsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the goals page.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}