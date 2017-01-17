package com.example.i308272.ipoll.createPoll;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm2Data;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrtPollFragmentForm2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrtPollFragmentForm2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrtPollFragmentForm2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View fmtForm2;

    private OnFragmentInteractionListener mListener;

    public CrtPollFragmentForm2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrtPollFragmentForm2.
     */
    // TODO: Rename and change types and number of parameters
    public static CrtPollFragmentForm2 newInstance(String param1, String param2) {
        CrtPollFragmentForm2 fragment = new CrtPollFragmentForm2();
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
        fmtForm2 =  (View)inflater.inflate(R.layout.fragment_crt_poll_fragment_form2, container, false);

        // add listener to add more options button
        Button addMoreOptionButton = (Button) fmtForm2.findViewById(R.id.fmtCrtPollForm2_bt_add_options);
        addMoreOptionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onAddMoreOptionsClicked(view);
            }
        });
        Button nextButton = (Button) fmtForm2.findViewById(R.id.fmtCrtPollForm2_bt_next);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onNextButtonPressed(v);
            }
        });
        return fmtForm2;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onNextButtonPressed(View v) {
        if (mListener != null) {
            // Fetch the Data from view fields and populate them
            CrtPollForm2Data formData = new CrtPollForm2Data();
            // Right not we have fixed to only four options later
            // we need to modify this code to take care of this limitation

            // Pick options
            EditText option1 = (EditText) fmtForm2.findViewById(R.id.fmtCrtPollForm2_et_option1);
            EditText option2 = (EditText) fmtForm2.findViewById(R.id.fmtCrtPollForm2_et_option2);
            EditText option3 = (EditText) fmtForm2.findViewById(R.id.fmtCrtPollForm2_et_option3);
            EditText option4 = (EditText) fmtForm2.findViewById(R.id.fmtCrtPollForm2_et_option4);

            // Check boxes
            boolean isMultiChoice = ((CheckBox) fmtForm2.findViewById(R.id.fmtCrtPOllForm2_cbMultiChoice)).isChecked();
            boolean isAllowComments = ((CheckBox) fmtForm2.findViewById(R.id.fmtCrtPollForm2_cb_allow_comments)).isChecked();

            formData.set_option(option1.toString());
            formData.set_option(option2.toString());
            formData.set_option(option3.toString());
            formData.set_option(option4.toString());

            mListener.onFragmentInteractionForm2(formData);
        }
        else
        {

        }

    }


    public void onAddMoreOptionsClicked(View v){
        // Need to be implemented
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
        void onFragmentInteractionForm2(CrtPollForm2Data formData);
    }
}
