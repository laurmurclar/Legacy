package com.bakincakes.legacy;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CreativeActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    int crePoints;
    final String crePointsKey = "cre_points";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creative);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        //set the current points
        crePoints = getIntPref(crePointsKey);
        final TextView crePointsText = (TextView) findViewById(R.id.cre_points_text);
        crePointsText.setText("Points: "+ crePoints);
        //set the checkboxes
        final String cbKey = "cre_cb";
        String cbText = "Generation ";
        for (int i = 0; i < checkboxes.length; i++){
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey+i, "id",getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey+i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        crePoints++;
                    }
                    else if ( crePoints > 0){
                        crePoints--;
                    }
                    saveIntPref(crePointsKey, crePoints);
                    crePointsText.setText("Points: "+ crePoints);
                    switch(buttonView.getId()){
                        case R.id.cre_cb0:
                            savePref("cre_cb0",isChecked);
                            break;
                        case R.id.cre_cb1:
                            savePref("cre_cb1",isChecked);
                            break;
                        case R.id.cre_cb2:
                            savePref("cre_cb2",isChecked);
                            break;
                        case R.id.cre_cb3:
                            savePref("cre_cb3",isChecked);
                            break;
                        case R.id.cre_cb4:
                            savePref("cre_cb4",isChecked);
                            break;
                        case R.id.cre_cb5:
                            savePref("cre_cb5",isChecked);
                            break;
                        case R.id.cre_cb6:
                            savePref("cre_cb6",isChecked);
                            break;
                        case R.id.cre_cb7:
                            savePref("cre_cb7",isChecked);
                            break;
                        case R.id.cre_cb8:
                            savePref("cre_cb8",isChecked);
                            break;
                        case R.id.cre_cb9:
                            savePref("cre_cb9",isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
            if (i < 9) checkboxes[i].setText(cbText+(i+1));
        }
        //load each saved preference
    }
}
