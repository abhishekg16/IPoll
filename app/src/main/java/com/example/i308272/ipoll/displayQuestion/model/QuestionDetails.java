package com.example.i308272.ipoll.displayQuestion.model;

import com.example.i308272.ipoll.model.DisplayQuestionListItem;

import java.util.ArrayList;

/**
 * Created by I308272 on 1/10/2017.
 * This object contains all details related to the question
 * The details can be used to poputate data in the Display question activity
 */

public class QuestionDetails {

    DisplayQuestionListItem questionSummary;
    ArrayList<String> options;

    public QuestionDetails(DisplayQuestionListItem questionSummary, ArrayList<String> options) {
        this.questionSummary = questionSummary;
    }

    public DisplayQuestionListItem getQuestionSummary() {
        return questionSummary;
    }

    public void setQuestionSummary(DisplayQuestionListItem questionSummary) {
        this.questionSummary = questionSummary;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
