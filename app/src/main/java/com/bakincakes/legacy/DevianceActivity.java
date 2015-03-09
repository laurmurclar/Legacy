package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class DevianceActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviance);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        //set the checkboxes
        final String cbKey = "dev_cb";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getPref(cbKey + i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch (buttonView.getId()) {
                        case R.id.dev_cb0:
                            savePref("dev_cb0", isChecked);
                            break;
                        case R.id.dev_cb1:
                            savePref("dev_cb1", isChecked);
                            break;
                        case R.id.dev_cb2:
                            savePref("dev_cb2", isChecked);
                            break;
                        case R.id.dev_cb3:
                            savePref("dev_cb3", isChecked);
                            break;
                        case R.id.dev_cb4:
                            savePref("dev_cb4", isChecked);
                            break;
                        case R.id.dev_cb5:
                            savePref("dev_cb5", isChecked);
                            break;
                        case R.id.dev_cb6:
                            savePref("dev_cb6", isChecked);
                            break;
                        case R.id.dev_cb7:
                            savePref("dev_cb7", isChecked);
                            break;
                        case R.id.dev_cb8:
                            savePref("dev_cb8", isChecked);
                            break;
                        case R.id.dev_cb9:
                            savePref("dev_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}
