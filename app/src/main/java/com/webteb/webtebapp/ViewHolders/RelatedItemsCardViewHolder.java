package com.webteb.webtebapp.ViewHolders;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.webteb.webtebapp.Adapters.FieldBodyAdapter;
import com.webteb.webtebapp.Adapters.RelatedItemsAdapter;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.BodyModel;
import com.webteb.webtebapp.Models.FieldItemModel;
import com.webteb.webtebapp.Models.FieldModel;
import com.webteb.webtebapp.Models.RelatedItemModel;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.databinding.ViewFieldItemBinding;
import com.webteb.webtebapp.databinding.ViewRelatedItemsCardBinding;

import java.util.List;

//import com.squareup.picasso.Picasso;

/**
 * Created by khalid on 1/20/18.
 */

public class RelatedItemsCardViewHolder extends BaseCardViewHolder {

    public RelatedItemsCardViewHolder(ViewRelatedItemsCardBinding binding, BaseCardModel cardModel) {

        super(binding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewRelatedItemsCardBinding) dataBinding);
    }

    public void bind(ViewRelatedItemsCardBinding dataBinding) {

        List<RelatedItemModel> relatedItemModels = (List<RelatedItemModel>) cardModel.getCardValue();

        LinearLayoutManager layoutManager = new LinearLayoutManager(ThisApp.getContext());

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        layoutManager.setReverseLayout(true);

        dataBinding.relatedItems.setLayoutManager(layoutManager);

        dataBinding.relatedItems.setAdapter(new RelatedItemsAdapter(relatedItemModels));

    }
}
