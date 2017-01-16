package com.example.i308272.ipoll.network.model;

import java.util.ArrayList;

/**
 * Created by I308272 on 1/15/2017.
 */

public class ItemDetails {

    public ItemDetails(ArrayList<String> options,
                       long question_id,
                       String question_text,
                       int views,
                       int like,
                       String status) {
        this.options = options;
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

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
    private long question_id;
    private String question_text;
    private int views;
    private int like;
    private String status;
    private ArrayList<String> options;

}
