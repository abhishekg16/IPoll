package com.example.i308272.ipoll.network;
import com.example.i308272.ipoll.network.model.RemoteQuestion;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by I308272 on 1/10/2017.
 * InsightWebServiceApi can be used to connect to the
 * to fetch the data from internet from the remote
 * database
 */

public interface InsightWebServiceApi {

    /**
     This interface is used to generate the list in for
     three UI
     1. Trending List - List of trending Items
     2. Home Pages List  - List of items recommended for you
     3. Following List  - List of the items voted by the user
     **/

    @GET("questions/")
    Call<List<RemoteQuestion>> getQuestionList();

    /*
    This method return the detail of one particular question
    This method should be used when we are using searching
    question from INumber
     */
    @GET("questions/")
    Call<List<RemoteQuestion>> getQuestionLargeDetail(@Query("id") String id);


    /*
    This method provide the detail of a particular question
    which was not present in the items which are provided
    in get questionList
     */
    @GET("questions/")
    Call<List<RemoteQuestion>> getQuestionOptionDetails(@Query("id") String id);

}
