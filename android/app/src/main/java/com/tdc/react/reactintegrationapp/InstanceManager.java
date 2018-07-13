package com.tdc.react.reactintegrationapp;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.shell.MainReactPackage;
import com.reactnativeintegrate.ReactNativeIntegratePackage;
import com.tdc.react.reactintegrationapp.data.RetrofitClient;

import java.lang.reflect.Field;

import okhttp3.OkHttpClient;

public class InstanceManager {

    public static final String ASSET_NAME = "asset_name";
    public static final String APP_NAME = "app_name";

    public static ReactInstanceManager createReactInstanceManager(Activity activity, Bundle bundle) {

        String assetName = bundle.getString(InstanceManager.ASSET_NAME);
        ReactInstanceManager reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(activity.getApplication())
                .setBundleAssetName(assetName)
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .addPackage(new ReactNativeIntegratePackage())
                .setUseDeveloperSupport(false)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
            @Override
            public void onReactContextInitialized(ReactContext context) {
                attachToRetrofit(context);
            }
        });
        return reactInstanceManager;
    }

    private static void attachToRetrofit(ReactContext context) {
        try {
            OkHttpClient httpClient = RetrofitClient.getOkHttp();
            OkHttpClientProvider.replaceOkHttpClient(httpClient);

            NetworkingModule networkingModule = context.getNativeModule(NetworkingModule.class);
            Field mClient = networkingModule.getClass().getDeclaredField("mClient");
            mClient.setAccessible(true);
            mClient.set(networkingModule, httpClient);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
