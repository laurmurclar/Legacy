package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.CheckBox;

public class FamilyActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 3;

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
        String cbKey = "fam_cb";
        CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
        for (int i = 0; i < checkboxes.length; i++){
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey+i, "id",getPackageName()));
            checkboxes[i].setChecked(true);
        }
        //load each saved preference
    }
}