package com.webteb.webtebapp.Interfaces;

import com.webteb.webtebapp.Constants;
import com.webteb.webtebapp.Models.ContentResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by khalid on 1/19/18.
 */

public interface ServiceRequest {

    @GET(Constants.GET_CONTENT_METHOD_NAME)
    Call<ContentResponseModel> getContent();
}
