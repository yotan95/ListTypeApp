package com.practice.listtypeapp.ui.post;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class PostViewModel extends AndroidViewModel {

    public PostViewModel(@NonNull Application application) {
        super(application);
    }
    public void loadPosts(){

    }
    public MutableLiveData<Boolean> getLoading(){
        return loading();
    }
}
