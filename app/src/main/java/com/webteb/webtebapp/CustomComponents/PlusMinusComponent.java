package com.webteb.webtebapp.CustomComponents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.webteb.webtebapp.Interfaces.AbstractCallback;
import com.webteb.webtebapp.Utils.UIUtils;
import com.webteb.webtebapp.databinding.ViewPlusMinusItemBinding;

/**
 * Created by khalid on 1/23/18.
 */

public class PlusMinusComponent extends LinearLayout {

    AbstractCallback onPlusListener, onMinusListener;

    public PlusMinusComponent(Context context) {
        super(context);

        init();
    }

    public PlusMinusComponent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public PlusMinusComponent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        ViewPlusMinusItemBinding itemBinding = ViewPlusMinusItemBinding.inflate(inflater, this, false);

        LayoutParams params = new LayoutParams(UIUtils.dpToPx(100), UIUtils.dpToPx(30));

        setGravity(Gravity.CENTER);

        addView(itemBinding.getRoot(), params);

        itemBinding.plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onPlusListener != null) {

                    onPlusListener.onResult(true, null);
                }

            }
        });

        itemBinding.minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onMinusListener != null) {

                    onMinusListener.onResult(true, null);

                }

            }
        });

    }

    public void setOnPlusListener(AbstractCallback onPlusListener) {
        this.onPlusListener = onPlusListener;
    }

    public void setOnMinusListener(AbstractCallback onMinusListener) {
        this.onMinusListener = onMinusListener;
    }
}