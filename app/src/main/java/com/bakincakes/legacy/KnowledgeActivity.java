package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


public class KnowledgeActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 9;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    private int nSkills;
    final String skillsKey = "skills";
    final String cbKey = "kno_cb";
    TextView nSkillsText;
    int knoPoints;
    String knoPointsKey = "kno"+pointsKey;
    TextView knoPointsText;

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
        knoPoints = getIntPref(knoPointsKey);
        knoPointsText = (TextView) findViewById(R.id.kno_points_text);
        knoPointsText.setText("Points: "+knoPoints);
        nSkills = getIntPref(skillsKey);
        nSkillsText = (TextView) findViewById(R.id.kno_skill_count_text);
        nSkillsText.setText("Total Skills: " + nSkills);

        Button negPotions = (Button) findViewById(R.id.kno_neg_button);
        negPotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nSkills > 0){
                    nSkills--;
                }
                saveIntPref(skillsKey, nSkills);
                updateTotal();
            }
        });
        Button posPotions = (Button) findViewById(R.id.kno_pos_button);
        posPotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nSkills++;
                saveIntPref(skillsKey, nSkills);
                updateTotal();
            }
        });

        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getBooleanPref(cbKey + i));
            checkboxes[i].setClickable(false);
        }
        final String[] array = getResources().getStringArray(R.array.skills_array);
        ViewGroup checkboxContainer = (ViewGroup) findViewById(R.id.kno_skills_checkbox_container);

        for (int i = 0; i < array.length; i++) {
            final CheckBox checkBox = new CheckBox(this);
            checkBox.setText(array[i]);
            checkBox.setChecked(getBooleanPref("kno_"+ checkBox.getText()));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) nSkills++;
                    else nSkills--;
                    saveIntPref(skillsKey, nSkills);
                    updateTotal();
                    savePref("kno_"+checkBox.getText(), isChecked);
                }
            });
            checkboxContainer.addView(checkBox);
        }
    }

    private void updateTotal(){
        nSkillsText.setText("Total Skills: " + nSkills);
        int setUpTo = -1;
        if (nSkills >= 144) setUpTo = 8;
        else if (nSkills >= 89) setUpTo = 7;
        else if (nSkills >= 55) setUpTo = 6;
        else if (nSkills >= 34) setUpTo = 5;
        else if (nSkills >= 21) setUpTo = 4;
        else if (nSkills >= 13) setUpTo = 3;
        else if (nSkills >= 8) setUpTo = 2;
        else if (nSkills >= 5) setUpTo = 1;
        else if (nSkills >= 3) setUpTo = 0;
        knoPoints = 0;
        for (int i = 0; i < setUpTo+1; i++){
            checkboxes[i].setChecked(true);
            knoPoints++;
            savePref(cbKey+i,true);
        }
        for (int i = setUpTo+1; i < checkboxes.length; i++){
            checkboxes[i].setChecked(false);
            savePref(cbKey+i, false);
        }
        saveIntPref(knoPointsKey, knoPoints);
        knoPointsText.setText("Points: "+knoPoints);
    }
}
