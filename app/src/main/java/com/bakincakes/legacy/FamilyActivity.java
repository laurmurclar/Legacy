package com.bakincakes.legacy;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FamilyActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    int famPoints;
    public static final int ACT_NO = 1;
    String famPointsKey = "fam"+pointsKey;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        famPoints = getIntPref(famPointsKey);
        final TextView famPointsText = (TextView) findViewById(R.id.fam_points_text);
        famPointsText.setText("Points: "+famPoints);
        //set the checkboxes
        final String cbKey = keys[ACT_NO]+"_cb";
        String cbText = "Generation ";
        for (int i = 0; i < checkboxes.length; i++){
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey+i, "id",getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey+i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        famPoints++;
                    }
                    else if (famPoints > 0){
                        famPoints--;
                    }
                    saveIntPref(famPointsKey, famPoints);
                    famPointsText.setText("Points: "+ famPoints);
                    switch(buttonView.getId()){
                        case R.id.fam_cb0:
                            saveBooleanPref("fam_cb0", isChecked);
                            break;
                        case R.id.fam_cb1:
                            saveBooleanPref("fam_cb1", isChecked);
                            break;
                        case R.id.fam_cb2:
                            saveBooleanPref("fam_cb2", isChecked);
                            break;
                        case R.id.fam_cb3:
                            saveBooleanPref("fam_cb3", isChecked);
                            break;
                        case R.id.fam_cb4:
                            saveBooleanPref("fam_cb4", isChecked);
                            break;
                        case R.id.fam_cb5:
                            saveBooleanPref("fam_cb5", isChecked);
                            break;
                        case R.id.fam_cb6:
                            saveBooleanPref("fam_cb6", isChecked);
                            break;
                        case R.id.fam_cb7:
                            saveBooleanPref("fam_cb7", isChecked);
                            break;
                        case R.id.fam_cb8:
                            saveBooleanPref("fam_cb8", isChecked);
                            break;
                        case R.id.fam_cb9:
                            saveBooleanPref("fam_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
            if (i < 9) checkboxes[i].setText(cbText+(i+1));
            else checkboxes[i].setText("Lotsa Babies ");
        }
    }
}