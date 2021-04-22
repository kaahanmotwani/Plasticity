package com.example.myapplication.ui.friends;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchFriendsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SearchFriendsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the search friend page");
    }

    public LiveData<String> getText() {
        return mText;
    }
}