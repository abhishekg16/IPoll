package com.example.i308272.ipoll.displayQuestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.i308272.ipoll.Home;
import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.network.ApiUtils;
import com.example.i308272.ipoll.network.InsightWebServiceApi;
import com.example.i308272.ipoll.network.model.ItemDetails;

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
        Call<List<ItemDetails>> call = networkClient.getQuestionDetails(id);
        call.enqueue(new Callback<List<ItemDetails>>() {
            @Override
            public void onResponse(Call<List<ItemDetails>> call, Response<List<ItemDetails>> response) {
                if (response == null){
                    Log.d(TAG,"Error : response object is null");
                }
                if (response.isSuccessful()){
                    // Update the question detail here.
                    List<ItemDetails> items = response.body();
                    Log.d(TAG,items.get(0).getQuestion_text());
                }
            }

            @Override
            public void onFailure(Call<List<ItemDetails>> call, Throwable t) {
                Log.d(TAG, "Error" + t.getMessage());
                Log.d(TAG, "Error: On failure called");
            }
        });
    }

}
