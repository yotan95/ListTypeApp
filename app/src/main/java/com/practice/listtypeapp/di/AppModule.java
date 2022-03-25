package com.practice.listtypeapp.di;

import android.app.Application;
import android.content.Context;
import com.practice.listtypeapp.App;
import com.practice.listtypeapp.util.SingleLiveEvent;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module (includes = {
        ViewModelModule.class,
        RetrofitModule.class
})
public class AppModule {

    @Provides
    @Singleton
    Application provideApp(App app){
        return app;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(App app){
        return app;
    }

    // 앱의 오류 이벤트를 처리하는 SingleLiveEvent
    @Singleton
    @Provides
    @Named("ErrorEvent")
    SingleLiveEvent<Throwable> provideErrorEvent(){
        return new SingleLiveEvent<>();
    }

    //Retrofit 설정 Gson 컨버터, Rx 어댑터를 적용한 Retrofit 객체 생성
    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        return new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }




}
