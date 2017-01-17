package com.example.i308272.ipoll.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains the data source arraylist for recycler view
 * and also provides the class definition for the the each item in the Recycler
 * View
 * <p>
 */
public class DisplayList {

    /**
     * This is the data source array list of our recycler view adpater
     */
    public static final List<DisplayQuestionListItem> ITEMS = new ArrayList<DisplayQuestionListItem>();

    // This map is not used right now
    public static final Map<Long, DisplayQuestionListItem> ITEM_MAP
                            = new HashMap<Long, DisplayQuestionListItem>();

    private static final int COUNT = 30;


    // Following commented section contains the code which would be used to
    // fill the data in the adapter.
    // We can use this when we do not have internet connection
    // and want to fill the data locally
    /*
    static {
        // As ass starts - fetch for list of items
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DisplayQuestionListItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.iNumber, item);
    }

    private static DisplayQuestionListItem createDummyItem(int position) {
        return new DisplayQuestionListItem(
                "1",
                position,
                "What is population of india?",
                "You have to guess the population of India",
                20,
                30,
                200);
    }
    */

}
