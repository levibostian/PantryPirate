package com.levibostian.pantrypirate.activity;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.adapter.NavigationDrawerAdapter;
import com.levibostian.pantrypirate.fragment.BaseFragment;
import com.levibostian.pantrypirate.fragment.InventoryFragment;
import com.levibostian.pantrypirate.fragment.LicensesFragment;
import com.levibostian.pantrypirate.fragment.MainFragment;
import com.levibostian.pantrypirate.fragment.RecipesFragment;

public class MainActivity extends ActionBarActivity {
    private static final int HOME = 0;
    private static final int INVENTORY = 1;
    private static final int RECIPES = 2;

    private ListView mDrawerList;
    private String[] mDrawerTitles;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private String mTitle;
    private String mDrawerTitle;

    private BaseFragment mCurrentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        setActivityVariables();
        configureViews();

        if (savedInstanceState == null) {
            mCurrentFragment = new MainFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mCurrentFragment)
                    .commit();
        }
    }

    private void setActivityVariables() {
        setViewVariables();
        setVariables();
    }

    private void configureViews() {
        setNavigationDrawer();
        setActionBar();
    }

    private void setViewVariables() {
        mDrawerTitles = getResources().getStringArray(R.array.navigation_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
    }

    private void setVariables() {
        mTitle = mDrawerTitles[HOME];
        mDrawerTitle = getResources().getString(R.string.app_name);
    }

    private void setActionBar() {
        getSupportActionBar().setTitle(mTitle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(R.color.actionbar_color));
    }

    private void setNavigationDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerList.setAdapter(new NavigationDrawerAdapter(this, mDrawerTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.licenses:
                showLicenses();
                return true;
            case R.id.reset:
                resetFragmentContent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void resetFragmentContent() {
        mCurrentFragment.resetFragmentContent();
    }

    private void showLicenses() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new LicensesFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mneu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, mneu);
        return true;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

        private void selectItem(int position) {
            switch (position) {
                case HOME:
                    switchFragment(new MainFragment());
                    setNavigationDrawerItemClicked(position);
                    break;
                case INVENTORY:
                    switchFragment(new InventoryFragment());
                    setNavigationDrawerItemClicked(position);
                    break;
                case RECIPES:
                    switchFragment(new RecipesFragment());
                    setNavigationDrawerItemClicked(position);
                    break;
            }
        }

        private void switchFragment(BaseFragment fragment) {
            mCurrentFragment = fragment;

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }

        private void setNavigationDrawerItemClicked(int position) {
            mTitle = mDrawerTitles[position];

            mDrawerList.setItemChecked(position, true);
            getSupportActionBar().setTitle(mTitle);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }
}
