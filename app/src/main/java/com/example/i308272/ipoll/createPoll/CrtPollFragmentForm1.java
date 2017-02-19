package com.example.i308272.ipoll.createPoll;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm1Data;

import java.util.ArrayList;

/**
 * Activities that contain this fragment must implement the
 * {@link CrtPollFragmentForm1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 *
 * Other we are not going to save any data from this fragment in the
 * persistance bundle object because by default android store the data
 * of the edittext on configuration changes
 */
public class CrtPollFragmentForm1 extends Fragment {

    private final String TAG = this.getClass().getName();

    // Data to be saved


    // Private data needed
    private View fmtView;
    private OnFragmentInteractionListener mListener;

    //Constructor
    public CrtPollFragmentForm1() {
        // Required empty public constructor
        // Do not delete this empty constructor because
        // system need it when ever it wants to restart
        // fragment
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        getActivity().setTitle("Create Question");
        return fmtView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /*
        This method is called when user has present next Button after
        filling this form
     */
    public void onNextButtonPressed(View view) {
        String question;
        String description;
        ArrayList<String> categories;

        if (mListener != null) {
            // When the next button pressed pass the data to the parent activity
            EditText etQesView = (EditText)fmtView.findViewById(R.id.fmtCrtPollForm1_etQuestion);
            EditText etDecView = (EditText)fmtView.findViewById(R.id.fmtCrtPollForm1_etDescription);
            EditText etCatView = (EditText)fmtView.findViewById(R.id.fmtCrtPollForm1_etCategories);

            if ( etQesView == null || etCatView == null || etDecView == null) {
                throw new NullPointerException("Exception : "+ TAG +" : view element is null ");
            }

            question = etQesView.getText().toString();
            description = etDecView.getText().toString();

            //  TODO : Develop test case to test how application
            //  description can be empty so above toString method
            // may return NULL. so in order to make the null handling
            // easy internally we would consider the zero length string
            // as the empty description.
            if ( description.isEmpty()) {
                description="";
            }


            String tCategories[] =etCatView.getText().toString().split(",");

            // Local Checks
            // 1. Question can not be empty
            // 2. Question should contain at least 3 words
            // 2. At least enter one category.

            // TODO : In the server we have to put a check that category should
            // be a valid word, it should be checked with dictionary

            boolean checkPassed = true;

            /*Basic checks*/
            //Check if question is not submitted them set change the color of text
            if (question.isEmpty()) {
                etQesView.setHintTextColor(Color.RED);
                checkPassed = false;
            }

            //Check question contains less then three words
            if (question.split(" ").length < 3 && checkPassed) {
                etQesView.setHint(getContext().getResources().getString(R.string.error_msg_question_to_short));
                checkPassed = false;
            }

            // At least you have to mention one category
            if (tCategories.length == 0) {
                etCatView.setHint(  getContext().getResources().getString(R.string.error_msg_question_category_not_found)  );
                checkPassed = false;
            }
            /*End Basic Check*/
            if (!checkPassed)
                return;

            categories = new ArrayList<String>();

            for (int i = 0; i < tCategories.length ; i++ )
                categories.add(tCategories[i]);

            CrtPollForm1Data formData = new CrtPollForm1Data(question,description,categories);
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
        void onFragmentInteractionForm1(CrtPollForm1Data formData);
    }

}
