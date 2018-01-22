package com.webteb.webtebapp.ViewHolders.Bodies;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.webteb.webtebapp.Adapters.InstructionsAdapter;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.BodyImageModel;
import com.webteb.webtebapp.Models.InstructionItemModel;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.ViewHolders.BaseCardViewHolder;
import com.webteb.webtebapp.databinding.ViewInstructionsListBinding;

import java.util.List;

/**
 * Created by khalid on 1/21/18.
 */

public class InstructionsCardViewHolder extends BaseCardViewHolder {

    public InstructionsCardViewHolder(ViewInstructionsListBinding dataBinding, BaseCardModel cardModel) {
        super(dataBinding, cardModel);
    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewInstructionsListBinding) dataBinding);
    }

    private void bind(ViewInstructionsListBinding dataBinding) {

        JsonArray jsonArray = new Gson().toJsonTree(cardModel.getCardValue()).getAsJsonArray();

        List<InstructionItemModel> instructions = new Gson().fromJson(jsonArray, new TypeToken<List<InstructionItemModel>>(){}.getType());

        InstructionsAdapter adapter = new InstructionsAdapter(instructions);

        dataBinding.instructionsList.setLayoutManager(new LinearLayoutManager(ThisApp.getContext()));

        dataBinding.instructionsList.setAdapter(adapter);

    }
}
