package com.webteb.webtebapp.Interfaces;

import com.webteb.webtebapp.Enums.CardType;
import com.webteb.webtebapp.Models.BaseCardModel;

import java.util.List;

/**
 * Created by khalid on 1/20/18.
 */

public interface CardFactory {

    List<BaseCardModel> getCardModels();

    BaseCardModel getCardModel(CardType cardType);
}
