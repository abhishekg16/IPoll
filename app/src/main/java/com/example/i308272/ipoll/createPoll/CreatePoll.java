package com.example.i308272.ipoll.createPoll;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm1Data;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm2Data;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm3Data;
import com.example.i308272.ipoll.createPoll.model.CrtPollForm4Data;

import java.util.ArrayList;


/*
Create Poll : This activity provides functionality to crate a poll. At present a poll simply
means a question. ( We will later support survey - which will consist of multiple question).
It contains five step and each step is represented by a different form.
1. Step 1 - Form1 - Collect the question and description
3. Step 2 - Form2 - Collect the information of the options of the poll.
2. Step 3 - Form3 - Collect other information related to poll - like participant details, privacy.
4. Step 4 - Form4 - Show the preview of the poll.
5. Step 5 - Form5 - Show the poll code and the pass code.

NOTE : After coding this Activity I think it would had been a better decision
 crate whole poll in single activity without any of the fragment as I had do to
 to much of coding to just take care of the activity and fragment interaction.
*/

public class CreatePoll extends AppCompatActivity
                        implements  CrtPollFragmentForm1.OnFragmentInteractionListener,
                                    CrtPollFragmentForm2.OnFragmentInteractionListener,
                                    CrtPollFragmentForm3.OnFragmentInteractionListener,
                                    CrtPollFragmentForm4.OnFragmentInteractionListener,
                                    CrtPollFragmentForm5.OnFragmentInteractionListener

    {


    // These objects store the data stored in the different forms
    CrtPollForm1Data form1Data = null;
    CrtPollForm2Data form2Data = null;
    CrtPollForm3Data form3Data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_create_poll);

        if (savedInstanceState == null) {

            //If none of the fragments has been created yet.
            // Simply create one of the first form
            CrtPollFragmentForm1 _frgForm1 = new CrtPollFragmentForm1();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(
                    R.id.actCrtPoll_fragment,
                    _frgForm1,
                    _frgForm1.getTag()
            ).addToBackStack(null).commit();
        }
    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 1) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Confirm")
                    .setMessage("Are you sure, you do not want to publish this poll ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    // Call back from form 1 --> load form 2
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
        FragmentManager fm = getSupportFragmentManager();
        CrtPollFragmentForm5 _fmtForm5 = new CrtPollFragmentForm5();
        fm.beginTransaction().add(R.id.actCrtPoll_fragment,
                _fmtForm5,
                _fmtForm5.getTag()).addToBackStack(null).commit();
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
