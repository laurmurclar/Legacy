package com.bakincakes.legacy;

import java.util.ArrayList;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class BaseActivity extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    protected RelativeLayout _completeLayout, _activityLayout;
    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    public String[] keys;

    final String pointsKey = "_points";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        keys = getResources().getStringArray(R.array.key_array);
         //if (savedInstanceState == null) {
         // on first time display view for first nav item
          //   displayView(0);
         //}
    }

    public void set(String[] navMenuTitles, TypedArray navMenuIcons) {
        mTitle = mDrawerTitle = getTitle();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items
        if (navMenuIcons == null) {
            for (int i = 0; i < navMenuTitles.length; i++) {
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[i]));
            }
        } else {
            for (int i = 0; i < navMenuTitles.length; i++) {
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[i],
                        navMenuIcons.getResourceId(i, -1)));
            }
        }

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, // nav menu toggle icon
                R.string.app_name, // nav drawer open - description for
                // accessibility
                R.string.app_name // nav drawer close - description for
                // accessibility
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        // boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        // menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        switch (position) {
            //Home
            case 0:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                finish();// finishes the current activity
                break;
            //Family
            case 1:
                Intent intent1 = new Intent(this, FamilyActivity.class);
                startActivity(intent1);
                finish();// finishes the current activity
                break;
            //Creative
            case 2:
                Intent intent2 = new Intent(this, CreativeActivity.class);
                startActivity(intent2);
                finish();
                break;
            //Love
            case 3:
                Intent intent3 = new Intent(this, LoveActivity.class);
                startActivity(intent3);
                finish();
                break;
            //Knowledge
            case 4:
                Intent intent4 = new Intent(this, KnowledgeActivity.class);
                startActivity(intent4);
                finish();
                break;
            //Nature
            case 5:
                Intent intent5 = new Intent(this, NatureActivity.class);
                startActivity(intent5);
                finish();
                break;
            //Deviance
            case 6:
                Intent intent6 = new Intent(this, DevianceActivity.class);
                startActivity(intent6);
                finish();
                break;
            //Fortune
            case 7:
                Intent intent7 = new Intent(this, FortuneActivity.class);
                startActivity(intent7);
                finish();
                break;
            //Food
            case 8:
                Intent intent8 = new Intent(this, FoodActivity.class);
                startActivity(intent8);
                finish();
                break;
            //Athletic
            case 9:
                Intent intent9 = new Intent(this, AthleticActivity.class);
                startActivity(intent9);
                finish();
                break;
            //Popularity
            case 10:
                Intent intent10 = new Intent(this, PopularityActivity.class);
                startActivity(intent10);
                finish();
                break;
            //Penalties
            case 11:
                Intent intent11 = new Intent(this, PenaltiesActivity.class);
                startActivity(intent11);
                finish();
                break;
            //Family Settings
            case 12:
                Intent intent12 = new Intent(this, FamilySettingsActivity.class);
                startActivity(intent12);
                finish();
                break;
            default:
                break;
        }

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        mDrawerLayout.closeDrawer(mDrawerList);
    }


    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public boolean getBooleanPref(String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return sharedPreferences.getBoolean(key, false);
    }
    public void saveBooleanPref(String key, boolean value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public int getIntPref(String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return  sharedPreferences.getInt(key, 0);
    }

    public void saveIntPref(String key, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public String getStringPref(String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return sharedPreferences.getString(key,"Enter Text");
    }

    public void saveStringPref(String key, String value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /*
     * Gets the total points from each category and returns the overall total
     */
    public int getAllPoints(){
        Resources res = getResources();
        String[] keys = res.getStringArray(R.array.key_array);
        String activityKey = "";
        int total = 0;
        for (int i = 0; i < keys.length; i++){
            activityKey = keys[i];
            if (i == keys.length-2){    //penalties screen
                total -= getIntPref(activityKey+pointsKey);
            }
            else total += getIntPref(activityKey+pointsKey);
        }
        return total;
    }
}