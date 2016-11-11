package com.phonegap.embeddedusecase;

import android.content.Intent;

/**
 * Created by jbowser on 2016-11-11.
 */


public class BaseCordovaInstrumentedTest {

    String START_URL="file:///android_asset/www/index.html";

    protected Intent setUpIntent(String url, String... prefsAndValues) {
        Intent intent = new Intent();
        intent.putExtra("testStartUrl", url);
        for (int i = 0; i < prefsAndValues.length; i += 2) {
            intent.putExtra(prefsAndValues[i], prefsAndValues[i + 1]);
        }
        return intent;
    }

}
