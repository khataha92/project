package com.webteb.webtebapp.Interfaces;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mac on 8/26/17.
 */

public abstract class RetroCallback<T> implements Callback<T> {

    private static final String TAG = RetroCallback.class.getSimpleName();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful() && response.body() != null) {

            onResult(true, response.body());

        } else if (response.code() == 400) {

            try {

                String body = response.errorBody().string();


                onResult(false, body);

            } catch (Exception e) {

                Log.e(TAG, "Error in getting response, ", e);

            }

        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        onResult(false, t);

    }

    public abstract void onResult(boolean isSuccess, Object result);
}
