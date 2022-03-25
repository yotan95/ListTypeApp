package com.practice.listtypeapp.data;

import com.practice.listtypeapp.data.entity.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface PostService {
    @GET("/posts")
    Single<List<Post>> getPosts();
}
