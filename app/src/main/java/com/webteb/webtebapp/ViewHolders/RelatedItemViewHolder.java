package com.webteb.webtebapp.ViewHolders;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.CommercialNameItem;
import com.webteb.webtebapp.Models.RelatedItemModel;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.Utils.UIUtils;
import com.webteb.webtebapp.databinding.ViewDrugRowBinding;
import com.webteb.webtebapp.databinding.ViewRelatedItemBinding;

//import com.squareup.picasso.Picasso;

/**
 * Created by khalid on 1/20/18.
 */

public class RelatedItemViewHolder extends BaseCardViewHolder {

    public RelatedItemViewHolder(ViewRelatedItemBinding binding, BaseCardModel cardModel) {

        super(binding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewRelatedItemBinding) dataBinding);
    }

    private void bind(final ViewRelatedItemBinding dataBinding) {

        final RelatedItemModel relatedItemModel = cardModel.getCardValue();

        dataBinding.setRelatedItem(relatedItemModel);

        Picasso.with(ThisApp.getContext()).load(relatedItemModel.getImageUrl()).into(dataBinding.image);

    }
}
