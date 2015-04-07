package com.example.connext.connext;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.connext.connext.R.layout.fragment_search;
/**
 * Created by raahulbiswas on 15-03-19.
 */
public class SearchFragment extends Fragment {

    private ArrayList<UserTwo> realList = new ArrayList<>();
    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();

        return fragment;
    }

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        ((SearchActivity) getActivity()).setActionBarTitle("Search Attendees");
        ((SearchActivity) getActivity()).setToolbarColor("5a808e");
        ((SearchActivity) getActivity()).setStatus("5a808e");
        ((SearchActivity) getActivity()).setToolbarShadow();
        final View v2 = inflater.inflate(fragment_search, container, false);

        final RelativeLayout mainLayout = (RelativeLayout) v2.findViewById(R.id.searching);
        final LinearLayout matched = (LinearLayout) v2.findViewById(R.id.results);

        mainLayout.setVisibility(View.VISIBLE);
        matched.setVisibility(View.INVISIBLE);

        final Button searchButton = (Button) v2.findViewById(R.id.search_button2);
        final EditText search = (EditText) v2.findViewById(R.id.search_box);
        final ArrayList<String> skillz = new ArrayList<>();
        final ArrayList<User> userList = new ArrayList<>();


        ArrayList<String> one = new ArrayList<>();
        one.add("Java");
        one.add("Android");
        one.add("HTML");
        one.add("Photoshop");
        one.add("CSS");
        one.add("Programming");
        User raahul = new User("ddssasd", "Raahul Biswas", "https://media.licdn.com/mpr/mprx/0_-m_V_k06LmByHY7Vg0RqSns6TJITmpjFY0UNLACFTZshIugEO0MUaK9Fif9pSYm9lEUsXcvbHmq8DZH64jQ6wKNwSmq3DZJ6OjQJ8lTQQ73SFmGsturBhL7BDRaAkZmcBYG9Ff0jysA", "Sample Event", "dasddsa", one);
        userList.add(raahul);

        ArrayList<String> two = new ArrayList<>();
        two.add("Objective-C");
        two.add("CSS");
        two.add("Ruby");
        two.add("iOS");
        two.add("HTML");
        two.add("Programming");
        User igor = new User("sddsds", "Igar Liubavetskiy", "https://media.licdn.com/mpr/mprx/0_YVqxvNb4NCWhhBhhZOCtR8G4n3Myiv_ulwCA13h4K3Mji5l3NValgLG4PcL3LLl3M4Cx4cDZMt4gLlMuNWA_g82Npt4pLlzhNWAynTJMcPDKfbay44b-9zceyFG2ulCAjovPAPjDpm7","dfssdfs", "dfdsdf", two);
        userList.add(igor);

        ArrayList<String> three = new ArrayList<>();
        three.add("Photoshop");
        three.add("Design");
        three.add("Illustrator");
        three.add("PowerPoint");
        three.add("Word");
        User simone = new User("dsdf", "Simone Roth", "https://media.licdn.com/mpr/mprx/0_LPiHRIC7hLyot0uSb1hUReiPCkEsrJySFtcBReC7gbYEfgwDWv1XvH9Tu2o5POgTXK39qfy1ONeo", "fddsf", "dfsfdsd",three);
        userList.add(simone);

        ArrayList<String> four = new ArrayList<>();
        four.add("Data Entry");
        four.add("Random Crap");
        four.add("dklfdskljndsf");
        four.add("CSS");
        four.add("HTML");
        User arusha = new User("ddasds", "Arusha Haanee", "https://media.licdn.com/mpr/mprx/0_jE7gvr0EniBfwbwPxmyavPsUs5P_bXVP0wUGvPJo5QbPZ8D1luxlR1SXND1yXiRxpWS_sqbE1lEY", "dfdsd", "dffsd", four);
        userList.add(arusha);

        ArrayList<String> five = new ArrayList<>();
        five.add("MATLAB");
        five.add("Photoshop");
        five.add("Programming");
        five.add("Management");
        five.add("Derping");
        User vitaliy = new User("dfdsfds", "Vitaliy Krasylovets", "https://media.licdn.com/mpr/mprx/0_GDckGYjVESYQGWUHSD7kuZBVW4WFG4ZkkdTokIsVfpQQGHWkXdDLWuRV2S4VXJkeeyDL_yqsQwH6TpILaY-ZoEzniwHbTpDWHY-b3whUHEjIwo9zkfkdT0aE_O-BHpsZTjneQJzt5cR", "DSdfsd", "Fdsfsd", five);
        userList.add(vitaliy);

        ArrayList<String> six = new ArrayList<>();
        six.add("derp");
        six.add("herp");
        six.add("Design");
        six.add("Illustrator");
        User danish = new User("dfsfs", "Syed Danish Imran", "https://media.licdn.com/mpr/mprx/0_FJCU1mAsfnIBiVbt5MlX121UfPgqTV9tLgnX12tErnWLYY3-w0tBgu6k3jjoGjcY6V85pwuPW7X7", "dsf", "dfds", six);
        userList.add(danish);

        ArrayList<String> seven = new ArrayList<>();
        seven.add("Management");
        seven.add("Data Entry");
        seven.add("Potatoe");
        User marco = new User("dffds","Marco Germinario", "https://media.licdn.com/mpr/mprx/0_7ujWforoDuANeULn5j5depEIde1NHeUchjFFox5oWZOzS4UVhj5Wk2AooJ7dadUnhjFb3UOEhmKva2pRh04vFOPQ5mKqa20ch04E20Qwm75ZXVXwummXuwesLREXb2e6Wyy5wDOUQRG", "dsfds","dsfs",seven);
        userList.add(marco);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
               final String skillsString = search.getText().toString();
               String skills [] = skillsString.split(", ");

                //debug
                for(int i =0; i < skills.length; i++) {
                    skillz.add(skills[i]);

                }

                for(int i= 0; i < userList.size(); i++){
                    int count = 0;
                    for(int x=0; x < userList.get(i).getSkills().size(); x++){
                        for(int j=0; j < skillz.size();j++){
                            if (userList.get(i).getSkills().get(x).equals(skillz.get(j))){
                                count++;
                            }
                        }

                    }

                    DecimalFormat df = new DecimalFormat("0.#");
                    df.setRoundingMode(RoundingMode.DOWN);
                    double match = Double.valueOf(df.format((((double) count)/skillz.size()) * 100));
                    UserTwo derp = new UserTwo(userList.get(i).getFull_name(), userList.get(i).getProfilePic(), match);
                    realList.add(derp);
                }

                ArrayList<MatchItem> rowItems = new ArrayList<MatchItem>();


                for(int a=0; a < realList.size(); a++){
                    MatchItem temp = new MatchItem(realList.get(a).getFull_name(),realList.get(a).getProfilePic(),realList.get(a).getPercentage());
                    rowItems.add(temp);
                }

                mainLayout.setVisibility(View.INVISIBLE);
                matched.setVisibility(View.VISIBLE);

                MatchListAdapter adapter = new MatchListAdapter(getActivity(),rowItems);
                ListView listView = (ListView) v2.findViewById(R.id.attendee_list);
                listView.setAdapter(adapter);



                /**
                Fragment fragment = new ResultsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                 **/
                /**
                Intent resultsIntent = new Intent(getActivity(), ResultsActivity.class);
                getActivity().startActivity(resultsIntent);
                 **/
            }

        });



        return v2;

    }
}
