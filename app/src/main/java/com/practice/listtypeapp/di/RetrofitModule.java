package com.practice.listtypeapp.di;

import com.practice.listtypeapp.data.CommentService;
import com.practice.listtypeapp.data.PostService;
import com.practice.listtypeapp.data.UserService;

import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

public class RetrofitModule {
    @Provides
    @Reusable
    PostService providePostService(Retrofit retrofit){
        return retrofit.create(PostService.class);
    }

    @Provides
    @Reusable
    UserService provideUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }

    @Provides
    @Reusable
    CommentService provideCommentService(Retrofit retrofit){
        return retrofit.create(CommentService.class);
    }
}
