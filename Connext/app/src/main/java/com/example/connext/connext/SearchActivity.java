package com.example.connext.connext;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by raahulbiswas on 15-03-18.
 */
public class SearchActivity extends ActionBarActivity {


    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) { setSupportActionBar(toolbar); }

        getSupportActionBar().setElevation(10);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_white_36dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initFragment(new SearchFragment());
    }

    protected void initFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }

    //sets the title of the toolbar(ActionBar)
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void setToolbarColor(String toolbarCol){
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#" + toolbarCol));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

    }

    @TargetApi(21)
    public void setStatus(String toolbarCol){
        getWindow().setStatusBarColor(Color.parseColor("#"+toolbarCol));
    }

    public void setToolbarTransparent(){
        ColorDrawable colorDrawable = new ColorDrawable(Color.alpha(0));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        setStatusDefault();
    }

    public void setToolbarShadow(){
        getSupportActionBar().setElevation(10);
    }

    @TargetApi(21)
    public void setStatusDefault(){
        getWindow().setStatusBarColor(Color.BLACK);
    }


}
