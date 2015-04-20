package com.bakincakes.legacy;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoveActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    int lovPoints;
    String lovPointsKey = "lov"+pointsKey;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        lovPoints = getIntPref(lovPointsKey);
        final TextView lovPointsText = (TextView) findViewById(R.id.lov_points_text);
        lovPointsText.setText("Points: " + lovPoints);
        //set the checkboxes
        final String cbKey = "lov_cb";
        int num = 0;
        for (int i = 0; i < checkboxes.length; i++){
            num += 3;
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey+i, "id",getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey+i));
            checkboxes[i].setText(num+" unique traits");
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        lovPoints++;
                    } else if (lovPoints > 0) {
                        lovPoints--;
                    }
                    saveIntPref(lovPointsKey, lovPoints);
                    lovPointsText.setText("Points: " + lovPoints);
                    switch (buttonView.getId()) {
                        case R.id.lov_cb0:
                            saveBooleanPref("lov_cb0", isChecked);
                            break;
                        case R.id.lov_cb1:
                            saveBooleanPref("lov_cb1", isChecked);
                            break;
                        case R.id.lov_cb2:
                            saveBooleanPref("lov_cb2", isChecked);
                            break;
                        case R.id.lov_cb3:
                            saveBooleanPref("lov_cb3", isChecked);
                            break;
                        case R.id.lov_cb4:
                            saveBooleanPref("lov_cb4", isChecked);
                            break;
                        case R.id.lov_cb5:
                            saveBooleanPref("lov_cb5", isChecked);
                            break;
                        case R.id.lov_cb6:
                            saveBooleanPref("lov_cb6", isChecked);
                            break;
                        case R.id.lov_cb7:
                            saveBooleanPref("lov_cb7", isChecked);
                            break;
                        case R.id.lov_cb8:
                            saveBooleanPref("lov_cb8", isChecked);
                            break;
                        case R.id.lov_cb9:
                            saveBooleanPref("lov_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}