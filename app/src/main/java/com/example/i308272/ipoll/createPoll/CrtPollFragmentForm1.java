package com.example.i308272.ipoll.createPoll;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.model.CrtPollForm1Data;

import java.util.ArrayList;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link CrtPollFragmentForm1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrtPollFragmentForm1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrtPollFragmentForm1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //private PlusOneButton mPlusOneButton;

    // Data to be saved
    private String question;
    private String description;
    private ArrayList<String> categories;

    //
    private View fmtView;

    private OnFragmentInteractionListener mListener;

    public CrtPollFragmentForm1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrtPollFragmentForm1.
     */
    // TODO: Rename and change types and number of parameters
    public static CrtPollFragmentForm1 newInstance(String param1, String param2) {
        CrtPollFragmentForm1 fragment = new CrtPollFragmentForm1();
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
        fmtView = inflater.inflate(R.layout.fragment_crt_poll_fragment_form1, container, false);
        Button bt = (Button) fmtView.findViewById(R.id.fmtCrtPOllForm1_btNext);
        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v){
                                onNextButtonPressed(v);
                            }
        });


        // Set Title According to the current Fragment
        getActivity().setTitle("Question Details");

        // Get the view data and store the in the Private Object.

        return fmtView;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
        //mPlusOneButton.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE);
    }

    public void onNextButtonPressed(View view) {
        if (mListener != null) {
            // When the next button pressed pass the data to the parent activity
            EditText qesView = (EditText)fmtView.findViewById(R.id.fmtCrtPollForm1_etQuestion);
            EditText decView = (EditText)fmtView.findViewById(R.id.fmtCrtPollForm1_etDescription);
            EditText categView = (EditText)fmtView.findViewById(R.id.fmtCrtPollForm1_etCategories);

            question = qesView.getText().toString();
            description = decView.getText().toString();
           // categories.add(categView.getText().toString());

            CrtPollForm1Data formData = new CrtPollForm1Data();
            formData.setQuestion(question);
            formData.setDescription(description);
            formData.setCategories(categories);


            mListener.onFragmentInteractionForm1(formData);
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
        void onFragmentInteractionForm1(CrtPollForm1Data formData);
    }

}
