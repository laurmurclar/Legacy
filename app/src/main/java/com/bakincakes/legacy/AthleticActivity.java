package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


public class AthleticActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    int athPoints;
    String athPointsKey = "ath"+pointsKey;
    TextView athPointsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletic);


        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        athPoints = getIntPref(athPointsKey);
        athPointsText = (TextView) findViewById(R.id.ath_points_text);
        athPointsText.setText("Points: "+athPoints);
        final String cbKey = "ath_cb";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey + i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        athPoints++;
                    }
                    else if (athPoints > 0){
                        athPoints--;
                    }
                    saveIntPref(athPointsKey, athPoints);
                    athPointsText.setText("Points: "+ athPoints);
                    switch (buttonView.getId()) {
                        case R.id.ath_cb0:
                            saveBooleanPref("ath_cb0", isChecked);
                            break;
                        case R.id.ath_cb1:
                            saveBooleanPref("ath_cb1", isChecked);
                            break;
                        case R.id.ath_cb2:
                            saveBooleanPref("ath_cb2", isChecked);
                            break;
                        case R.id.ath_cb3:
                            saveBooleanPref("ath_cb3", isChecked);
                            break;
                        case R.id.ath_cb4:
                            saveBooleanPref("ath_cb4", isChecked);
                            break;
                        case R.id.ath_cb5:
                            saveBooleanPref("ath_cb5", isChecked);
                            break;
                        case R.id.ath_cb6:
                            saveBooleanPref("ath_cb6", isChecked);
                            break;
                        case R.id.ath_cb7:
                            saveBooleanPref("ath_cb7", isChecked);
                            break;
                        case R.id.ath_cb8:
                            saveBooleanPref("ath_cb8", isChecked);
                            break;
                        case R.id.ath_cb9:
                            saveBooleanPref("ath_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}
