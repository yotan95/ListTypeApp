package com.practice.listtypeapp.data.entity;

// 커멘트 엔터티
public class Comment {
    private long postId;
    private long id;
    private String name;
    private String email;
    private String body;

    public long getPostId() {
        return postId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
