package com.webteb.webtebapp.Managers;

/**
 * Created by khalid on 1/19/18.
 */

import android.os.Handler;

import com.webteb.webtebapp.Constants;
import com.webteb.webtebapp.Interfaces.AbstractCallback;
import com.webteb.webtebapp.Interfaces.RetroCallback;
import com.webteb.webtebapp.Interfaces.ServiceRequest;
import com.webteb.webtebapp.Models.ContentResponseModel;
import com.webteb.webtebapp.R;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.Utils.AppUtil;
import com.webteb.webtebapp.Utils.UIUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mac on 5/17/17.
 */

public class RetrofitManager {

    private static RetrofitManager instance = null;

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final String SERVER_URL = Constants.SERVICE_API;

    private ServiceRequest request;

    private Retrofit retrofit;


    public static RetrofitManager getInstance() {

        if (instance == null) {

            instance = new RetrofitManager();

        }

        return instance;

    }

    private RetrofitManager() {

        instance = this;

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        request = retrofit.create(ServiceRequest.class);

    }

    public void getContent(AbstractCallback callback) {

        Call<ContentResponseModel> getContent = request.getContent();

        callService(getContent, callback);
    }


    public <T> void callService(final Call<T> call, final AbstractCallback callback) {

        if (AppUtil.isNetworkAvailable()) {

            enqueue(call, callback);

        } else {

            String title = ThisApp.getContext().getString(R.string.NO_INTERNET_CONNECTION);

            String description = ThisApp.getContext().getString(R.string.NO_INTERNET_CONNECTION_DESC);

            UIUtils.showRetryDialog(title, description, new AbstractCallback() {
                @Override
                public void onResult(boolean isSuccess, Object result) {

                    ThisApp.getCurrentActivity().finish();
                }
            }, new AbstractCallback() {
                @Override
                public void onResult(boolean isSuccess, Object result) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            callService(call, callback);
                        }
                    }, 500);

                }
            });
        }

    }

    private <T> void enqueue(Call<T> call, final AbstractCallback callback) {

        call.enqueue(new RetroCallback<T>() {

            @Override
            public void onResult(boolean isSuccess, Object result) {

                if (callback != null) {

                    callback.onResult(isSuccess, result);
                }
            }
        });
    }

}
