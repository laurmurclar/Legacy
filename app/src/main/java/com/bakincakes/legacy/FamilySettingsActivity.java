package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class FamilySettingsActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    Spinner genderSpinner, bloodlineSpinner, heirSpinner;
    String genderSpinnerKey = "gender_spinner", bloodlineSpinnerKey = "bloodline_spinner",
            heirSpinnerKey = "heir_spinner", nameEditKey ="name_edit";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_settings);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);

        /*Set up edit text */
        editText = (EditText) findViewById(R.id.fam_set_name_edit);
        String storedVal =getStringPref(nameEditKey);
        if (storedVal.equals("Enter Text")) editText.setHint(storedVal);
        else editText.setText(storedVal);
        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == EditorInfo.IME_ACTION_DONE)||
                        (actionId == EditorInfo.IME_ACTION_SEND)||
                        (actionId == EditorInfo.IME_ACTION_SEARCH)) {
                    saveStringPref(nameEditKey, editText.getText().toString());
                    return true;
                }
                return false;
            }
        });
        //TODO get keyboard to close on done. Disp hint instead of default text

        /*Set up Spinners - The gender spinner */
        genderSpinner = (Spinner) findViewById(R.id.fam_set_gender_spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.gender_law_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        genderSpinner.setAdapter(adapter1);
        genderSpinner.setSelection(getIntPref(genderSpinnerKey));
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
                //save value in shared pref
                int userChoice = genderSpinner.getSelectedItemPosition();
                saveIntPref(genderSpinnerKey, userChoice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //leave empty
            }
        });

        //the bloodline spinner
        bloodlineSpinner = (Spinner) findViewById(R.id.fam_set_bloodline_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.bloodline_law_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        bloodlineSpinner.setAdapter(adapter2);
        bloodlineSpinner.setSelection(getIntPref(bloodlineSpinnerKey));
        bloodlineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
               //save value in shared pref
               int userChoice = bloodlineSpinner.getSelectedItemPosition();
               saveIntPref(bloodlineSpinnerKey, userChoice);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {
                //leave empty
           }
        });

        heirSpinner = (Spinner) findViewById(R.id.fam_set_heir_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.heir_law_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        heirSpinner.setAdapter(adapter3);
        heirSpinner.setSelection(getIntPref(heirSpinnerKey));
        heirSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
                //save value in shared pref
                int userChoice = heirSpinner.getSelectedItemPosition();
                saveIntPref(heirSpinnerKey, userChoice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //leave empty
            }
        });
    }



        }
