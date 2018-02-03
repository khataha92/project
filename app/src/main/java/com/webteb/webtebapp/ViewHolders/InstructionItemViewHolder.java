package com.webteb.webtebapp.ViewHolders;

import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.InstructionItemModel;
import com.webteb.webtebapp.databinding.ViewEmptyItemBinding;
import com.webteb.webtebapp.databinding.ViewInstructionItemBinding;

//import com.squareup.picasso.Picasso;

/**
 * Created by khalid on 1/20/18.
 */

public class InstructionItemViewHolder extends BaseCardViewHolder {

    public InstructionItemViewHolder(ViewInstructionItemBinding binding, BaseCardModel cardModel) {

        super(binding, cardModel);

    }

    @Override
    public void initializeView() {
        super.initializeView();

        bind((ViewInstructionItemBinding) dataBinding);
    }

    private void bind(ViewInstructionItemBinding dataBinding) {

        InstructionItemModel instruction = cardModel.getCardValue();

        dataBinding.setInstruction(instruction);

    }
}
