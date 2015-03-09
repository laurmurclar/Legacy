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
        final String cbKey = "pop_cb";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getPref(cbKey + i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
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

    private int getIntPref(String key){
       SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
       return  sharedPreferences.getInt(key, 0);
    }

    private void saveIntPref(String key, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private int totalMedalPoints(){
        return nBronze+(2*nSilver)+(3*nGold);
    }

    private void updateTotal(){
        medalPoints = totalMedalPoints();
        nMedalsText.setText("Total Medal Points: "+medalPoints);
    }

    /**
     * on button click
     *
     * increase/decrease the appropriate medal count, and then save it
     * then update medalPoints
     */
}
