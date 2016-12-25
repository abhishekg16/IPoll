package com.example.i308272.ipoll;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreatePoll extends AppCompatActivity
                        implements CrtPollFragmentForm1.OnFragmentInteractionListener
    {

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

        public void onFragmentInteraction(Uri uri){

        }
}
