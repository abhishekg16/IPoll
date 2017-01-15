package com.example.i308272.ipoll.network;

import android.util.Log;

import com.example.i308272.ipoll.model.DisplayList;
import com.example.i308272.ipoll.model.QuestionDetails;
import com.example.i308272.ipoll.network.model.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by I308272 on 1/10/2017.
 */

public class RetrofitClient implements ConnectionAPI {

    public static final String BASEURL = "https://insight.apispark.net:443/v1/";
    public final String TAG = this.getClass().getName();
    private Callback requester;

    public RetrofitClient(Callback requester)
    {
        this.requester = requester;
    }

    @Override
    public Call<List<ListItem>> getDisplayList() {


        Retrofit _retrofit = new Retrofit.Builder().
                baseUrl(BASEURL).
                addConverterFactory(GsonConverterFactory.create())
                .build();

        ConnectionAPI  service = _retrofit.create(ConnectionAPI.class);
        Call<List<ListItem>> call = service.getDisplayList();


        call.enqueue(requester);

        return null;
    }

    /*@Override
    public Call<List<QuestionDetails>> getQuestionDetails() {
        return null;
    }*/
}
