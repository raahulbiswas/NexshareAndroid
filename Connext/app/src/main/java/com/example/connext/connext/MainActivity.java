package com.example.connext.connext;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import com.firebase.client.Firebase;
import android.widget.RelativeLayout;

import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity
{
    public final String CURRENT_TAG = "CurrentEventTag";
    public final String JOIN_TAG = "JoinEventTag";
    public final String LOGOUT_TAG = "LogoutTag";
    public final String HOME_TAG = "HomeTag";

    private String linkedinURL;
    private String full_name;
    private String occupation;
    private String profilePic;
    private Boolean hasEvent = false;
    private String eventName;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawerList;
    private ArrayAdapter<String> navigationDrawerAdapter;
    private String[] leftSliderData = {"Home", "Current Event", "Join Event"};
    private Fragment fragment;
    private StringBuilder currTag = null;


    RelativeLayout drawerView;
    RelativeLayout mainView;
    RelativeLayout toolbarView;

    private Integer[] imageId = {
            R.drawable.person,
            R.drawable.event,
            R.drawable.join,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkedinURL = getIntent().getStringExtra("LinkedInUrl");
        full_name = getIntent().getStringExtra("Full_Name");
        occupation = getIntent().getStringExtra("Job");
        profilePic = getIntent().getStringExtra("ProfilePic");

        nitView();
        initFragment(new ProfileFragment());
        if (toolbar != null) { setSupportActionBar(toolbar); }
        initDrawer();
    }

    private void nitView() {

            leftDrawerList = (ListView) findViewById(R.id.left_drawer);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            //navigationDrawerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, leftSliderData);
            leftDrawerList.setAdapter(new NavArrayAdapter(MainActivity.this, leftSliderData, imageId));

            //leftDrawerList.setAdapter(navigationDrawerAdapter);
            leftDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String tag = null;
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    switch (position) {
                        case 0:
                            tag = HOME_TAG;
                            if (!(fragment instanceof ProfileFragment)) {
                                if (getFragmentManager().findFragmentByTag(HOME_TAG) != null) {
                                    fragment = (ProfileFragment) getFragmentManager().findFragmentByTag(HOME_TAG);
                                    transaction.replace(R.id.container, fragment, tag);
                                    transaction.addToBackStack(null);
                                } else {
                                    fragment = new ProfileFragment();
                                    transaction.replace(R.id.container, fragment, tag);
                                    transaction.addToBackStack(null);
                                }
                            }
                            drawerLayout.closeDrawers();
                            break;
                        case 1:
                            tag = CURRENT_TAG;
                            if (!(fragment instanceof CurrentEventFragment)) {
                                if (getFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
                                    fragment = (CurrentEventFragment) getFragmentManager().findFragmentByTag(CURRENT_TAG);
                                    transaction.replace(R.id.container, fragment, tag);
                                    transaction.addToBackStack(null);
                                } else {
                                    fragment = new CurrentEventFragment();
                                    transaction.replace(R.id.container, fragment, tag);
                                    transaction.addToBackStack(null);
                                }
                            }
                            drawerLayout.closeDrawers();
                            break;
                        case 2:
                            tag = JOIN_TAG;
                            if (!(fragment instanceof JoinEventFragment)) {
                                if (getFragmentManager().findFragmentByTag(JOIN_TAG) != null) {
                                    fragment = (JoinEventFragment) getFragmentManager().findFragmentByTag(JOIN_TAG);
                                    transaction.replace(R.id.container, fragment, tag);
                                    transaction.addToBackStack(null);
                                } else {
                                    fragment = new JoinEventFragment();
                                    transaction.replace(R.id.container, fragment, tag);
                                    transaction.addToBackStack(null);
                                }
                            }
                            drawerLayout.closeDrawers();
                            break;
                        default:

                            break;
                    }

                    currTag = new StringBuilder();
                    currTag.append(fragment.getTag());
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    transaction.commit();
                }
            });
    }


    protected void initFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    private void initDrawer() {
        drawerView = (RelativeLayout) findViewById(R.id.drawerView);
        mainView = (RelativeLayout) findViewById(R.id.container);
        toolbarView = (RelativeLayout) findViewById(R.id.mainActionBar);
        drawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) { super.onDrawerClosed(drawerView); }

            @Override
            public void onDrawerOpened(View drawerView) { super.onDrawerOpened(drawerView); }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainView.setTranslationX(slideOffset * drawerView.getWidth());
                toolbarView.setTranslationX(slideOffset * drawerView.getWidth());
                drawerLayout.bringChildToFront(drawerView);
                drawerLayout.requestLayout();
            }
        };
      drawerLayout.setDrawerListener(drawerToggle);
      //getLinkedIn();
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    //sets the title of the toolbar(ActionBar)
    public void setActionBarTitle(String title) { getSupportActionBar().setTitle(title); }

    //sets the toolbar color
    public void setToolbarColor(String toolbarCol){
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#"+toolbarCol));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
    }

    @TargetApi(21)
    public void setStatus(String toolbarCol){ getWindow().setStatusBarColor(Color.parseColor("#"+toolbarCol)); }

    //Makes toolbar transparent
    public void setToolbarTransparent(){
        ColorDrawable colorDrawable = new ColorDrawable(Color.alpha(0));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        setStatusDefault();
    }

    //Sets a shadow under the toolbar
    public void setToolbarShadow(){ getSupportActionBar().setElevation(10); }

    @TargetApi(21)
    public void setStatusDefault(){ getWindow().setStatusBarColor(Color.BLACK); }

    //enables and disables the drawer toggle
    public void enableDrawer(boolean val){
        drawerToggle.setDrawerIndicatorEnabled(val);
    }

    public String getFull_name(){
        return full_name;
    }
    public String getLinkedinURL(){
        return linkedinURL;
    }
    public String getOccupation(){
        return occupation;
    }
    public String getProfilePic(){
        return profilePic;
    }
    public Boolean getHasEvent() { return  hasEvent; }
    public String getEventName() { return eventName; }
    public void setEvent(String eventN){
        hasEvent = true;
        eventName = eventN;
    }



}
