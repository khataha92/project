package com.webteb.webtebapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khalid on 1/21/18.
 */

public class BodyImageModel {

    @SerializedName("ImageUrl")
    String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }
}
