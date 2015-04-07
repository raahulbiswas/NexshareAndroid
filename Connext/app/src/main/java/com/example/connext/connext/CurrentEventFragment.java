package com.example.connext.connext;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import static com.example.connext.connext.R.layout.fragment_currentevent;
import static com.example.connext.connext.R.layout.no_event;

/**
 * Created by raahulbiswas on 15-03-04.
 */
public class CurrentEventFragment extends Fragment {
    MapView mapView;
    GoogleMap map;

    public static CurrentEventFragment newInstance() {
        CurrentEventFragment fragment = new CurrentEventFragment();
        return fragment;
    }

    public CurrentEventFragment() { }// Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Current Event");
        ((MainActivity) getActivity()).setToolbarColor("5a808e");
        ((MainActivity) getActivity()).setStatus("455A64");
        ((MainActivity) getActivity()).setToolbarShadow();
        final View v2 = inflater.inflate(fragment_currentevent, container, false);;

        final RelativeLayout mainLayout = (RelativeLayout) v2.findViewById(R.id.main);
        final LinearLayout noEventLayout = (LinearLayout) v2.findViewById(R.id.no_event);

        if (((MainActivity) getActivity()).getHasEvent() == true) {
            mainLayout.setVisibility(View.VISIBLE);
            noEventLayout.setVisibility(View.INVISIBLE);

            final ImageButton addButton = (ImageButton) v2.findViewById(R.id.search_button);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent searchIntent = new Intent(getActivity(), SearchActivity.class);
                    getActivity().startActivity(searchIntent);
                }

            });

            final ImageButton all = (ImageButton) v2.findViewById(R.id.all_attendees2);
            all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent allIntent = new Intent(getActivity(), AllAttendeesActivity.class);
                    getActivity().startActivity(allIntent);
                }

            });



            //Get Firebase Information Here
/**
 **/
        /**
            // Gets the MapView from the XML layout and creates it
            mapView = (MapView) v2.findViewById(R.id.map);
            mapView.onCreate(savedInstanceState);

            // Gets to GoogleMap from the MapView and does initialization stuff
            map = mapView.getMap();
            map.getUiSettings().setMyLocationButtonEnabled(false);

            // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
            MapsInitializer.initialize(this.getActivity());

            // Updates the location and zoom of the MapView
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(43.657658, -79.378802), 15);
            map.moveCamera(cameraUpdate);
         **/
        }
        else
        {
            mainLayout.setVisibility(View.INVISIBLE);
            noEventLayout.setVisibility(View.VISIBLE);
            //v2 = inflater.inflate(no_event, container, false);
        }

        return v2;
    }

    /**
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
**/

}
