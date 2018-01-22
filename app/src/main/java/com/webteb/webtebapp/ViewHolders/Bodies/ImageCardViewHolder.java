package com.webteb.webtebapp.ViewHolders.Bodies;

import android.databinding.ViewDataBinding;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.BodyImageModel;
import com.webteb.webtebapp.Models.ImageCardDataModel;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.ViewHolders.BaseCardViewHolder;
import com.webteb.webtebapp.databinding.ViewImageItemBinding;

import retrofit2.http.Body;

/**
 * Created by khalid on 1/21/18.
 */

public class ImageCardViewHolder extends BaseCardViewHolder {

    public ImageCardViewHolder(ViewImageItemBinding dataBinding, BaseCardModel cardModel) {

        super(dataBinding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewImageItemBinding) dataBinding);

    }

    private void bind(ViewImageItemBinding itemBinding) {

        JsonObject jsonObject = new Gson().toJsonTree(cardModel.getCardValue()).getAsJsonObject();

        BodyImageModel imageModel = new Gson().fromJson(jsonObject, BodyImageModel.class);

        Picasso.with(ThisApp.getContext()).load(imageModel.getImageUrl()).into(itemBinding.image);

    }
}
