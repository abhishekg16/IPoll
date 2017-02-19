package com.example.i308272.ipoll.createPoll;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm1Data;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm2Data;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm3Data;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm4Data;

import java.util.ArrayList;

public class CreatePoll extends AppCompatActivity
                        implements  CrtPollFragmentForm1.OnFragmentInteractionListener,
                                    CrtPollFragmentForm2.OnFragmentInteractionListener,
                                    CrtPollFragmentForm3.OnFragmentInteractionListener,
                                    CrtPollFragmentForm4.OnFragmentInteractionListener,
                                    CrtPollFragmentForm5.OnFragmentInteractionListener

    {

    CrtPollForm1Data form1Data;
    CrtPollForm2Data form2Data;
    CrtPollForm3Data form3Data;
    CrtPollForm4Data form4Data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);

        if (savedInstanceState == null) {
            CrtPollFragmentForm1 _frgForm1 = new CrtPollFragmentForm1();
            FragmentManager fm = getSupportFragmentManager();
            //fm.popBackStack();
            fm.beginTransaction().replace(
                    R.id.actCrtPoll_fragment,
                    _frgForm1,
                    _frgForm1.getTag()
            ).commit();
        }
    }

    // Form 1
    public void onFragmentInteractionForm1(CrtPollForm1Data formData){
        // The next button of form 1 has been clicked to we
        // need to collect that data and store it in instant variable
        form1Data =  new CrtPollForm1Data(formData);

        // Move to the next fragment
        CrtPollFragmentForm2 _fmtForm2 = new CrtPollFragmentForm2();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.actCrtPoll_fragment,
                _fmtForm2,
                _fmtForm2.getTag()).addToBackStack(null).commit();

    }

    // Form 2
    public void onFragmentInteractionForm2(CrtPollForm2Data formData){
        form2Data = new CrtPollForm2Data(formData);
       // Move to the next fragment
       CrtPollFragmentForm3 _fmtForm3 = new CrtPollFragmentForm3();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.actCrtPoll_fragment,
                _fmtForm3,
                _fmtForm3.getTag()).addToBackStack(null).commit();
    }

    // Form 3
    public void onFragmentInteractionForm3(CrtPollForm3Data formData){
        form3Data = new CrtPollForm3Data(formData);
        FragmentManager fm = getSupportFragmentManager();
        CrtPollFragmentForm4 _fmtForm4 = new CrtPollFragmentForm4();
        fm.beginTransaction().add(R.id.actCrtPoll_fragment,
                _fmtForm4,
                _fmtForm4.getTag()).addToBackStack(null).commit();
    }

    // Form 4
    public void onFragmentInteractionForm4(Uri uri){

    }

    // Form 5
    public void onFragmentInteractionForm5(Uri uri){

    }

    public String getQuestion(){
        return form1Data.getQuestion();
    }
    public String getDescription(){
        return form1Data.getDescription();
    }

    public ArrayList<String> getOptions(){
        return form2Data.get_options();
    }

}
