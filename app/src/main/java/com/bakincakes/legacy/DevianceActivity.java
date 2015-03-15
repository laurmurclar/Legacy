package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DevianceActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private int NCHECKBOX = 10;
    final CheckBox[] checkboxes = new CheckBox[NCHECKBOX];
    private int nPotions;
    final String potionsKey = "potions";
    final String cbKey = "dev_cb";
    TextView nPotionsText;

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
        nPotions = getIntPref(potionsKey);
        nPotionsText = (TextView) findViewById(R.id.dev_potion_count_text);
        nPotionsText.setText("Total Potions: "+nPotions);

        Button negPotions = (Button) findViewById(R.id.dev_neg_button);
        negPotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nPotions > 0) nPotions--;
                saveIntPref(potionsKey, nPotions);
                updateTotal();
            }
        });
        Button posPotions = (Button) findViewById(R.id.dev_pos_button);
        posPotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nPotions++;
                saveIntPref(potionsKey, nPotions);
                updateTotal();
            }
        });

        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = (CheckBox) findViewById(getResources().getIdentifier(cbKey + i, "id", getPackageName()));
            checkboxes[i].setChecked(getPref(cbKey + i));
            checkboxes[i].setClickable(false);
        }
    }

    private void updateTotal(){
        nPotionsText.setText("Total Potions: "+nPotions);
        int setUpTo = -1;
        if (nPotions >= 80) setUpTo = 9;
        else if (nPotions >= 50) setUpTo = 8;
        else if (nPotions >= 30) setUpTo = 7;
        else if (nPotions >= 20) setUpTo = 6;
        else if (nPotions >= 12) setUpTo = 5;
        else if (nPotions >= 8) setUpTo = 4;
        else if (nPotions >= 5) setUpTo = 3;
        else if (nPotions >= 3) setUpTo = 2;
        else if (nPotions >= 2) setUpTo = 1;
        else if (nPotions >= 1) setUpTo = 0;

        for (int i = 0; i < setUpTo+1; i++){
            checkboxes[i].setChecked(true);
            savePref(cbKey+i,true);
        }
        for (int i = setUpTo+1; i < checkboxes.length; i++){
            checkboxes[i].setChecked(false);
            savePref(cbKey+i, false);
        }

    }
}
