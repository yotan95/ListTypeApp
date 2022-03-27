package com.practice.listtypeapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.practice.listtypeapp.R;
import com.practice.listtypeapp.databinding.ActivityMainBinding;
import com.practice.listtypeapp.util.SingleLiveEvent;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

//멤버 인젝션을 하도록 DaggerAppCompatActivity를 상속
public class MainActivity extends DaggerAppCompatActivity {

    // 바인딩 클래스 주입
    @Inject
    Lazy<ActivityMainBinding> binding;
    @Inject
    @Named("errorEvent")
    SingleLiveEvent<Throwable> errorEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 이 액티비티를 lifecycleOwner로 설정하여,
        // 생명 주기에 안전하게 데이터바인딩을 할 수 있도록 한다.
        binding.get().setLifecycleOwner(this);

        errorEvent.observe(this, this::showErrorToast);
    }

    private void showErrorToast(Throwable throwable) {
        throwable.printStackTrace();
        showToast(throwable.getMessage());
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
// 액티비티 생성이 끝기 전에 setContentView()가 호출 되면 안되기 때