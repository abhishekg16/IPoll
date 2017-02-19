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
import android.widget.TextView;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.adapter.CreateOptionDataAdapter;
import com.example.i308272.ipoll.adapter.DisplayOptionsDataAdapter;
import com.google.android.gms.vision.text.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrtPollFragmentForm4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrtPollFragmentForm4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrtPollFragmentForm4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private  View fmtForm4;

    private ArrayList<String> mOptionList;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private DisplayOptionsDataAdapter mAdapter;



    public CrtPollFragmentForm4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrtPollFragmentForm4.
     */
    // TODO: Rename and change types and number of parameters
    public static CrtPollFragmentForm4 newInstance(String param1, String param2) {
        CrtPollFragmentForm4 fragment = new CrtPollFragmentForm4();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fmtForm4 =  inflater.inflate(R.layout.fragment_crt_poll_fragment_form4, container, false);

        TextView question = (TextView) fmtForm4.findViewById(R.id.fmtCrtPollForm4_tvQuestion);
        TextView description = (TextView) fmtForm4.findViewById(R.id.fmtCrtPollForm4_tvDescription);

        CreatePoll parentActivity =  (CreatePoll) getActivity();

        String tQuestion = parentActivity.getQuestion();
        String tDescription = parentActivity.getDescription();
        if (!tQuestion.isEmpty())
            question.setText(tQuestion);
        if (!tDescription.isEmpty())
            description.setText(tDescription);

        mOptionList = parentActivity.getOptions();

        mRecyclerView = (RecyclerView) fmtForm4.findViewById(R.id.fmtCrtPollForm4_recycler_options);

        // Create the Layout Manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DisplayOptionsDataAdapter(mOptionList);
        mRecyclerView.setAdapter(mAdapter);

        return fmtForm4;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteractionForm4(uri);
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
        void onFragmentInteractionForm4(Uri uri);
    }
}
