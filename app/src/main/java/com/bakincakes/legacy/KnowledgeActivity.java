package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class KnowledgeActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);
        //set the checkboxes
        final String cbKey = "kno_cb";
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getPref(cbKey + i));
            checkboxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch (buttonView.getId()) {
                        case R.id.kno_cb0:
                            savePref("kno_cb0", isChecked);
                            break;
                        case R.id.kno_cb1:
                            savePref("kno_cb1", isChecked);
                            break;
                        case R.id.kno_cb2:
                            savePref("kno_cb2", isChecked);
                            break;
                        case R.id.kno_cb3:
                            savePref("kno_cb3", isChecked);
                            break;
                        case R.id.kno_cb4:
                            savePref("kno_cb4", isChecked);
                            break;
                        case R.id.kno_cb5:
                            savePref("kno_cb5", isChecked);
                            break;
                        case R.id.kno_cb6:
                            savePref("kno_cb6", isChecked);
                            break;
                        case R.id.kno_cb7:
                            savePref("kno_cb7", isChecked);
                            break;
                        case R.id.kno_cb8:
                            savePref("kno_cb8", isChecked);
                            break;
                        case R.id.kno_cb9:
                            savePref("kno_cb9", isChecked);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_knowledge, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
