package com.example.connext.connext;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raahul biswas on 15-02-26.
 */
public class User{

    private String linkedinURL;
    private String full_name;
    private String occupation;
    private String profilePic;
    private String currentEventName;
  //  private double location;
    private ArrayList<String> skills = new ArrayList<String>();
   // private Map<String, SkillZz> skills = new HashMap<String, SkillZz>();
    //Map<String, Map<String, RealSkillZz>> skilled3 = new HashMap<String, Map<String, RealSkillZz>>();
    //Map<String, RealSkillZz> skilled2 = new HashMap<String, RealSkillZz>();
   // private JSONArray skills;

    public User() { }
    public User(String linkedInID, String name, String pic, String event, String job, ArrayList skillz) {
        linkedinURL = linkedInID;
        full_name = name;
        occupation = job;
        profilePic = pic;
        currentEventName = event;
        //location = geoLoc;
        skills = skillz;
    }

    //public JSONArray getSkills(){ return skills; }
    public ArrayList<String> getSkills(){
        return skills;
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
    public String getCurrentEventName(){
        return currentEventName;
    }
    public String getProfilePic(){
        return profilePic;
    }
}


