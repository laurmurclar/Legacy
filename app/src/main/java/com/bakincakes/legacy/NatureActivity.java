package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class NatureActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        //set the checkboxes
        final String cbKey = "nat_cb";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey + i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch (buttonView.getId()) {
                        case R.id.nat_cb0:
                            savePref("nat_cb0", isChecked);
                            break;
                        case R.id.nat_cb1:
                            savePref("nat_cb1", isChecked);
                            break;
                        case R.id.nat_cb2:
                            savePref("nat_cb2", isChecked);
                            break;
                        case R.id.nat_cb3:
                            savePref("nat_cb3", isChecked);
                            break;
                        case R.id.nat_cb4:
                            savePref("nat_cb4", isChecked);
                            break;
                        case R.id.nat_cb5:
                            savePref("nat_cb5", isChecked);
                            break;
                        case R.id.nat_cb6:
                            savePref("nat_cb6", isChecked);
                            break;
                        case R.id.nat_cb7:
                            savePref("nat_cb7", isChecked);
                            break;
                        case R.id.nat_cb8:
                            savePref("nat_cb8", isChecked);
                            break;
                        case R.id.nat_cb9:
                            savePref("nat_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}
