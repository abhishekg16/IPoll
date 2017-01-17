package com.example.i308272.ipoll.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * This class should be used when we are fetching the whole question detail
 * Like when we are searching based on the iNumber;
 */

public class RemoteQuestion {

    public RemoteQuestion(String id,
                          long iNumber,
                          String question,
                          String description,
                          ArrayList<String> options,
                          String status,
                          int viewCount,
                          int like,
                          int commentCount) {
        this.id = id;
        this.iNumber = iNumber;
        this.question = question;
        this.description = description;
        this.options = options;
        this.status = status;
        this.viewCount = viewCount;
        this.likeCount = like;
        this.commentCount = commentCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getiNumber() {
        return iNumber;
    }

    public void setiNumber(long iNumber) {
        this.iNumber = iNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("i_number")
    @Expose
    private long iNumber;

    @SerializedName("question")
    @Expose
    private String question;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("options")
    @Expose
    private ArrayList<String> options;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("view_count")
    @Expose
    private int viewCount;

    @SerializedName("like_count")
    @Expose
    private int likeCount;

    @SerializedName("comment_count")
    @Expose
    private int commentCount;



}
