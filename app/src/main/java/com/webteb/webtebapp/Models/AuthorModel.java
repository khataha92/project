package com.webteb.webtebapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khalid on 1/19/18.
 */

public class AuthorModel {

    @SerializedName("Name")
    String name;

    public String getName() {
        return name;
    }
}
