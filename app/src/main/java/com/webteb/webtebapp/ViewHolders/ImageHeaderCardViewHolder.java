package com.webteb.webtebapp.ViewHolders;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.ImageView;

//import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.ImageCardDataModel;
import com.webteb.webtebapp.R;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.databinding.ViewImageCardBinding;

/**
 * Created by khalid on 1/20/18.
 */

public class ImageHeaderCardViewHolder extends BaseCardViewHolder {

    public ImageHeaderCardViewHolder(ViewImageCardBinding binding, BaseCardModel cardModel) {

        super(binding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewImageCardBinding) dataBinding);
    }

    public void bind(ViewImageCardBinding dataBinding) {

        ImageCardDataModel dataModel = (ImageCardDataModel) cardModel.getCardValue();

        dataBinding.setData(dataModel);

        ImageView headerImage = dataBinding.headerImage;

        Picasso.with(ThisApp.getContext()).load(dataModel.imageUrl).into(headerImage);

    }
}
