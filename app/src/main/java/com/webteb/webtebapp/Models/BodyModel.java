package com.webteb.webtebapp.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.webteb.webtebapp.Enums.BodyType;

/**
 * Created by khalid on 1/19/18.
 */

public class BodyModel {

    @SerializedName("Content")
    Object content;

    @SerializedName("TypeID")
    int typeId;

    @SerializedName("Type")
    BodyType type;

    public Object getContent() {

        return content;
    }

    public int getTypeId() {
        return typeId;
    }

    public BodyType getType() {
        return type;
    }
}
