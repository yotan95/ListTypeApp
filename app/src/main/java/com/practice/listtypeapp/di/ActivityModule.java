package com.practice.listtypeapp.di;

import com.practice.listtypeapp.ui.MainActivity;
import com.practice.listtypeapp.ui.MainModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    /*
    * MainActivity를 위한 서브 컴포넌트를 정의한다.
    * */
    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
