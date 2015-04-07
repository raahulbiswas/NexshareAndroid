package com.example.connext.connext;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by raahulbiswas on 15-03-04.
 */
public class InboxFragment extends Fragment {

    public static InboxFragment newInstance() {
        InboxFragment fragment = new InboxFragment();
        return fragment;
    }
    public InboxFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Join Event");
        ((MainActivity) getActivity()).setToolbarColor("c0392b"); //red
        View v = inflater.inflate(R.layout.fragment_createevent, container, false);
        return v;
    }

}
