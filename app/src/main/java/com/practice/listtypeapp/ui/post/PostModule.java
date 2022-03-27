package com.practice.listtypeapp.ui.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.listtypeapp.databinding.FragmentPostBinding;
import com.practice.listtypeapp.di.ApplicationContext;
import com.practice.listtypeapp.di.FragmentScope;
import com.practice.listtypeapp.ui.PostFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {

    //데이터 바인딩 클래스 제공
    @Provides
    @FragmentScope
    FragmentPostBinding provideBinding(@ApplicationContext Context context){
        return FragmentPostBinding.inflate(LayoutInflater.from(context), null, false);
    }

    //RecyclerView용 레이아웃 메지저
    @Provides
    @FragmentScope
    LinearLayoutManager provideLindearlayouManager(@ApplicationContext Context context){
        return new LinearLayoutManager(context){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams(){
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }

    // Navigation 컴포넌트에서 목적지 간 이동을 담당하는 NavController
    @Provides
    @FragmentScope
    NavController provideNavController(PostFragment fragment){
        return NavHostFragment.findNavController(fragment);
    }
}
