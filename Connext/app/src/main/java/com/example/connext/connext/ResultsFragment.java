package com.example.connext.connext;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.connext.connext.R.layout.fragment_search;
import static com.example.connext.connext.R.layout.user_layout;

/**
 * Created by raahulbiswas on 15-03-19.
 */
public class ResultsFragment extends Fragment {
    public static ResultsFragment newInstance() {
        ResultsFragment fragment = new ResultsFragment();
        return fragment;
    }

    public ResultsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        ((SearchActivity) getActivity()).setActionBarTitle("Matched Attendees");
        ((SearchActivity) getActivity()).setToolbarColor("5a808e");
        ((SearchActivity) getActivity()).setStatus("455A64");
        ((SearchActivity) getActivity()).setToolbarShadow();
        View v2 = inflater.inflate(user_layout, container, false);



        return v2;

    }
}
