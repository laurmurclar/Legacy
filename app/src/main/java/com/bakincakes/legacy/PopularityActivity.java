package com.bakincakes.legacy;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;


public class PopularityActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    int medalPoints, nGold, nSilver, nBronze;
    TextView nGoldText, nSilverText, nBronzeText, nMedalsText;
    final String cbKey = "pop_cb";
    int popPoints;
    String popPointsKey = "pop"+pointsKey;
    TextView popPointsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popularity);

        /* Set up Nav Bar */
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        popPoints = getIntPref(popPointsKey);
        popPointsText = (TextView) findViewById(R.id.pop_points_text);
        popPointsText.setText("Points: "+popPoints);

//        /* Set up medal stuff */
        nGold = getIntPref("gold_medals");
        nGoldText = (TextView) findViewById(R.id.pop_gold_count);
        nGoldText.setText(""+nGold);
        nSilver = getIntPref("silver_medals");
        nSilverText = (TextView) findViewById(R.id.pop_silver_count);
        nSilverText.setText(""+nSilver);
        nBronze = getIntPref("bronze_medals");
        nBronzeText = (TextView) findViewById(R.id.pop_bronze_count);
        nBronzeText.setText(""+nBronze);
        medalPoints = totalMedalPoints();
        nMedalsText = (TextView) findViewById(R.id.pop_total_count);
        nMedalsText.setText("Total Medal Points :"+medalPoints);



        //Set up Buttons
        /*---Gold */
        Button goldNeg = (Button) findViewById(R.id.pop_gold_neg);
        goldNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nGold > 0) {
                    nGold--;
                    saveIntPref("gold_medals", nGold);
                    nGoldText.setText("" + nGold);
                    updateTotal();
                }
            }
        });
        Button goldPos = (Button) findViewById(R.id.pop_gold_pos);
        goldPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nGold++;
                saveIntPref("gold_medals", nGold);
                nGoldText.setText(""+nGold);
                updateTotal();
            }
        });
        /*---Silver */
        Button silverNeg = (Button) findViewById(R.id.pop_silver_neg);
        silverNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nSilver > 0) {
                    nSilver--;
                    saveIntPref("silver_medals", nSilver);
                    nSilverText.setText("" + nSilver);
                    updateTotal();
                }
            }
        });
        Button silverPos = (Button) findViewById(R.id.pop_silver_pos);
        silverPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    nSilver++;
                    saveIntPref("silver_medals", nSilver);
                    nSilverText.setText("" + nSilver);
                    updateTotal();
            }
        });
       /*---Bronze */
        Button bronzeNeg = (Button) findViewById(R.id.pop_bronze_neg);
        bronzeNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nBronze > 0) {
                    nBronze--;
                    saveIntPref("bronze_medals", nBronze);
                    nBronzeText.setText("" + nBronze);
                    updateTotal();
                }
            }
        });
        Button bronzePos = (Button) findViewById(R.id.pop_bronze_pos);
        bronzePos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nBronze++;
                saveIntPref("bronze_medals", nBronze);
                nBronzeText.setText("" + nBronze);
                updateTotal();
            }
        });

        //set the checkboxes

        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey + i));
            if (i < checkboxes.length-1) checkboxes[i].setClickable(false);
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        popPoints++;
                    }
                    else if (popPoints > 0){
                        popPoints--;
                    }
                    saveIntPref(popPointsKey, popPoints);
                    popPointsText.setText("Points: "+ popPoints);
                    switch (buttonView.getId()) {
                        case R.id.pop_cb0:
                            savePref("pop_cb0", isChecked);
                            break;
                        case R.id.pop_cb1:
                            savePref("pop_cb1", isChecked);
                            break;
                        case R.id.pop_cb2:
                            savePref("pop_cb2", isChecked);
                            break;
                        case R.id.pop_cb3:
                            savePref("pop_cb3", isChecked);
                            break;
                        case R.id.pop_cb4:
                            savePref("pop_cb4", isChecked);
                            break;
                        case R.id.pop_cb5:
                            savePref("pop_cb5", isChecked);
                            break;
                        case R.id.pop_cb6:
                            savePref("pop_cb6", isChecked);
                            break;
                        case R.id.pop_cb7:
                            savePref("pop_cb7", isChecked);
                            break;
                        case R.id.pop_cb8:
                            savePref("pop_cb8", isChecked);
                            break;
                        case R.id.pop_cb9:
                            savePref("pop_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }

    private int totalMedalPoints(){
        return nBronze+(2*nSilver)+(3*nGold);
    }

    private void updateTotal(){
        medalPoints = totalMedalPoints();
        nMedalsText.setText("Total Medal Points: "+medalPoints);
        int setUpTo = -1;
        if (medalPoints >= 1000) setUpTo = 8;
        else if (medalPoints >= 600) setUpTo = 7;
        else if (medalPoints >= 400) setUpTo = 6;
        else if (medalPoints >= 200) setUpTo = 5;
        else if (medalPoints >= 150) setUpTo = 4;
        else if (medalPoints >= 90) setUpTo = 3;
        else if (medalPoints >= 60) setUpTo = 2;
        else if (medalPoints >= 30) setUpTo = 1;
        else if (medalPoints >= 20) setUpTo = 0;

        for (int i = 0; i < setUpTo+1; i++){
            checkboxes[i].setChecked(true);
            savePref(cbKey+i,true);
        }
        for (int i = setUpTo+1; i < checkboxes.length; i++){
            checkboxes[i].setChecked(false);
            savePref(cbKey+i, false);
        }

    }

    /**
     * on button click
     *
     * increase/decrease the appropriate medal count, and then save it
     * then update medalPoints
     */
}
