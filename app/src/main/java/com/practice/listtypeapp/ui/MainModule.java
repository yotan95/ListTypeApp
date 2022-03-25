package com.practice.listtypeapp.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.practice.listtypeapp.R;
import com.practice.listtypeapp.databinding.ActivityMainBinding;
import com.practice.listtypeapp.di.ActivityContext;
import com.practice.listtypeapp.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {
    @Provides
    @ActivityScope
    static ActivityMainBinding provideBinding(MainActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

    @Provides
    @ActivityContext
    static Context provideContext(MainActivity activity){
        return activity;
    }
}
