package com.example.i308272.ipoll.createPoll.model;

/**
 * Created by I308272 on 2/16/2017.
 */

public class ParticipantDetailListItem {
    String detailText;
    boolean isRequired;

    public ParticipantDetailListItem(boolean isRequired, String detailText) {
        this.isRequired = isRequired;
        this.detailText = detailText;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }
}
