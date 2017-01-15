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
import com.example.i308272.ipoll.model.DisplayList.DisplayListItem;
import com.example.i308272.ipoll.network.RetrofitClient;
import com.example.i308272.ipoll.network.model.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PollFragment extends Fragment
        implements Callback<List<ListItem>> {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private RetrofitClient networkClient;
    MyItemRecyclerViewAdapter mAdapter;

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
            networkClient = new RetrofitClient(this);
        }
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        networkClient.getDisplayList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // Get the list of items - Once you get the update the recycler view

            mAdapter = new MyItemRecyclerViewAdapter(DisplayList.ITEMS,
                                    mListener);
            recyclerView.setAdapter(mAdapter);
        }
        return view;
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
        // TODO: Update argument type and name
        void onListFragmentInteraction(DisplayListItem item);
    }


    // Retrofit call back method
    @Override
    public void onResponse(Call<List<ListItem>> call,
                           Response<List<ListItem>>
                                   response) {

        if(response == null){
            Log.d(TAG,"Network Error : Response Object is null");
        }
        if(response.code() == 200) {
            List<ListItem> items = response.body();
            // You got the data send it to the UI thread to take care.
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getQuestion_text());
                Log.d(TAG,items.get(i).getQuestion_text());

                // Crate the object of diplay list
                DisplayList.DisplayListItem item = new DisplayList.DisplayListItem(
                        items.get(i).getQuestion_id(),
                        items.get(i).getQuestion_text(),
                        "Description",
                        1,
                        1,
                        1
                );
                DisplayList.ITEMS.add(item);
            }
            mAdapter.notifyDataSetChanged();
        }
        else {
            Log.d(TAG,"Error : Response code is " + response.code());
        }
    }

    @Override
    public void onFailure(Call<List<ListItem>> call, Throwable t) {
        Log.d(TAG,"Could not fetch data");
    }
}
