package com.bakincakes.legacy;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class FamilyActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        //set the checkboxes
        final String cbKey = "fam_cb";
        String cbText = "Generation ";
        for (int i = 0; i < checkboxes.length; i++){
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey+i, "id",getPackageName()));
            checkboxes[i].setChecked(getPref(cbKey+i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch(buttonView.getId()){
                        case R.id.fam_cb0:
                            savePref("fam_cb0",isChecked);
                            break;
                        case R.id.fam_cb1:
                            savePref("fam_cb1",isChecked);
                            break;
                        case R.id.fam_cb2:
                            savePref("fam_cb2",isChecked);
                            break;
                        case R.id.fam_cb3:
                            savePref("fam_cb3",isChecked);
                            break;
                        case R.id.fam_cb4:
                            savePref("fam_cb4",isChecked);
                            break;
                        case R.id.fam_cb5:
                            savePref("fam_cb5",isChecked);
                            break;
                        case R.id.fam_cb6:
                            savePref("fam_cb6",isChecked);
                            break;
                        case R.id.fam_cb7:
                            savePref("fam_cb7",isChecked);
                            break;
                        case R.id.fam_cb8:
                            savePref("fam_cb8",isChecked);
                            break;
                        case R.id.fam_cb9:
                            savePref("fam_cb9",isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
            if (i < 9) checkboxes[i].setText(cbText+(i+1));
            else checkboxes[i].setText("Lotsa Babies ");
        }
        //load each saved preference
    }

    private boolean getPref(String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return sharedPreferences.getBoolean(key, false);
    }
    private void savePref(String key, boolean value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

}