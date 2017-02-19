package com.example.i308272.ipoll.createPoll;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.adapter.CreateOptionDataAdapter;
import com.example.i308272.ipoll.constants.ProjectConstants;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm2Data;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrtPollFragmentForm2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CrtPollFragmentForm2 extends Fragment implements CreateOptionDataAdapter.OnItemRemovedListener{

    private final String TAG = this.getClass().getName();

    public static final String NUMBER_OF_OPTIONS = "number_of_options";
    public static final String OPTION_TEXT_KEY_PREFIX ="CRT_FORM2_OPTION_TEXT_";

    private ArrayList<String> mOptionTextList;



    private View fmtForm2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private CreateOptionDataAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public CrtPollFragmentForm2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                onAddOptionsClicked(view);
            }
        });

        Button nextButton = (Button) fmtForm2.findViewById(R.id.fmtCrtPollForm2_bt_next);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onNextButtonPressed(v);
            }
        });

        // Recycler View
        mRecyclerView = (RecyclerView)fmtForm2.findViewById(R.id.fmtCrtPollForm2_recycler_options);

        // set LayoutManager
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mOptionTextList = new ArrayList<String>();

        // set Adapter
        mAdapter = new CreateOptionDataAdapter(mOptionTextList,this);
        mRecyclerView.setAdapter(mAdapter);


        // If fragment is restarted
        if ( savedInstanceState != null) {
            // In case this fragment is restarted we should check the
            // number of options
            int numOptions = savedInstanceState.getInt(NUMBER_OF_OPTIONS);
            if (numOptions < 2) {
                throw new RuntimeException("Exception: " + TAG +
                                                " number of option cannot be less that 2");
            }
            for (int i = 1 ; i <= numOptions; i++ ) {
                mOptionTextList.add(savedInstanceState.getString(OPTION_TEXT_KEY_PREFIX + i));
            }
        }
        else {
            for(int i = 0 ; i < ProjectConstants.NUM_OF_DEFAULT_OPTIONS ;i++)
            {
              mOptionTextList.add("");
            }
        }

        mAdapter.notifyDataSetChanged();
        return fmtForm2;
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


    /*
     */
    private String getOptionText(int optionIndex ){
        return  OPTION_TEXT_KEY_PREFIX + optionIndex;
    }

    // Some important point while we are saving instance state
    // 1. By defaut the Android save the state of state of View which are
    //      present in the code. For example the values present in the EditText
    //      or scroll position in the ListView
    // 2. In order for Android System to restore your view states each view must have
    //      a unique id , supplied by android:id attribute

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // No need to save the data present in the checbox
        // that would be persistant because of the  behavior
        // of the system
        super.onSaveInstanceState(outState);
        saveOptionText();
        outState.putInt(NUMBER_OF_OPTIONS,mOptionTextList.size());
        for (int i = 1 ; i <= mOptionTextList.size() ; i++){
            outState.putString( getOptionText(i), mOptionTextList.get(i));
        }
    }


    public void onNextButtonPressed(View v) {
        if (mListener != null) {
            saveOptionText();
            // Check boxes
            boolean isMultiChoice = ((CheckBox) fmtForm2.findViewById(R.id.fmtCrtPOllForm2_cbMultiChoice)).isChecked();
            boolean isAllowComments = ((CheckBox) fmtForm2.findViewById(R.id.fmtCrtPollForm2_cb_allow_comments)).isChecked();

            CrtPollForm2Data formData = new CrtPollForm2Data(mOptionTextList,
                    isAllowComments,
                    isMultiChoice);

            mListener.onFragmentInteractionForm2(formData);
        } else {
            throw new NullPointerException("Exception: " +TAG +" mListener is null");
        }
    }

    public void onAddOptionsClicked(View v){
            saveOptionText();
            mOptionTextList.add("");
            //mAdapter.incrementDataSet();
            mAdapter.notifyDataSetChanged();
    }


    public void saveOptionText() {
        CreateOptionDataAdapter.ViewHolder optionViewHolder;
        for (int i = 0 ; i < mRecyclerView.getAdapter().getItemCount();i++)
        {
              RecyclerView.ViewHolder viewHolder = mRecyclerView.findViewHolderForAdapterPosition(i);
              if (viewHolder != null && viewHolder instanceof CreateOptionDataAdapter.ViewHolder){
                  optionViewHolder = (CreateOptionDataAdapter.ViewHolder) viewHolder;
                  mAdapter.updateOptionText(optionViewHolder.etOptionText.getText().toString(),
                          i);
              }
        }
    }

    @Override
    public void onItemRemoved() {
        saveOptionText();
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
        void onFragmentInteractionForm2(CrtPollForm2Data formData);
    }


}
