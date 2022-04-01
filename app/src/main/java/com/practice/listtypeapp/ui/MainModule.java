package com.practice.listtypeapp.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.practice.listtypeapp.R;
import com.practice.listtypeapp.databinding.ActivityMainBinding;
import com.practice.listtypeapp.di.ActivityContext;
import com.practice.listtypeapp.di.ActivityScope;
import com.practice.listtypeapp.di.FragmentScope;
import com.practice.listtypeapp.ui.detail.PostDetailFragment;
import com.practice.listtypeapp.ui.detail.PostDetailModule;
import com.practice.listtypeapp.ui.post.PostFragment;
import com.practice.listtypeapp.ui.post.PostModule;
import com.practice.listtypeapp.ui.user.UserFragment;
import com.practice.listtypeapp.ui.user.UserModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

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

    /*
     * 서브 컴포넌트 정의
     * */
    @FragmentScope
    @ContributesAndroidInjector(modules = PostModule.class)
    abstract PostFragment getPostFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = PostDetailModule.class)
    abstract PostDetailFragment getPostDetailFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = UserModule.class)
    abstract UserFragment getUserFragment();


}
