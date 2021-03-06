package com.phonegap.embeddedusecase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.engine.SystemWebView;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    String START_URL="file:///android_asset/www/index.html";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    

    @Test
    public void testWebViewLoad() throws Exception {
        Intent startIntent = new Intent();
        mActivityRule.launchActivity(startIntent);
        final MainActivity testActivity = mActivityRule.getActivity();
        final SystemWebView webView = (SystemWebView) testActivity.findViewById(R.id.WebViewComponent);
        final String[] url = new String[1];

        testActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                url[0] = webView.getUrl();
                assertEquals(START_URL,url[0]);
            }
        });



    }

    private void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            fail("Unexpected Timeout");
        }
    }

}
