package com.example.i308272.ipoll.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample question for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class DisplayList {

    /**
     * An array of poll questions
     */
    public static final List<DisplayListItem> ITEMS = new ArrayList<DisplayListItem>();

    /**
     * A map of sample poll , by ID.
     */
    public static final Map<Long, DisplayListItem> ITEM_MAP = new HashMap<Long, DisplayListItem>();

    private static final int COUNT = 30;

    static {
        // As ass starts - fetch for list of items
        for (int i = 1; i <= COUNT; i++) {
            //addItem(createDummyItem(i));

        }
    }

    private static void addItem(DisplayListItem item) {
        //ITEMS.add(item);
        //ITEM_MAP.put(item.id, item);
    }

    private static DisplayListItem createDummyItem(int position) {
        return new DisplayListItem(
                position,
                "What is population of india?",
                "You have to guess the population of India",
                20,
                30,
                200);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of question.
     */
    public static class DisplayListItem {
        public final long id;               /* unique Id a poll have */
        public final String question;       /* question associated with that poll */
        public final String description;    /* A small description related to poll */
        public final int comments;          /* number of comments present for that poll*/
        public final int likes;              /* number of likes for that poll*/
        public final int votes;             /* number of votes for that poll */

        public DisplayListItem(long id,
                               String content,
                               String details,
                               int comments,
                               int like,
                               int votes) {
            this.id = id;
            this.question = content;
            this.description = details;
            this.comments = comments;
            this.likes = like;
            this.votes = votes;
        }

        @Override
        public String toString() {
            return question;
        }
    }
}
