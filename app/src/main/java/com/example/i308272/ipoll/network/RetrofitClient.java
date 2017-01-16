package com.example.i308272.ipoll.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{

    public static Retrofit _retrofit = null;

    public static Retrofit getRetrofitClient(String baseUrl){
        if (_retrofit == null) {
             _retrofit = new Retrofit.Builder().
                    baseUrl(baseUrl).
                    addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return _retrofit;
    }
}
