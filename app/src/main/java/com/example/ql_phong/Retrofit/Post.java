package com.example.ql_phong.Retrofit;

public class Post {
    String userId;
    int id;
    String title;
    String body;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return body;
    }

    public void setText(String text) {
        this.body = text;
    }
}
