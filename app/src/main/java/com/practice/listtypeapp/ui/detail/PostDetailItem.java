package com.practice.listtypeapp.ui.detail;

public abstract class PostDetailItem {

    public abstract Type getType();

    public enum Type {
        USER,
        POST,
        COMMENT
    }
}
