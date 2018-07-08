package com.tdc.react.reactintegrationapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;


public class ReactNativeView extends ReactRootView {

    Bundle mBundle;

    ReactNativeView(Context context, Bundle bundle) {
        super(context);

        mBundle = bundle;
    }

    public void startReactApplication(ReactInstanceManager instanceManager) {
        String appName = mBundle.getString(InstanceManager.APP_NAME);
        startReactApplication(instanceManager, appName, null);
    }

}


