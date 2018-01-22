package com.webteb.webtebapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * Created by khalid on 1/19/18.
 */

public class ThisApp extends Application {

    private static Context mContext = null;

    private static Activity mCurrentActivity = null;

    @Override
    public void onCreate() {

        super.onCreate();

        mContext = getApplicationContext();

    }

    public static Context getContext() {

        return mContext;
    }

    public static Activity getCurrentActivity() {

        return mCurrentActivity;

    }

    public static void setCurrentActivity(Activity mCurrentActivity) {

        ThisApp.mCurrentActivity = mCurrentActivity;

    }
}
