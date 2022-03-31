package com.practice.listtypeapp.ui.detail;

import com.practice.listtypeapp.data.entity.Post;

public class PostDetailPostItem extends PostDetailItem {
    private Post post;

    public PostDetailPostItem(Post post) {
        this.post = post;
    }

    @Override
    public Type getType() {
        return Type.POST;
    }

    public String getTitle(){
        return post.getTitle();
    }

    public String getBody(){
        return post.getBody();
    }
}
