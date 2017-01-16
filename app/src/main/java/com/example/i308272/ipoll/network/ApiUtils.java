package com.example.i308272.ipoll.network;

import com.example.i308272.ipoll.network.InsightWebServiceApi;

public class ApiUtils {
    public static final String BASEURL ="https://insight.apispark.net:443/v1/";

    public static InsightWebServiceApi getInsightWebServiceApi(){
        return RetrofitClient.getRetrofitClient(BASEURL).create(InsightWebServiceApi.class);
    }
}
