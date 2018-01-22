package com.webteb.webtebapp.ViewHolders.Bodies;

import android.webkit.WebSettings;

import com.webteb.webtebapp.Controllers.MainActivityController;
import com.webteb.webtebapp.Models.BaseCardModel;
import com.webteb.webtebapp.Observers.PlusMinusObservable;
import com.webteb.webtebapp.ViewHolders.BaseCardViewHolder;
import com.webteb.webtebapp.databinding.ViewHtmlItemBinding;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by khalid on 1/21/18.
 */

public class HtmlCardViewHolder extends BaseCardViewHolder implements Observer{

    private static final String MIME_TYPE = "text/html; charset=utf-8";
    private static final String ENCODING = "UTF-8";

    public HtmlCardViewHolder(ViewHtmlItemBinding dataBinding, BaseCardModel cardModel) {
        super(dataBinding, cardModel);

    }

    @Override
    public void initializeView() {

        super.initializeView();

        bind((ViewHtmlItemBinding) dataBinding);

    }

    private void bind(ViewHtmlItemBinding dataBinding) {

        String html = String.valueOf(cardModel.getCardValue());

        dataBinding.webView.loadData(html, MIME_TYPE, ENCODING);

        setFontSize();

    }

    @Override
    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();

        PlusMinusObservable.getInstance().addObserver(this);
    }

    @Override
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();

        PlusMinusObservable.getInstance().deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof PlusMinusObservable) {

            setFontSize();

        }

    }

    private void setFontSize() {

        WebSettings webSettings = ((ViewHtmlItemBinding) dataBinding).webView.getSettings();

        webSettings.setDefaultFontSize(MainActivityController.font);

        ((ViewHtmlItemBinding) dataBinding).webView.requestLayout();

    }
}
