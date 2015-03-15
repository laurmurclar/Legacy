package com.bakincakes.legacy;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends BaseActivity {
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles
        // from
        // strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from
        // strings.xml

        set(navMenuTitles, navMenuIcons);
        //work out total
        total = getAllPoints();
        TextView totalScoreText = (TextView) findViewById(R.id.total_score_text);
        totalScoreText.setText(""+total);
    }
}
