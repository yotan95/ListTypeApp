package com.practice.listtypeapp.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.listtypeapp.databinding.FragmentPostDetailBinding;
import com.practice.listtypeapp.di.ApplicationContext;
import com.practice.listtypeapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class PostDetailModule {

    @Provides
    @FragmentScope
    public FragmentPostDetailBinding provideBinding(@ApplicationContext Context context) {
        return FragmentPostDetailBinding.inflate(LayoutInflater.from(context), null, false);
    }

    @Provides
    @FragmentScope
    public LinearLayoutManager provideLayoutManager(@ApplicationContext Context context) {
        return new LinearLayoutManager(context) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
            }
        };
    }

    @Provides
    @FragmentScope
    public NavController provideNavController(PostDetailFragment fragment) {
        return NavHostFragment.findNavController(fragment);
    }

}