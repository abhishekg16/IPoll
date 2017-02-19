package com.example.i308272.ipoll;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.i308272.ipoll.adapter.MyItemRecyclerViewAdapter;
import com.example.i308272.ipoll.model.DisplayList;
import com.example.i308272.ipoll.model.DisplayQuestionListItem;
import com.example.i308272.ipoll.network.ApiUtils;
import com.example.i308272.ipoll.network.InsightWebServiceApi;
import com.example.i308272.ipoll.network.model.RemoteQuestion;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PollFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private InsightWebServiceApi networkClient = null;
    MyItemRecyclerViewAdapter mAdapter;
    private EndlessRecyclerViewScrollListener scrollListener;

    public final String TAG = this.getClass().getName();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PollFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PollFragment newInstance(int columnCount) {
        PollFragment fragment = new PollFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (networkClient == null) {
            networkClient = ApiUtils.getInsightWebServiceApi();
        }
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        // TODO : Check if you need to download list each time.
        downloadDisplayList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        LinearLayoutManager linearLayoutManager = null;

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                linearLayoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(linearLayoutManager);
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            mAdapter = new MyItemRecyclerViewAdapter(DisplayList.ITEMS,
                                    mListener);
            recyclerView.setAdapter(mAdapter);

            // Set the scroll listener
            if(linearLayoutManager != null) {
                scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        loadNextDataPage(page);
                    }
                };
            }
            recyclerView.addOnScrollListener(scrollListener);
        }
        return view;
    }

    // Append the next page of data into the adapter
    // This method probably sends out a network request and appends new data items to your adapter.
    public void loadNextDataPage(int page){
        // Send an API request to retrieve appropriate paginated data
        //  --> Send the request including an offset value (i.e `page`) as a query parameter.
        //  --> Deserialize and construct new model objects from the API response
        //  --> Append the new data objects to the existing set of items inside the array of items
        //  --> Notify the adapter of the new items made with `notifyItemRangeInserted()`
    }

    public void notifyDataChange(){
        mAdapter.notifyDataSetChanged();
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DisplayQuestionListItem item);
    }


    public void downloadDisplayList()
    {
        Call<List<RemoteQuestion>> call = networkClient.getQuestionList();
        call.enqueue(new Callback<List<RemoteQuestion>>() {
            @Override
            public void onResponse(Call<List<RemoteQuestion>> call,
                                   Response<List<RemoteQuestion>> response) {

                if(response.isSuccessful()) {

                    List<RemoteQuestion> items = response.body();

                    // You got the data send it to the UI thread to take care.
                    for (int i = 0; i < items.size(); i++) {
                        RemoteQuestion item= items.get(i);
                        Log.d(TAG,item.getQuestion());

                        DisplayQuestionListItem displayQuestionItem =
                                new DisplayQuestionListItem();
                        displayQuestionItem.setId(item.getId());
                        displayQuestionItem.setQuestion(item.getQuestion());
                        displayQuestionItem.setDescription(item.getDescription());
                        displayQuestionItem.setViewCount(item.getViewCount());
                        DisplayList.ITEMS.add(displayQuestionItem);
                        DisplayList.ITEM_MAP.put(item.getiNumber(),displayQuestionItem);
                    }
                    mAdapter.notifyDataSetChanged();
                }
                else {
                    Log.d(TAG,"Error : Response code is " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<RemoteQuestion>> call, Throwable t) {
                Log.d(TAG,"Could not fetch data");
            }
        });
    }
}
