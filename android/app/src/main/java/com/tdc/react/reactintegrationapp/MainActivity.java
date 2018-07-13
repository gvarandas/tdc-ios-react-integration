package com.tdc.react.reactintegrationapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.reactnativeintegrate.ReactNativeIntegrate;
import com.tdc.react.reactintegrationapp.data.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends KeyEventActivity {

    MainActivity() {
        Map<String, Class> mapActivity = new HashMap<String, Class>();
        mapActivity.put("TALKS", TalksActivity.class);
        ReactNativeIntegrate.setActivitiesMap(mapActivity);

        Map<String, String> mapFragment = new HashMap<String, String>();
        mapFragment.put("EVENTS", EventsFragment.class.getName());
        ReactNativeIntegrate.setFragmentsMap(mapFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_native:
                    addFragment(new EventsFragment());
                    return true;
                case R.id.navigation_react:
                    addFragment(new ReactNativeFragment());
                    return true;
            }
            return false;
        }
    };

    private void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frag_container, fragment).addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitClient.configureAuthenticator(this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        addFragment(new EventsFragment());
    }

}
