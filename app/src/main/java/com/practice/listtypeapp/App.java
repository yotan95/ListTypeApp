package com.practice.listtypeapp;

import com.practice.listtypeapp.di.AppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;


// android.dagger 적용 시 Application 클래스를 먼저 정의
public class App extends DaggerApplication {

    @Override
    public void onCreate(){
        super.onCreate();
        //로그 Timber 설정
        Timber.plant(new Timber.DebugTree());
    }
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        // AppComponent 설정이 끝난 뒤,
        // 컴파일 타임에 DaggerAppComponent 가 생성

        return DaggerAppComponent.factory().create(this);
    }
}
