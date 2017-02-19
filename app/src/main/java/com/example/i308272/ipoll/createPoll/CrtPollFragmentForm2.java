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
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.adapter.CreateOptionDataAdapter;
import com.example.i308272.ipoll.adapter.MyItemRecyclerViewAdapter;
import com.example.i308272.ipoll.constants.ProjectConstants;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm2Data;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrtPollFragmentForm2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrtPollFragmentForm2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrtPollFragmentForm2 extends Fragment implements CreateOptionDataAdapter.OnItemRemovedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private final String TAG = this.getClass().getName();
    private final String NUMBER_OF_OPTIONS = "number_of_options";

    private ArrayList<String> optionTextList;

    /* numOptions denotes number of options present in current transaction  */
    private int numOptions;

    private View fmtForm2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private CreateOptionDataAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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

        optionTextList = new ArrayList<String>();

        // set Adapter
        mAdapter = new CreateOptionDataAdapter(optionTextList,this);
        mRecyclerView.setAdapter(mAdapter);


        // If fragment is restarted
        if ( savedInstanceState != null) {
            // check the number of options
            numOptions = savedInstanceState.getInt(NUMBER_OF_OPTIONS);
        }
        else {
            for(int i = 0 ; i < ProjectConstants.NUM_OF_DEFAULT_OPTIONS ;i++)
            {
              optionTextList.add("");
            }
            mAdapter.notifyDataSetChanged();
        }

        return fmtForm2;
    }

    /*
     */
    private String getOptionText(int optionIndex ){
        return "OPTION_TEXT_" + optionIndex;
    }

    // Some important point while we are saving instance state
    // 1. By defaut the Android save the state of state of View which are
    //      present in the code. For example the values present in the EditText
    //      or scroll position in the ListView
    // 2. In order for Android System to restore your view states each view must have
    //      a unique id , supplied by android:id attribute

    @Override
    public void onSaveInstanceState(Bundle outState) {
        String etContent = "";

        outState.putInt(NUMBER_OF_OPTIONS,numOptions);

        // Store All the options
        // By default we have two EditText for the option to for
        // those default EditText View Android will store the value
        // of those two EditText View. But for simplicity option
        // we are storing values present in all the EditText Views

        for (int i = 1 ; i <= numOptions ; i++){
            //etContent = optionList.get(i).getText().toString();
            //outState.putString( getOptionText(i), etContent );
        }

        super.onSaveInstanceState(outState);

    }


    public void onNextButtonPressed(View v) {
        if (mListener != null) {
            saveOptionText();
            // Check boxes
            boolean isMultiChoice = ((CheckBox) fmtForm2.findViewById(R.id.fmtCrtPOllForm2_cbMultiChoice)).isChecked();
            boolean isAllowComments = ((CheckBox) fmtForm2.findViewById(R.id.fmtCrtPollForm2_cb_allow_comments)).isChecked();

            CrtPollForm2Data formData = new CrtPollForm2Data(optionTextList,
                    isAllowComments,
                    isMultiChoice);

            mListener.onFragmentInteractionForm2(formData);
        }
        else
        {

        }
    }
    
    /*
    This method removes and option and return true if option is removed successfully
     */

    boolean removeAnOption(View view,int optionIndex){
        // Check if option index is valid
        if (optionIndex > numOptions) {
            Log.d(TAG,"removeAnOption : Invalid option index");
            return false;
        }
        return true;
    }


    public void onAddOptionsClicked(View v){
            // increment local counter
            //numOptions++;
            saveOptionText();
            optionTextList.add("");
            //mAdapter.incrementDataSet();
            mAdapter.notifyDataSetChanged();
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
        // TODO: Update argument type and name
        void onFragmentInteractionForm2(CrtPollForm2Data formData);
    }


}
