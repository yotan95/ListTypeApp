package com.practice.listtypeapp.di;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
