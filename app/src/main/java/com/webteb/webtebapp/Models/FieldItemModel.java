package com.webteb.webtebapp.Models;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/21/18.
 */

public class FieldItemModel {

    public String title;

    public int titleVisibility = View.VISIBLE;

    List<BodyModel> bodyModels = new ArrayList<>();

    public void setBodyModels(List<BodyModel> bodyModels) {
        this.bodyModels = bodyModels;
    }

    public List<BodyModel> getBodyModels() {
        return bodyModels;
    }
}
