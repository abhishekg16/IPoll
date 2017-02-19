package com.example.i308272.ipoll.createPoll.model;

import java.util.ArrayList;

/**
 * Created by I308272 on 12/26/2016.
 */

public class CrtPollForm1Data {
    String question;
    String description;
    ArrayList<String> categories;

    public CrtPollForm1Data() {
        categories = new ArrayList<String>();
    }

    public CrtPollForm1Data(String question,
                            String description,
                            ArrayList<String> categories) {
        this.question = question;
        this.description = description;
        this.categories = new ArrayList<String>();
        if (categories.size() > 0){
            this.categories.addAll(categories);
        }
    }

    public CrtPollForm1Data(CrtPollForm1Data formData)
    {
        this.question = formData.question;
        this.description  = formData.description;
        this.categories = new ArrayList<String>();
        if (formData.categories.size() != 0) {
            categories.addAll(formData.categories);
        }
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

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }
}
