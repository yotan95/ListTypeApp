package com.practice.listtypeapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.practice.listtypeapp.R;
import com.practice.listtypeapp.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

//멤버 인젝션을 하도록 DaggerAppCompatActivity를 상속
public class MainActivity extends DaggerAppCompatActivity {

    //바인딩 클래스 주입
    @Inject
    Lazy<ActivityMainBinding> binding;
    // 액티비티 생성이 끝기 전에 setContentView()가 호출 되면 안되기 때

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 이 액티비티를 lifecycleOwner로 설정하여,
        // 생명 주기에 안전하게 데이터바인딩을 할 수 있도록 한다.
        //setContentView(R.layout.activity_main);
        binding.get().setLifecycleOwner(this);
    }
}
