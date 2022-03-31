package com.practice.listtypeapp.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.practice.listtypeapp.databinding.FragmentUserBinding;
import com.practice.listtypeapp.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class UserFragment extends DaggerFragment {

    @Inject
    AppViewModelFactory viewModelFactory;

    @Inject
    FragmentUserBinding binding;

    UserViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(UserViewModel.class);
        if(savedInstanceState==null){
            UserFragmentArgs args = UserFragmentArgs.fromBundle(getArguments());
            viewModel.loadUser(args.getUserId());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);
    }
}
