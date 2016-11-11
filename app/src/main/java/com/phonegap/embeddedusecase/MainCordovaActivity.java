package com.phonegap.embeddedusecase;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaWebView;

/**
 * Created by jbowser on 2016-11-11.
 */

public class MainCordovaActivity extends CordovaActivity {
    public static final String START_URL = "file:///android_asset/www/index.html";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getStringExtra("testStartUrl");
        if (url == null) {
            url = START_URL;
        }
        super.loadUrl(url);
    }

    @Override protected void loadConfig() {
        super.loadConfig();
        // Need to set this explicitly in prefs since it's not settable via bundle extras.
        String errorUrl = getIntent().getStringExtra("testErrorUrl");
        if (errorUrl != null) {
            preferences.set("errorUrl", errorUrl);
        }
    }

    public CordovaWebView getCordovaWebView() {
        return appView;
    }

}
