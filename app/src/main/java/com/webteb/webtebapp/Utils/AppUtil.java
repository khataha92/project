package com.webteb.webtebapp.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.webteb.webtebapp.Models.CommercialNameContainerModel;
import com.webteb.webtebapp.Models.CommercialNameItem;
import com.webteb.webtebapp.ThisApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/19/18.
 */

public class AppUtil {

    private static final String TAG = AppUtil.class.getSimpleName();

    public static boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) ThisApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    static String getString(int resourceId) {

        try {

            return ThisApp.getContext().getString(resourceId);

        } catch (Exception e) {

            Log.e(TAG, "Error in retrieving resource ", e);

            return "";

        }
    }

    public static List<CommercialNameItem> getCommercialNames() {

        String json = null;

        try {

            InputStream is = ThisApp.getContext().getAssets().open("Drugs.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

            CommercialNameContainerModel containerModel = new Gson().fromJson(json, CommercialNameContainerModel.class);

            if(containerModel != null) {

                return containerModel.getCommercialNameItems();
            }

            return new ArrayList<>();

        } catch (IOException ex) {

            ex.printStackTrace();

            return new ArrayList<>();
        }
    }

}
