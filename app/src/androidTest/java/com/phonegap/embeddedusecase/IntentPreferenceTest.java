package com.phonegap.embeddedusecase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaPreferences;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Created by jbowser on 2016-11-11.
 */

@RunWith(AndroidJUnit4.class)
public class IntentPreferenceTest extends BaseCordovaInstrumentedTest {
    private static final String GREEN = Integer.toHexString(Color.GREEN);
    private static final String START_URL = "file:///android_asset/www/index.html";

    CordovaPreferences prefs;

    @Rule
    public ActivityTestRule<MainCordovaActivity> mActivityRule = new ActivityTestRule<>(
            MainCordovaActivity.class);

    @Test
    public void useAppContext() throws Exception {
        Intent startIntent = this.setUpIntent(START_URL, "backgroundcolor", GREEN);
        mActivityRule.launchActivity(startIntent);
        final MainCordovaActivity testActivity = mActivityRule.getActivity();
        prefs = testActivity.getCordovaWebView().getPreferences();
        assertFalse(prefs.getInteger("backgroundcolor", Color.BLACK) == Color.GREEN);
    }

}
