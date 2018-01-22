package com.webteb.webtebapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khalid on 1/22/18.
 */

public class CommercialNameItem {

    @SerializedName("ID")
    String id;

    @SerializedName("Name")
    String name;

    @SerializedName("EnglishName")
    String englishName;

    @SerializedName("Company")
    String company;

    public int backgroundColor;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getCompany() {
        return company;
    }
}
