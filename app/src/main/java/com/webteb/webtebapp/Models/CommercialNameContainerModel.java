package com.webteb.webtebapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/22/18.
 */

public class CommercialNameContainerModel {

    @SerializedName("CommercialNames")
    List<CommercialNameItem> commercialNameItems;

    public List<CommercialNameItem> getCommercialNameItems() {
        return commercialNameItems == null ? new ArrayList<CommercialNameItem>() : commercialNameItems;
    }
}
