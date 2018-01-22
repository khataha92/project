package com.webteb.webtebapp.Observers;

import java.util.Observable;

/**
 * Created by khalid on 1/23/18.
 */

public class PlusMinusObservable extends Observable {

    private static PlusMinusObservable instance = null;

    private PlusMinusObservable() {

        instance = this;
    }

    public static PlusMinusObservable getInstance() {

        if(instance == null) {

            instance = new PlusMinusObservable();

        }

        return instance;
    }

    public void setFontSizeChanged() {

        setChanged();

        notifyObservers();
    }
}
