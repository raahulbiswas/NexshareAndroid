package com.example.connext.connext;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import static com.example.connext.connext.R.layout.user_layout;

/**
 * Created by raahulbiswas on 15-03-25.
 */
public class AllAttendeesFragment extends Fragment {
    public static AllAttendeesFragment newInstance() {
        AllAttendeesFragment fragment = new AllAttendeesFragment();
        return fragment;
    }

    public AllAttendeesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        ((AllAttendeesActivity) getActivity()).setActionBarTitle("Matched Attendees");
        ((AllAttendeesActivity)  getActivity()).setToolbarColor("5a808e");
        ((AllAttendeesActivity)  getActivity()).setStatus("455A64");
        ((AllAttendeesActivity)  getActivity()).setToolbarShadow();
        View v2 = inflater.inflate(user_layout, container, false);

        ArrayList<RowItem> rowItems = new ArrayList<RowItem>();
        final ArrayList<User> users = new ArrayList<User>();
        final ArrayList<String> attendees = new ArrayList<String>();
        //final Map<String, Object> attendee;
        //final Map<String, Object> users = new HashMap<String,Object>();


        //Firebase.setAndroidContext(getActivity());
      //  Firebase ref = new Firebase("https://connextsupercourse.firebaseio.com/events/Sample%20event");
    //    Firebase userRef = new Firebase("https://connextsupercourse.firebaseio.com");
       // Query uqueryRef = ref.orderByChild("users");
        /**
        uqueryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChild) {
                Map<String, User> user = (Map<String, User>) dataSnapshot.getValue();
                users.add(user.get("users"));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(FirebaseError firebaseError) { }
        });

        Query queryRef = ref.orderByChild("attendees");
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChild) {
                Map<String, Object> attendee = (Map<String, Object>) dataSnapshot.getValue();
                attendees.add(attendee.get("attendees").toString());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Iterator iterator = users.iterator();
        while (iterator.hasNext()) {

        }

**/

       // rowItems.add(new RowItem("Raahul Biswas", (doInBackground("https://media.licdn.com/mpr/mprx/0_GDckGYjVESYQGWUHSD7kuZBVW4WFG4ZkkdTokIsVfpQQGHWkXdDLWuRV2S4VXJkeeyDL_yqsQwH6TpILaY-ZoEzniwHbTpDWHY-b3whUHEjIwo9zkfkdT0aE_O-BHpsZTjneQJzt5cR"))));
        rowItems.add(new RowItem("Raahul Biswas", "https://media.licdn.com/mpr/mprx/0_-m_V_k06LmByHY7Vg0RqSns6TJITmpjFY0UNLACFTZshIugEO0MUaK9Fif9pSYm9lEUsXcvbHmq8DZH64jQ6wKNwSmq3DZJ6OjQJ8lTQQ73SFmGsturBhL7BDRaAkZmcBYG9Ff0jysA"));
        rowItems.add(new RowItem("Arusha Haanee", "https://media.licdn.com/mpr/mprx/0_jE7gvr0EniBfwbwPxmyavPsUs5P_bXVP0wUGvPJo5QbPZ8D1luxlR1SXND1yXiRxpWS_sqbE1lEY"));
        rowItems.add(new RowItem("Vitaliy Krasylovets", "https://media.licdn.com/mpr/mprx/0_GDckGYjVESYQGWUHSD7kuZBVW4WFG4ZkkdTokIsVfpQQGHWkXdDLWuRV2S4VXJkeeyDL_yqsQwH6TpILaY-ZoEzniwHbTpDWHY-b3whUHEjIwo9zkfkdT0aE_O-BHpsZTjneQJzt5cR"));
        rowItems.add(new RowItem("Igar Liubavetskiy", "https://media.licdn.com/mpr/mprx/0_YVqxvNb4NCWhhBhhZOCtR8G4n3Myiv_ulwCA13h4K3Mji5l3NValgLG4PcL3LLl3M4Cx4cDZMt4gLlMuNWA_g82Npt4pLlzhNWAynTJMcPDKfbay44b-9zceyFG2ulCAjovPAPjDpm7"));
        rowItems.add(new RowItem("Tatsiana L", "https://media.licdn.com/mpr/mprx/0_oivHPaEriKddBYT1H5NcPSZh3POoUYr1HTTBPuIrOnoRkVFPQL5Xj2xOfjYq4MA0IhB9yIJzaq-D"));
        rowItems.add(new RowItem("Simone Roth", "https://media.licdn.com/mpr/mprx/0_LPiHRIC7hLyot0uSb1hUReiPCkEsrJySFtcBReC7gbYEfgwDWv1XvH9Tu2o5POgTXK39qfy1ONeo"));

        CustomListArrayAdapter adapter = new CustomListArrayAdapter(getActivity(),rowItems);
        ListView listView = (ListView) v2.findViewById(R.id.attendee_list);
        listView.setAdapter(adapter);


        return v2;

    }



}

