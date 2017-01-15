package com.example.i308272.ipoll.network;

import com.example.i308272.ipoll.model.DisplayList.DisplayListItem;
import com.example.i308272.ipoll.model.QuestionDetails;
import com.example.i308272.ipoll.network.model.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by I308272 on 1/10/2017.
 * ConnectionAPI can be used to connect to the
 * to fetch the data from internet from the remote
 * database
 */

public interface ConnectionAPI {

    /**
     This interface is used to generate the list in for
     three UI
     1. Trending List - List of trending Items
     2. Home Pages List  - List of items recommended for you
     3. Following List  - List of the items voted by the user
     **/

    @GET("questions/")
    Call<List<ListItem>> getDisplayList();

   /* @GET()
    Call<List<QuestionDetails>> getQuestionDetails();*/

}
