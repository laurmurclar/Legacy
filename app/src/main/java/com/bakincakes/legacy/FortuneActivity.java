package com.bakincakes.legacy;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class FortuneActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        //set the checkboxes
        final String cbKey = "for_cb";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey + i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch (buttonView.getId()) {
                        case R.id.for_cb0:
                            savePref("for_cb0", isChecked);
                            break;
                        case R.id.for_cb1:
                            savePref("for_cb1", isChecked);
                            break;
                        case R.id.for_cb2:
                            savePref("for_cb2", isChecked);
                            break;
                        case R.id.for_cb3:
                            savePref("for_cb3", isChecked);
                            break;
                        case R.id.for_cb4:
                            savePref("for_cb4", isChecked);
                            break;
                        case R.id.for_cb5:
                            savePref("for_cb5", isChecked);
                            break;
                        case R.id.for_cb6:
                            savePref("for_cb6", isChecked);
                            break;
                        case R.id.for_cb7:
                            savePref("for_cb7", isChecked);
                            break;
                        case R.id.for_cb8:
                            savePref("for_cb8", isChecked);
                            break;
                        case R.id.for_cb9:
                            savePref("for_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}
