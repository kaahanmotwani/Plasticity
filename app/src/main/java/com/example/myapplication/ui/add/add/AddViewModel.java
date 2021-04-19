package com.example.myapplication.ui.add.add;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the add page.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}