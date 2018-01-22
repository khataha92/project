package com.webteb.webtebapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.webteb.webtebapp.Enums.CardType;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.BodyImageModel;
import com.webteb.webtebapp.Models.BodyModel;
import com.webteb.webtebapp.ViewHolders.BaseCardViewHolder;
import com.webteb.webtebapp.ViewHolders.Bodies.HtmlCardViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/21/18.
 */

public class FieldBodyAdapter extends RecyclerView.Adapter<BaseCardViewHolder> {

    List<BodyModel> bodyModels = new ArrayList<>();

    private static final int COMMERCIAL_NAME = 1;
    private static final int INSTRUCTIONS = 2;
    private static final int IMAGE = 3;
    private static final int HTML = 4;
    private static final int AD = 5;

    public FieldBodyAdapter(List<BodyModel> bodyModels) {

        this.bodyModels = bodyModels;
    }

    @Override
    public BaseCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        BaseCardModel cardModel = new BaseCardModel();

        switch (viewType) {

            case HTML:

                cardModel.setCardType(CardType.HTML_CARD);

                break;

            case INSTRUCTIONS:

                cardModel.setCardType(CardType.INSTRUCTIONS_CARD);

                break;

            case IMAGE:

                cardModel.setCardType(CardType.IMAGE_CARD);

                break;

            case COMMERCIAL_NAME:

                cardModel.setCardType(CardType.COMMERCIAL_NAME_CARD);

                break;

            case AD:

                cardModel.setCardType(CardType.EMPTY);

                break;

        }

        return BaseCardViewHolder.createViewHolder(parent, cardModel);

    }

    @Override
    public void onBindViewHolder(BaseCardViewHolder holder, int position) {

        holder.cardModel.setCardValue(bodyModels.get(position).getContent());

        holder.initializeView();

    }

    @Override
    public void onViewAttachedToWindow(BaseCardViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        holder.onViewAttachedToWindow();
    }

    @Override
    public void onViewDetachedFromWindow(BaseCardViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        holder.onViewDetachedFromWindow();
    }

    @Override
    public int getItemViewType(int position) {

        BodyModel bodyModel = bodyModels.get(position);

        if(bodyModel == null) {

            return -1;
        }

        switch (bodyModel.getType()) {

            case IMAGE: return IMAGE;

            case INSTRUCTIONS: return INSTRUCTIONS;

            case HTML: return HTML;

            case COMMERCIAL_NAME: return COMMERCIAL_NAME;

            case AD: return AD;
        }

        return -1;

    }

    @Override
    public int getItemCount() {

        return bodyModels.size();

    }
}
