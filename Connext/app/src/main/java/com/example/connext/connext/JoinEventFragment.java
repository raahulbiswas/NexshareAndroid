package com.example.connext.connext;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
import com.firebase.client.Firebase;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ChildEventListener;
**/
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

import static com.example.connext.connext.R.layout.fragment_joinevent;

/**
 * Created by raahulbiswas on 15-03-04.
 */
public class JoinEventFragment extends Fragment {

    public boolean eventExist = false;

    public static JoinEventFragment newInstance() {
        JoinEventFragment fragment = new JoinEventFragment();
        return fragment;
    }
    public JoinEventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Join Event");
        ((MainActivity) getActivity()).setToolbarColor("5a808e");
        ((MainActivity) getActivity()).setStatus("455A64");
        ((MainActivity) getActivity()).setToolbarShadow();
        final View v2;
        v2 = inflater.inflate(fragment_joinevent, container, false);
        eventExist = false;
        final EditText edit = (EditText) v2.findViewById(R.id.accessCode);
        final RelativeLayout joinLayout = (RelativeLayout) v2.findViewById(R.id.joinView);
        final RelativeLayout confirmLayout = (RelativeLayout) v2.findViewById(R.id.confirmView);
        final RelativeLayout noeventLayout = (RelativeLayout) v2.findViewById(R.id.noeventView);
        final Button button = (Button) v2.findViewById(R.id.joinEventButton);
        final Button decline = (Button) v2.findViewById(R.id.declineButton);
        final Button confirm = (Button) v2.findViewById(R.id.confirmButton);
        final Button goback = (Button) v2.findViewById(R.id.gobackButton);
        final TextView eventName = (TextView) v2.findViewById(R.id.eventname);
        final TextView eventDate = (TextView) v2.findViewById(R.id.eventdate);
        confirmLayout.setVisibility(View.INVISIBLE);
        noeventLayout.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2) {

                final String name = edit.getText().toString();
                Log.v("The String is", name);
                if (name.equals("Sample")) {
                    confirmLayout.setVisibility(View.VISIBLE);
                    joinLayout.setVisibility(View.INVISIBLE);
                    final String eName = "Sample Event";

                    eventName.setText(eName);

                   eventDate.setText("April 6th 2015");

                    confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            ((MainActivity) getActivity()).setEvent(eName);
                            String user_id = ((MainActivity) getActivity()).getLinkedinURL();
                            confirmLayout.setVisibility(View.INVISIBLE);
                            joinLayout.setVisibility(View.VISIBLE);
                        }
                    });

                    decline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            confirmLayout.setVisibility(View.INVISIBLE);
                            joinLayout.setVisibility(View.VISIBLE);
                        }
                    });

                } else if (name.equals("Other")){
                    confirmLayout.setVisibility(View.VISIBLE);
                    joinLayout.setVisibility(View.INVISIBLE);
                    final String eName = "Other Event";
                 //   TextView eventName = (TextView) v2.findViewById(R.id.eventname);
                    eventName.setText(eName);
                   // TextView eventDate = (TextView) v2.findViewById(R.id.eventdate);
                    eventDate.setText("April 7th 2015");

                    confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            ((MainActivity) getActivity()).setEvent(eName);
                            String user_id = ((MainActivity) getActivity()).getLinkedinURL();
                            confirmLayout.setVisibility(View.INVISIBLE);
                            joinLayout.setVisibility(View.VISIBLE);
                        }
                    });

                    decline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            confirmLayout.setVisibility(View.INVISIBLE);
                            joinLayout.setVisibility(View.VISIBLE);
                        }
                    });
                }else{
                    joinLayout.setVisibility(View.INVISIBLE);
                    noeventLayout.setVisibility(View.VISIBLE);

                    goback.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            confirmLayout.setVisibility(View.INVISIBLE);
                            noeventLayout.setVisibility(View.INVISIBLE);
                            joinLayout.setVisibility(View.VISIBLE);
                        }
                    });

                }
            }
                    //}
/**
                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) { }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) { }
                });
            } **/
        });

        return v2;
    }

}
