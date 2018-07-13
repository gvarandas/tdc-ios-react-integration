package com.tdc.react.reactintegrationapp;

import android.content.Context;
import android.content.res.Resources;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String getValue(Context context, String name) {
        Resources resources = context.getResources();

        try {
            InputStream rawResource = resources.openRawResource(R.raw.config);
            Properties properties = new Properties();
            properties.load(rawResource);
            return properties.getProperty(name);
        } catch (Exception e) {
        }

        return null;
    }
}
