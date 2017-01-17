package com.example.i308272.ipoll.displayQuestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.i308272.ipoll.Home;
import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.network.ApiUtils;
import com.example.i308272.ipoll.network.InsightWebServiceApi;
import com.example.i308272.ipoll.network.model.RemoteQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayQuestion extends AppCompatActivity {

    InsightWebServiceApi networkClient = null;
    private final String TAG = this.getClass().getName();
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_question);

        if (networkClient == null){
            networkClient = ApiUtils.getInsightWebServiceApi();
        }
        Intent intent = getIntent();
        id = intent.getStringExtra(Home.EXTRA_ID);
        downloadQuestion(id);
    }

    public void downloadQuestion( String id ){
        Call<List<RemoteQuestion>> call = networkClient.getQuestionOptionDetails(id);
        call.enqueue(new Callback<List<RemoteQuestion>>() {
            @Override
            public void onResponse(Call<List<RemoteQuestion>> call, Response<List<RemoteQuestion>> response) {
                if (response == null){
                    Log.d(TAG,"Error : response object is null");
                }
                if (response.isSuccessful()){
                    // Update the question detail here.
                    List<RemoteQuestion> items = response.body();
                    Log.d(TAG,items.get(0).getQuestion());
                    for (int i = 0 ; i < items.get(0).getOptions().size();i++) {
                        Log.d(TAG,items.get(0).getOptions().get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<RemoteQuestion>> call, Throwable t) {
                Log.d(TAG, "Error" + t.getMessage());
                Log.d(TAG, "Error: On failure called");
            }
        });
    }

}
