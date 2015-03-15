package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;


public class PenaltiesActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    int nPowerOff, nPlumbingOff, nKidsTaken, totalPenalties;
    TextView powerText, plumbingText, kidsTakenText, totalPenaltiesText;
    String powerOffKey = "power_off", plumbingOffKey = "plumbing_off", kidsTakenKey = "kids_taken";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalties);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles from strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from strings.xml

        set(navMenuTitles, navMenuIcons);

        //load the counts
        nPowerOff = getIntPref(powerOffKey);
        nPlumbingOff = getIntPref(plumbingOffKey);
        nKidsTaken = getIntPref(kidsTakenKey);

        //set the texts
        powerText = (TextView) findViewById(R.id.pen_power_text);
        powerText.setText(""+nPowerOff);
        plumbingText = (TextView) findViewById(R.id.pen_plumbing_text);
        plumbingText.setText(""+nPlumbingOff);
        kidsTakenText = (TextView) findViewById(R.id.pen_kids_text);
        kidsTakenText.setText(""+nKidsTaken);
        totalPenaltiesText = (TextView) findViewById(R.id.pen_total_text);
        updateTotal();

        //Set up the ImageButtons
        /*---Power Off */
        ImageButton powerNeg = (ImageButton) findViewById(R.id.pen_power_neg);
        powerNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nPowerOff> 0) {
                    nPowerOff--;
                    saveIntPref(powerOffKey, nPowerOff);
                    powerText.setText("" + nPowerOff);
                    updateTotal();
                }
            }
        });
        ImageButton powerPos = (ImageButton) findViewById(R.id.pen_power_pos);
        powerPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nPowerOff++;
                saveIntPref(powerOffKey, nPowerOff);
                powerText.setText(""+nPowerOff);
                updateTotal();
            }
        });

        /* Plumbing Off */
        ImageButton plumbingNeg = (ImageButton) findViewById(R.id.pen_plumbing_neg);
        plumbingNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nPlumbingOff> 0) {
                    nPlumbingOff--;
                    saveIntPref(plumbingOffKey, nPlumbingOff);
                    plumbingText.setText("" + nPlumbingOff);
                    updateTotal();
                }
            }
        });
        ImageButton plumbingPos = (ImageButton) findViewById(R.id.pen_plumbing_pos);
        plumbingPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nPlumbingOff++;
                saveIntPref(plumbingOffKey, nPlumbingOff);
                plumbingText.setText(""+nPlumbingOff);
                updateTotal();
            }
        });

        /* Kids Taken */
        ImageButton kidsNeg = (ImageButton) findViewById(R.id.pen_kids_neg);
        kidsNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nKidsTaken> 0) {
                    nKidsTaken--;
                    saveIntPref(kidsTakenKey, nKidsTaken);
                    kidsTakenText.setText("" + nKidsTaken);
                    updateTotal();
                }
            }
        });
        ImageButton kidsPos = (ImageButton) findViewById(R.id.pen_kids_pos);
        kidsPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nKidsTaken++;
                saveIntPref(kidsTakenKey, nKidsTaken);
                kidsTakenText.setText(""+nKidsTaken);
                updateTotal();
            }
        });
    }

    private void updateTotal(){
        totalPenalties = nPowerOff + nPlumbingOff + nKidsTaken;
        totalPenaltiesText.setText("Penalties: "+totalPenalties);
    }
}
