package com.webteb.webtebapp.ViewHolders;

import android.support.v7.widget.LinearLayoutManager;

import com.webteb.webtebapp.Adapters.FieldBodyAdapter;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.BodyModel;
import com.webteb.webtebapp.Models.FieldItemModel;
import com.webteb.webtebapp.Models.FieldModel;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.databinding.ViewEmptyItemBinding;
import com.webteb.webtebapp.databinding.ViewFieldItemBinding;

import java.util.List;

//import com.squareup.picasso.Picasso;

/**
 * Created by khalid on 1/20/18.
 */

public class EmptyViewHolder extends BaseCardViewHolder {

    public EmptyViewHolder(ViewEmptyItemBinding binding, BaseCardModel cardModel) {

        super(binding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();
    }
}
