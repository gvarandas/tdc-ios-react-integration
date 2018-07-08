package com.tdc.react.reactintegrationapp;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.reactnativeintegrate.ReactNativeIntegrate;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends KeyEventActivity {

    private TextView mTextMessage;

    MainActivity() {
        Map<String, Class> map = new HashMap<String, Class>();
        map.put("INNER_ACTIVITY", InnerActivity.class);
        ReactNativeIntegrate.setActivitiesMap(map);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    popFragment();
                    return true;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                   // startActivity(new Intent(MainActivity.this, ReactNativeActivity.class));
                    addFragment();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    popFragment();
                    return true;
            }
            return false;
        }
    };

    private void addFragment() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = new ReactNativeFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frag_container, fragment).addToBackStack(null);
        transaction.commit();
    }

    private void popFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if(fm.getBackStackEntryCount()>0) {
            fm.popBackStack();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
