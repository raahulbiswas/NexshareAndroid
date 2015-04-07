package com.example.connext.connext;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.APIHelper;

import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.errors.LIApiError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {
    ImageButton loginButton; //define login image button on login page
    final Activity currentActivity = this; //set the current activity to be this activity

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Store a reference to the current activity
        final Activity thisActivity = this;

        loginButton = (ImageButton) findViewById(R.id.login);
        //When the login button is pressed
        loginButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //Authenticate User with linkedIn
                LISessionManager.getInstance(getApplicationContext()).init(thisActivity, buildScope(), new AuthListener() {
                    @Override
                    public void onAuthSuccess() { addUser();} //user has been successfully authenticated, call method addUSer
                    @Override
                    public void onAuthError(LIAuthError error) {
                        //Failed to authenticate the user
                        CharSequence text = ("Failed to Authenticate");
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(thisActivity, text, duration);
                        toast.show();
                    }
                }, true);
            }
        });
    }

    private void addUser() {

         //gets the information for particular user
         String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name,industry,headline,skills,connections,picture-url::(original),siteStandardProfileRequest,location:(name),positions:(company:(name),title))";
         APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
            apiHelper.getRequest(this, url, new ApiListener() {
                @Override
                public void onApiSuccess(ApiResponse apiResponse) {
                    try {
                        //Assigns retrieved variables to local variables
                        JSONObject s = apiResponse.getResponseDataAsJson();

                        //String jsonObject = s.toString(2);
                        String linkedinID = s.has("id") ? s.getString("id") : "";
                        String firstName = s.has("firstName") ? s.getString("firstName") : null;
                        String lastName = s.has("lastName") ? s.getString("lastName") : null;
                        String fullName = firstName + " " + lastName;
                        String headline = s.has("headline") ? s.getString("headline") : "";
                        String pictureUrl = s.has("pictureUrl") ? s.getString("pictureUrl") : null;
                        JSONObject skills = s.getJSONObject("skills");
                      //  JSONArray connections = s.has("connections") ? s.getJSONArray("connections"): null;

                        int numberOfSkills = skills.getInt("_total");
                        JSONArray skills2 = skills.getJSONArray("values");

                       // Map<String, SkillZz> skilled = new HashMap<String, SkillZz>();
                        //Map<String, RealSkillZz> skilled2 = new HashMap<String, RealSkillZz>();
                        //Map<String, RealSkillZz> skilled4 = new HashMap<String, RealSkillZz>();
                        //Map<String, Map<String, RealSkillZz>> skilled3 = new HashMap<String, Map<String, RealSkillZz>>();

                       ArrayList<String> tempList= new ArrayList<String>();
/**
                        int count = 0;
                        for (int i = 0 ; i < numberOfSkills; i++){
                            JSONObject iterator = skills2.getJSONObject(i);
                            RealSkillZz skillName = new RealSkillZz(skills2.getJSONObject(i).getJSONObject("skill").getString("name"));
                            SkillZz tempSkill = new SkillZz(iterator.getString("id"), skillName);
                            skilled.put(String.valueOf(count), tempSkill);
                            count++;
                        }
**/
                        //ArrayList<String> list = new ArrayList<>();
                        User user = new User(linkedinID, fullName, pictureUrl, "Sample Event", headline, tempList);
                        //user.addSkill(skills.getJSONArray("values"));

                        //Create a new user and update firebase with this new user
                        //Firebase.setAndroidContext(currentActivity);
                        //Firebase ref = new Firebase("https://connextsupercourse.firebaseio.com/users");

                        String full_name = user.getFull_name();
                        String occupation = user.getOccupation();
                        //Log.v("Here", connections.toString(2));
                        String profilePic = user.getProfilePic();
                        //Firebase userRef = ref.child(user.getLinkedinURL());
                        //userRef.setValue(user);


                        //Create new intent for new activity
                        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                        myIntent.putExtra("ProfilePic",profilePic);
                        myIntent.putExtra("Full_Name",full_name);
                        myIntent.putExtra("Job",occupation);
                        LoginActivity.this.startActivity(myIntent); //launch the main activity

                    } catch (JSONException e) { }//failed to retrieve profile information
                }

                @Override
                public void onApiError(LIApiError apiError) {
                    //Accessing API failed
                }
            });
        }

    //Scope of permissions the application requests from LinkedIn
    private static com.linkedin.platform.utils.Scope buildScope() {
        return com.linkedin.platform.utils.Scope.build(com.linkedin.platform.utils.Scope.R_FULLPROFILE, com.linkedin.platform.utils.Scope.W_SHARE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
    }

}


