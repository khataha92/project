package com.webteb.webtebapp.ViewHolders.Bodies;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.webteb.webtebapp.Adapters.CommercialNamesAdapter;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.BodyImageModel;
import com.webteb.webtebapp.Models.CommercialNameItem;
import com.webteb.webtebapp.R;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.Utils.AppUtil;
import com.webteb.webtebapp.ViewHolders.BaseCardViewHolder;
import com.webteb.webtebapp.databinding.ViewCommercialNamesCardBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/21/18.
 */

public class CommercialsCardViewHolder extends BaseCardViewHolder {

    public CommercialsCardViewHolder(ViewCommercialNamesCardBinding dataBinding, BaseCardModel cardModel) {

        super(dataBinding, cardModel);
    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewCommercialNamesCardBinding) dataBinding);
    }

    private void bind(ViewCommercialNamesCardBinding dataBinding) {

        List<CommercialNameItem> allDrugs = AppUtil.getCommercialNames();

        List<CommercialNameItem> filteredDrugs = new ArrayList<>();

        JsonArray jsonArray = new Gson().toJsonTree(cardModel.getCardValue()).getAsJsonArray();

        List<Integer> drugIDs = new Gson().fromJson(jsonArray, new TypeToken<List<Integer>>(){}.getType());

        int index = 0;

        for (CommercialNameItem item : allDrugs) {

            if (isDrugNeeded(item.getId(), drugIDs)) {

                item.backgroundColor = (ThisApp.getContext().getResources().getColor(index % 2 == 0 ? R.color.WHITE : R.color.LIGHT_GRAY));

                filteredDrugs.add(item);

                index++;
            }
        }

        dataBinding.drugs.setLayoutManager(new LinearLayoutManager(ThisApp.getContext()));

        dataBinding.drugs.setAdapter(new CommercialNamesAdapter(filteredDrugs));

    }

    private boolean isDrugNeeded(String drugId, List<Integer> neededDrugs) {

        for (Integer neededDrugId : neededDrugs) {

            if (drugId.equalsIgnoreCase(String.valueOf(neededDrugId))) {

                return true;
            }
        }

        return false;
    }
}
