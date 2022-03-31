package com.practice.listtypeapp.ui.user;

import android.content.Context;
import android.view.LayoutInflater;

import com.practice.listtypeapp.databinding.FragmentUserBinding;
import com.practice.listtypeapp.di.ActivityContext;
import com.practice.listtypeapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @Provides
    @FragmentScope
    FragmentUserBinding provideBinding(@ActivityContext Context context){
        return FragmentUserBinding.inflate(LayoutInflater.from(context));
    }
}
