package com.webteb.webtebapp.ViewHolders;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.webteb.webtebapp.Adapters.FieldBodyAdapter;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.BodyModel;
import com.webteb.webtebapp.Models.FieldItemModel;
import com.webteb.webtebapp.Models.FieldModel;
import com.webteb.webtebapp.Models.ImageCardDataModel;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.databinding.ViewFieldItemBinding;
import com.webteb.webtebapp.databinding.ViewImageCardBinding;

import java.util.List;

//import com.squareup.picasso.Picasso;

/**
 * Created by khalid on 1/20/18.
 */

public class FieldsCardViewHolder extends BaseCardViewHolder {

    public FieldsCardViewHolder(ViewFieldItemBinding binding, BaseCardModel cardModel) {

        super(binding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewFieldItemBinding) dataBinding);
    }

    public void bind(ViewFieldItemBinding dataBinding) {

        FieldModel dataModel = cardModel.getCardValue();

        FieldItemModel fieldItemModel = new FieldItemModel();

        fieldItemModel.setBodyModels(dataModel.getBodyList());

        fieldItemModel.title = dataModel.getTitle();

        fieldItemModel.titleVisibility = (dataModel.getTitle() == null || dataModel.getTitle().length() == 0 ? View.GONE : View.VISIBLE);

        dataBinding.setField(fieldItemModel);

        List<BodyModel> bodyModels = fieldItemModel.getBodyModels();

        LinearLayoutManager bodiesLayoutManager = new LinearLayoutManager(ThisApp.getContext());

        bodiesLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        dataBinding.bodies.setLayoutManager(bodiesLayoutManager);

        FieldBodyAdapter adapter = new FieldBodyAdapter(bodyModels);

        dataBinding.bodies.setAdapter(adapter);

    }
}
