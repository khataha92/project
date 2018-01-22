package com.webteb.webtebapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by khalid on 1/19/18.
 */

public class FieldModel {

    @SerializedName("Collapsable")
    boolean collapsable;

    @SerializedName("IsOpened")
    boolean isOpen;

    @SerializedName("Bodies")
    List<BodyModel> bodyList;

    @SerializedName("Title")
    String title;

    public boolean isCollapsable() {
        return collapsable;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public List<BodyModel> getBodyList() {
        return bodyList;
    }

    public String getTitle() {
        return title;
    }
}
