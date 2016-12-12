package com.example.i308272.ipoll;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.i308272.ipoll.dummy.DummyContent;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    PriceFragment.OnFragmentInteractionListener,
                    ContactUsFragment.OnFragmentInteractionListener,
                    ShareFragment.OnFragmentInteractionListener,
                    PollFragment.OnListFragmentInteractionListener
                    {


    PollFragment poolList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        PollFragment _frgPollList = new PollFragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(
                R.id.content_home,
                _frgPollList,
                _frgPollList.getTag()
        ).commit();
    }

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
            fm.beginTransaction().replace(
                    R.id.content_home,
                    _frgPrice,
                    _frgPrice.getTag()
            ).commit();

        } else if (id == R.id.nav_privacy) {
            // Privicy
            Fragment _frgPrivacy = new PrivacyFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(
                    R.id.content_home,
                    _frgPrivacy,
                    _frgPrivacy.getTag()).commit();
        } else if (id == R.id.nav_terms) {
            // Terms and Conditions
            Fragment _frgTerms = new TermsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(
                    R.id.content_home,
                    _frgTerms,
                    _frgTerms.getTag()
            ).commit();
        } else if (id == R.id.nav_share) {
            // Share
            Fragment _frgShare = new ShareFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(
                    R.id.content_home,
                    _frgShare,
                    _frgShare.getTag()
            ).commit();
        } else if (id == R.id.nav_contact) {
            // Contact Us
            Fragment _frgContactUs = new ContactUsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(
                    R.id.content_home,
                    _frgContactUs,
                    _frgContactUs.getTag()
            ).commit();
        } else if (id == R.id.nav_about_us){
            // About Us
            Fragment _frgAboutUs = new AboutUsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(
                    R.id.content_home,
                    _frgAboutUs,
                    _frgAboutUs.getTag()
            ).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onFragmentInteraction()
    {
    }

    public void onFragmentInteraction(Uri uri) {

    }

    public void onListFragmentInteraction(DummyContent.DummyItem item)
    {

    }

}
