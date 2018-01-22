package com.webteb.webtebapp.Controllers;

import com.webteb.webtebapp.Activities.MainActivity;
import com.webteb.webtebapp.Adapters.CardsAdapter;
import com.webteb.webtebapp.Enums.CardType;
import com.webteb.webtebapp.Interfaces.AbstractCallback;
import com.webteb.webtebapp.Interfaces.CardFactory;
import com.webteb.webtebapp.Managers.RetrofitManager;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Models.ContentResponseModel;
import com.webteb.webtebapp.Models.ImageCardDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalid on 1/19/18.
 */

public class MainActivityController implements CardFactory {

    ContentResponseModel content;

    public static int font = 14;

    public MainActivityController() {

        font = 15;
    }

    public void getScreenContent(final AbstractCallback callback) {

        RetrofitManager.getInstance().getContent(new AbstractCallback() {
            @Override
            public void onResult(boolean isSuccess, Object result) {

                if (isSuccess) {

                    content = (ContentResponseModel) result;

                    CardsAdapter adapter = new CardsAdapter();

                    adapter.setCardModels(getCardModels());

                    callback.onResult(true, adapter);
                }
            }
        });

    }

    @Override
    public List<BaseCardModel> getCardModels() {

        List<BaseCardModel> baseCardModels = new ArrayList<>();

        baseCardModels.add(getCardModel(CardType.HRADER_IMAGE_CARD));

        for (int i = 0; i < content.getFields().size(); i++) {

            BaseCardModel cardModel = new BaseCardModel();

            cardModel.setCardType(CardType.FIELDS_CARD);

            cardModel.setCardValue(content.getFields().get(i));

            baseCardModels.add(cardModel);

        }

        baseCardModels.add(getCardModel(CardType.RELATED_ITEMS_CARD));

        return baseCardModels;
    }

    @Override
    public BaseCardModel getCardModel(CardType cardType) {

        BaseCardModel cardModel = new BaseCardModel();

        cardModel.setCardType(cardType);

        switch (cardType) {

            case HRADER_IMAGE_CARD:

                ImageCardDataModel cardDataModel = new ImageCardDataModel();

                cardDataModel.setImageUrl(content.getImageUrl());

                cardDataModel.setTitle(content.getName());

                cardModel.setCardValue(cardDataModel);

                return cardModel;

            case RELATED_ITEMS_CARD:

                cardModel.setCardValue(content.getRelatedItems());

                return cardModel;

        }

        return cardModel;
    }
}
