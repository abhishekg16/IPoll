package com.example.i308272.ipoll.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by I308272 on 1/15/2017.
 */

public class ListItem {
    public ListItem(String id,
                    long question_id,
                    String question_text,
                    int views,
                    int like,
                    String status) {
        this.id = id;
        this.question_id = question_id;
        this.question_text = question_text;
        this.views = views;
        this.like = like;
        this.status = status;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("question_id")
    @Expose
    private long question_id;

    @SerializedName("question_text")
    @Expose
    private String question_text;

    @SerializedName("view")
    @Expose
    private int views;

    @SerializedName("like")
    @Expose
    private int like;

    @SerializedName("status")
    @Expose
    private String status;
}
