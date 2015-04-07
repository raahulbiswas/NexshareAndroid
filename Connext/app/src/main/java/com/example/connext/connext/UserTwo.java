package com.example.connext.connext;

import java.util.ArrayList;

/**
 * Created by raahulbiswas on 15-04-06.
 */
public class UserTwo {

   // private String linkedinURL;
    private String full_name;
  //  private String occupation;
    private String profilePic;
    private double percentage;

    //  private double location;
   // private ArrayList<String> skills = new ArrayList<String>();
    // private Map<String, SkillZz> skills = new HashMap<String, SkillZz>();
    //Map<String, Map<String, RealSkillZz>> skilled3 = new HashMap<String, Map<String, RealSkillZz>>();
    //Map<String, RealSkillZz> skilled2 = new HashMap<String, RealSkillZz>();
    // private JSONArray skills;

    public UserTwo() { }
    public UserTwo(String name, String pic, double match) {

        full_name = name;
        percentage = match;
        profilePic = pic;
    }

    public String getFull_name(){return full_name;}
    public String getProfilePic(){return profilePic;}
    public double getPercentage(){return percentage;}
}
