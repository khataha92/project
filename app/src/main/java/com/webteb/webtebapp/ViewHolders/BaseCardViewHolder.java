package com.webteb.webtebapp.ViewHolders;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.ViewHolders.Bodies.CommercialsCardViewHolder;
import com.webteb.webtebapp.ViewHolders.Bodies.HtmlCardViewHolder;
import com.webteb.webtebapp.ViewHolders.Bodies.ImageCardViewHolder;
import com.webteb.webtebapp.ViewHolders.Bodies.InstructionsCardViewHolder;
import com.webteb.webtebapp.databinding.ViewCommercialNamesCardBinding;
import com.webteb.webtebapp.databinding.ViewDrugRowBinding;
import com.webteb.webtebapp.databinding.ViewEmptyItemBinding;
import com.webteb.webtebapp.databinding.ViewFieldItemBinding;
import com.webteb.webtebapp.databinding.ViewHtmlItemBinding;
import com.webteb.webtebapp.databinding.ViewImageCardBinding;
import com.webteb.webtebapp.databinding.ViewImageItemBinding;
import com.webteb.webtebapp.databinding.ViewInstructionItemBinding;
import com.webteb.webtebapp.databinding.ViewInstructionsListBinding;
import com.webteb.webtebapp.databinding.ViewRelatedItemBinding;
import com.webteb.webtebapp.databinding.ViewRelatedItemsCardBinding;

public class BaseCardViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = BaseCardViewHolder.class.getSimpleName();

    public BaseCardModel cardModel;

    public ViewDataBinding dataBinding;

    public BaseCardViewHolder(ViewDataBinding dataBinding, BaseCardModel cardModel) {

        super(dataBinding.getRoot());

        this.dataBinding = dataBinding;

        this.cardModel = cardModel;

    }

    public BaseCardViewHolder(View view) {

        super(view);

    }


    public BaseCardModel getCardModel() {

        return cardModel;
    }


    public void setCardModel(BaseCardModel cardModel) {

        this.cardModel = cardModel;
    }

    public static BaseCardViewHolder createViewHolder(ViewGroup parent, BaseCardModel cardModel) {

        return BaseCardViewHolder.createViewHolderInternal(parent, cardModel);


    }

    private static BaseCardViewHolder createViewHolderInternal(ViewGroup parent, BaseCardModel cardModel) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (cardModel.getCardType()) {

            case HRADER_IMAGE_CARD: {

                ViewImageCardBinding itemBinding = ViewImageCardBinding.inflate(layoutInflater, parent, false);

                return new ImageHeaderCardViewHolder(itemBinding, cardModel);

            }

            case HTML_CARD: {

                ViewHtmlItemBinding itemBinding = ViewHtmlItemBinding.inflate(layoutInflater, parent, false);

                return new HtmlCardViewHolder(itemBinding, cardModel);

            }

            case IMAGE_CARD: {

                ViewImageItemBinding itemBinding = ViewImageItemBinding.inflate(layoutInflater, parent, false);

                return new ImageCardViewHolder(itemBinding, cardModel);

            }

            case FIELDS_CARD: {

                ViewFieldItemBinding itemBinding = ViewFieldItemBinding.inflate(layoutInflater, parent, false);

                return new FieldsCardViewHolder(itemBinding, cardModel);

            }

            case INSTRUCTIONS_CARD: {

                ViewInstructionsListBinding itemBinding = ViewInstructionsListBinding.inflate(layoutInflater, parent, false);

                return new InstructionsCardViewHolder(itemBinding, cardModel);

            }

            case INSTRUCTION_ITEM: {

                ViewInstructionItemBinding itemBinding = ViewInstructionItemBinding.inflate(layoutInflater, parent, false);

                return new InstructionItemViewHolder(itemBinding, cardModel);

            }

            case COMMERCIAL_NAME_CARD: {

                ViewCommercialNamesCardBinding itemBinding = ViewCommercialNamesCardBinding.inflate(layoutInflater, parent, false);

                return new CommercialsCardViewHolder(itemBinding, cardModel);
            }

            case COMMERCIAL_NAME_ITEM: {

                ViewDrugRowBinding itemBinding = ViewDrugRowBinding.inflate(layoutInflater, parent, false);

                return new DrugItemViewHolder(itemBinding, cardModel);
            }

            case RELATED_ITEMS_CARD: {

                ViewRelatedItemsCardBinding itemBinding = ViewRelatedItemsCardBinding.inflate(layoutInflater, parent, false);

                return new RelatedItemsCardViewHolder(itemBinding, cardModel);
            }

            case RELATED_ITEM: {

                ViewRelatedItemBinding itemBinding = ViewRelatedItemBinding.inflate(layoutInflater, parent, false);

                return new RelatedItemViewHolder(itemBinding, cardModel);
            }

            default: {

                ViewEmptyItemBinding viewEmptyItemBinding = ViewEmptyItemBinding.inflate(layoutInflater, parent, false);

                return new EmptyViewHolder(viewEmptyItemBinding, cardModel);

            }

        }
    }

    public void initializeView() {

    }

    public void onViewAttachedToWindow() {

    }

    public void onViewDetachedFromWindow() {

    }

}
