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


public class FoodActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    int fooPoints;
    String fooPointsKey = "foo"+pointsKey;
    TextView fooPointsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        fooPoints = getIntPref(fooPointsKey);
        fooPointsText = (TextView) findViewById(R.id.foo_points_text);
        fooPointsText.setText("Points: "+fooPoints);
        //set the checkboxes
        final String cbKey = "foo_cb";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey + i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        fooPoints++;
                    }
                    else if (fooPoints > 0){
                        fooPoints--;
                    }
                    saveIntPref(fooPointsKey, fooPoints);
                    fooPointsText.setText("Points: "+ fooPoints);
                    switch (buttonView.getId()) {
                        case R.id.foo_cb0:
                            saveBooleanPref("foo_cb0", isChecked);
                            break;
                        case R.id.foo_cb1:
                            saveBooleanPref("foo_cb1", isChecked);
                            break;
                        case R.id.foo_cb2:
                            saveBooleanPref("foo_cb2", isChecked);
                            break;
                        case R.id.foo_cb3:
                            saveBooleanPref("foo_cb3", isChecked);
                            break;
                        case R.id.foo_cb4:
                            saveBooleanPref("foo_cb4", isChecked);
                            break;
                        case R.id.foo_cb5:
                            saveBooleanPref("foo_cb5", isChecked);
                            break;
                        case R.id.foo_cb6:
                            saveBooleanPref("foo_cb6", isChecked);
                            break;
                        case R.id.foo_cb7:
                            saveBooleanPref("foo_cb7", isChecked);
                            break;
                        case R.id.foo_cb8:
                            saveBooleanPref("foo_cb8", isChecked);
                            break;
                        case R.id.foo_cb9:
                            saveBooleanPref("foo_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}
