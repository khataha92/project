package com.webteb.webtebapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.webteb.webtebapp.Enums.CardType;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.RelatedItemModel;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.ViewHolders.BaseCardViewHolder;
import com.webteb.webtebapp.databinding.ViewRelatedItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/22/18.
 */

public class RelatedItemsAdapter extends RecyclerView.Adapter<BaseCardViewHolder> {

    List<RelatedItemModel> relatedItems = new ArrayList<>();

    public RelatedItemsAdapter(List<RelatedItemModel> relatedItems) {

        this.relatedItems = relatedItems;

    }

    @Override
    public BaseCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        BaseCardModel cardModel = new BaseCardModel();

        cardModel.setCardType(CardType.RELATED_ITEM);

        return BaseCardViewHolder.createViewHolder(parent, cardModel);

    }

    @Override
    public void onBindViewHolder(BaseCardViewHolder holder, int position) {

        holder.cardModel.setCardValue(relatedItems.get(position));

        holder.initializeView();
    }

    @Override
    public int getItemCount() {

        return relatedItems == null ? 0 : relatedItems.size();
    }
}
