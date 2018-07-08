package com.tdc.react.reactintegrationapp;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.reactnativeintegrate.ReactNativeIntegratePackage;

public class InstanceManager {

    public static final String ASSET_NAME = "asset_name";
    public static final String APP_NAME = "app_name";
    public static final String PROPS = "props";

    public static ReactInstanceManager createReactInstanceManager(Activity activity, Bundle bundle) {

        String assetName = bundle.getString(InstanceManager.ASSET_NAME);
        return ReactInstanceManager.builder()
                .setApplication(activity.getApplication())
                .setBundleAssetName(assetName)
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .addPackage(new ReactNativeIntegratePackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
    }
}
