package com.webteb.webtebapp.ViewHolders;

import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.CommercialNameItem;
import com.webteb.webtebapp.Models.InstructionItemModel;
import com.webteb.webtebapp.databinding.ViewDrugRowBinding;
import com.webteb.webtebapp.databinding.ViewInstructionItemBinding;

//import com.squareup.picasso.Picasso;

/**
 * Created by khalid on 1/20/18.
 */

public class DrugItemViewHolder extends BaseCardViewHolder {

    public DrugItemViewHolder(ViewDrugRowBinding binding, BaseCardModel cardModel) {

        super(binding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewDrugRowBinding) dataBinding);
    }

    private void bind(ViewDrugRowBinding dataBinding) {

        CommercialNameItem commercialNameItem = (CommercialNameItem) cardModel.getCardValue();

        dataBinding.setDrug(commercialNameItem);

    }
}
