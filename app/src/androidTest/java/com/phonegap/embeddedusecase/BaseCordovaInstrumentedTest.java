package com.phonegap.embeddedusecase;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.FrameLayout;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by jbowser on 2016-11-11.
 */


@RunWith(AndroidJUnit4.class)
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
