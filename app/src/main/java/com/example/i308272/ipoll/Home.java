package com.example.i308272.ipoll;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.i308272.ipoll.createPoll.CreatePoll;
import com.example.i308272.ipoll.displayQuestion.DisplayQuestion;
import com.example.i308272.ipoll.model.DisplayList;
import com.example.i308272.ipoll.navigation.AboutUsFragment;
import com.example.i308272.ipoll.navigation.ContactUsFragment;
import com.example.i308272.ipoll.navigation.PriceFragment;
import com.example.i308272.ipoll.navigation.PrivacyFragment;
import com.example.i308272.ipoll.navigation.ShareFragment;
import com.example.i308272.ipoll.navigation.TermsFragment;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    PriceFragment.OnFragmentInteractionListener,
                    ContactUsFragment.OnFragmentInteractionListener,
                    ShareFragment.OnFragmentInteractionListener,
                    PollFragment.OnListFragmentInteractionListener
                    {


    //PollFragment poolList;

    private final String TAG = this.getClass().getName();
    public static final String EXTRA_ID = "com.example.i308272.ipoll.model.ID";

    //OnCreate method is called when activity is created
    // Notice that this method is also called when the
    // activity have to be recreated for example orientation
    // Change

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"OnCreate Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Fetch the data from internet as we will need that soon.




        // This check is very important. We the configutation of the app changes
        // ( orientation, resolution or language) the activity is recreated
        // ( system calls onDestroy() follow by onCreate()). If the activity is
        // recreated we should not crate a new Fragment object.
        // Note that when activity is being recreated it's associated fragments
        // would also had been recreated. So recreating fragment and attaching
        // them to activity would
        if (savedInstanceState == null) {
            // Create Fragment only when activity is created first time
            PollFragment _frgPollList = new PollFragment();
            FragmentManager fm = getSupportFragmentManager();
            //fm.popBackStack();
            fm.beginTransaction().replace(
                    R.id.content_fragment,
                    _frgPollList,
                    _frgPollList.getTag()
            ).commit();
        }
    }

    // All these following lifeCycle Method has been implemented for
    // bebugging purpose only

    // Start LifeCycle Method
    // As soon as the
    @Override
    protected void onStart() {
            Log.d(TAG,"OnStartClassed");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"OnResume");
        super.onResume();
    }
    // The Activity is also paused in case of the orientation or configuration changes
    // As soon as the focus moves out of the Activity
    // For example Once we click the button to see the minimized
    // Apps the OnPause method is called.
    // You should save all data which you thing might be necessary is use will
    // come back.
    @Override
    protected void onPause() {
        Log.d(TAG,"OnPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG,"OnRestart");
        super.onRestart();
    }

    // Once the orientation changes this method is also called after the onPause Method
    @Override
    protected void onStop() {
        Log.d(TAG,"OnStop");
        super.onStop();
    }

    // Activity hits destroy in case of the orientation change
    // This can be last call in the activity life cycle you should relase all the resouces
    // You have acquired.
    @Override
    protected void onDestroy() {
        Log.d(TAG,"OnDestroy");
        super.onDestroy();
    }
    // End LifeCycle Purpose.

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Click", Toast.LENGTH_LONG).show();

            // Start the Create poll activity
            Intent createPollActivity = new Intent(this,CreatePoll.class);
            startActivity(createPollActivity);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_poll) {
            // Handle the camera action
        } else if (id == R.id.nav_following) {

        } else if (id == R.id.nav_price) {
            // Plan and Pricing
            Fragment _frgPrice = new PriceFragment();
            FragmentManager fm = getSupportFragmentManager();
            getSupportFragmentManager().popBackStack();
            fm.beginTransaction().add(
                    R.id.content_fragment,
                    _frgPrice,
                    _frgPrice.getTag()
            ).addToBackStack(null).commit();

        } else if (id == R.id.nav_privacy) {
            // Privicy
            Fragment _frgPrivacy = new PrivacyFragment();
            FragmentManager fm = getSupportFragmentManager();
            getSupportFragmentManager().popBackStack();
            fm.beginTransaction().add(
                    R.id.content_fragment,
                    _frgPrivacy,
                    _frgPrivacy.getTag()
            ).addToBackStack(null).commit();
        } else if (id == R.id.nav_terms) {
            // Terms and Conditions
            Fragment _frgTerms = new TermsFragment();
            FragmentManager fm = getSupportFragmentManager();
            getSupportFragmentManager().popBackStack();
            fm.beginTransaction().add(
                    R.id.content_fragment,
                    _frgTerms,
                    _frgTerms.getTag()
            ).addToBackStack(null).commit();
        } else if (id == R.id.nav_share) {
            // Share
            Fragment _frgShare = new ShareFragment();
            FragmentManager fm = getSupportFragmentManager();
            getSupportFragmentManager().popBackStack();
            fm.beginTransaction().add(
                    R.id.content_fragment,
                    _frgShare,
                    _frgShare.getTag()
            ).addToBackStack(null).commit();
        } else if (id == R.id.nav_contact) {
            // Contact Us
            Fragment _frgContactUs = new ContactUsFragment();
            FragmentManager fm = getSupportFragmentManager();
            getSupportFragmentManager().popBackStack();
            fm.beginTransaction().add(
                    R.id.content_fragment,
                    _frgContactUs,
                    _frgContactUs.getTag()
            ).addToBackStack(null).commit();
        } else if (id == R.id.nav_about_us){
            // About Us
            Fragment _frgAboutUs = new AboutUsFragment();
            FragmentManager fm = getSupportFragmentManager();
            getSupportFragmentManager().popBackStack();
            fm.beginTransaction().add(
                    R.id.content_fragment,
                    _frgAboutUs,
                    _frgAboutUs.getTag()
            ).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onFragmentInteraction() {
    }

    public void onFragmentInteraction(Uri uri) {
    }

    public void onListFragmentInteraction(DisplayList.DisplayListItem item) {
        Toast.makeText(this,"ItemSelected",Toast.LENGTH_LONG);
        // get the question Id and make a call to display the poll.
        Intent intent = new Intent(this, DisplayQuestion.class);
        intent.putExtra(EXTRA_ID, item.getId());
        startActivity(intent);
    }
}
