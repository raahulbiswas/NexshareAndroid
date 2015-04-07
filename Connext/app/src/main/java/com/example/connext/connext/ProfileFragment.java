package com.example.connext.connext;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff.Mode;
import android.graphics.*;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;

/**
 * Created by raahulbiswas on 15-03-04.
 */
public class ProfileFragment extends Fragment {

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }
    public ProfileFragment() { } // Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Your Profile");
        ((MainActivity) getActivity()).setToolbarTransparent();
        ((MainActivity) getActivity()).setStatus("455A64");
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        String fullName = ((MainActivity) getActivity()).getFull_name();
        String profilePic = ((MainActivity) getActivity()).getProfilePic();
        String occupation = ((MainActivity) getActivity()).getOccupation();


        RoundedImageView picture = (RoundedImageView) v.findViewById(R.id.profilePic);
        TextView job = (TextView) v.findViewById(R.id.personJob);
        job.setText(occupation);
        job.setMovementMethod(new ScrollingMovementMethod());
        TextView name = (TextView) v.findViewById(R.id.personName);
        name.setText(fullName);
        new FetchImageTask(picture).execute(profilePic);
        //picture.setImageDrawable(getResources().getDrawable(R.drawable.profilecirc));

        return v;
    }



}
