package com.example.i308272.ipoll.createPoll;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.adapter.CreateOptionDataAdapter;
import com.example.i308272.ipoll.adapter.ParticipantDetailsDataAdapter;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm3Data;
import com.example.i308272.ipoll.createPoll.model.ParticipantDetailListItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrtPollFragmentForm3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrtPollFragmentForm3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrtPollFragmentForm3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<ParticipantDetailListItem> participantDetailList;


    View fmtForm3;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ParticipantDetailsDataAdapter mDataAdapter;



    private OnFragmentInteractionListener mListener;




    public CrtPollFragmentForm3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrtPollFragmentForm3.
     */
    // TODO: Rename and change types and number of parameters
    public static CrtPollFragmentForm3 newInstance(String param1, String param2) {
        CrtPollFragmentForm3 fragment = new CrtPollFragmentForm3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        participantDetailList = new ArrayList<ParticipantDetailListItem>();
        AddDetailsOptions();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fmtForm3 = inflater.inflate(R.layout.fragment_crt_poll_fragment_form3, container, false);

        Button nextButton = (Button) fmtForm3.findViewById(R.id.fmtCrtPollForm3_btNext);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onNextButtonPressed(v);
            }
        });

        mRecyclerView = (RecyclerView) fmtForm3.findViewById(R.id.fmtCrtPollForm3_recycler_options);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataAdapter = new ParticipantDetailsDataAdapter(participantDetailList);
        mRecyclerView.setAdapter(mDataAdapter);

        return fmtForm3;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onNextButtonPressed(View v) {
        ParticipantDetailsDataAdapter.ViewHolder partViewHolder;
        CrtPollForm3Data form3Data = new CrtPollForm3Data();
        if (mListener != null) {
            for (int i = 0 ; i < mRecyclerView.getAdapter().getItemCount();i++)
            {
                RecyclerView.ViewHolder viewHolder = mRecyclerView.findViewHolderForAdapterPosition(i);
                if (viewHolder != null && viewHolder instanceof ParticipantDetailsDataAdapter.ViewHolder){
                    partViewHolder = (ParticipantDetailsDataAdapter.ViewHolder) viewHolder;

                }
            }
            mListener.onFragmentInteractionForm3(form3Data);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteractionForm3(CrtPollForm3Data crtPollForm3Data);
    }




    void AddDetailsOptions(){
        participantDetailList.add(new ParticipantDetailListItem(false,"Name"));
        participantDetailList.add(new ParticipantDetailListItem(false,"Age"));
        participantDetailList.add(new ParticipantDetailListItem(false,"Gender"));
        participantDetailList.add(new ParticipantDetailListItem(false,"Location"));
    }
}
