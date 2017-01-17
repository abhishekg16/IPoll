package com.example.i308272.ipoll.model;

import com.example.i308272.ipoll.displayQuestion.DisplayQuestion;

/**
 * DisplayQuestionListItem class contains all information which need to
 * display in the list.
 * You can take all necessary information which you want out of this
 * any use that in the display list
 */
public class DisplayQuestionListItem {
    private String id;            /*this unique id is just kept because restlet
                                         need this later we can remove this*/
    private long iNumber;          /* unique Id a poll have */
    private String question;       /* question associated with that poll */
    private String description;    /* A small description related to poll */
    private String status;
    private int commentCount;          /* number of comments present for that poll*/
    private int likeCount;             /* number of likes for that poll*/
    private int viewCount;             /* number of views for that poll */


    public DisplayQuestionListItem(String id, long iNumber, String question, String description, String status, int commentCount, int likeCount, int viewCount) {
        this.id = id;
        this.iNumber = iNumber;
        this.question = question;
        this.description = description;
        this.status = status;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
    }

    public DisplayQuestionListItem() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
