package com.levibostian.smarteats.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.levibostian.smarteats.R;
import com.levibostian.smarteats.fragment.MainFragment;

public class MainActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }
}
