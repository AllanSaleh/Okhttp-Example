package com.example.okhttpexample;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String userId;
    private String id;
    private String title;
    @SerializedName("body")
    private String text;

    public Post(String userId, String id, String title, String text) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
