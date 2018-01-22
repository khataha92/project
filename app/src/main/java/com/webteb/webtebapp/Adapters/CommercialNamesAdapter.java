package com.webteb.webtebapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.webteb.webtebapp.Enums.CardType;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.CommercialNameItem;
import com.webteb.webtebapp.Models.InstructionItemModel;
import com.webteb.webtebapp.ViewHolders.BaseCardViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/22/18.
 */

public class CommercialNamesAdapter extends RecyclerView.Adapter<BaseCardViewHolder> {

    List<CommercialNameItem> commercialNameItems = new ArrayList<>();

    public CommercialNamesAdapter(List<CommercialNameItem> commercialNameItems) {

        this.commercialNameItems = commercialNameItems;
    }

    @Override
    public BaseCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        BaseCardModel cardModel = new BaseCardModel();

        cardModel.setCardType(CardType.COMMERCIAL_NAME_ITEM);

        return BaseCardViewHolder.createViewHolder(parent, cardModel);
    }

    @Override
    public void onBindViewHolder(BaseCardViewHolder holder, int position) {

        holder.cardModel.setCardValue(commercialNameItems.get(position));

        holder.initializeView();

    }

    @Override
    public int getItemCount() {

        return commercialNameItems == null ? 0 : commercialNameItems.size();

    }
}
