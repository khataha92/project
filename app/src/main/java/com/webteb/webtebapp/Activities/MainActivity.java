package com.webteb.webtebapp.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.webteb.webtebapp.Adapters.CardsAdapter;
import com.webteb.webtebapp.Controllers.MainActivityController;
import com.webteb.webtebapp.Interfaces.AbstractCallback;
import com.webteb.webtebapp.Observers.PlusMinusObservable;
import com.webteb.webtebapp.R;
import com.webteb.webtebapp.ThisApp;
import com.webteb.webtebapp.Utils.UIUtils;
import com.webteb.webtebapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MainActivityController controller;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ThisApp.setCurrentActivity(this);

        initView();
    }

    private void initView() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        controller = new MainActivityController();

        binding.plusMinus.setOnPlusListener(new AbstractCallback() {
            @Override
            public void onResult(boolean isSuccess, Object result) {

                if(MainActivityController.font >= 16) {

                    return;

                }

                MainActivityController.font ++ ;

                refreshList();

            }
        });

        binding.plusMinus.setOnMinusListener(new AbstractCallback() {
            @Override
            public void onResult(boolean isSuccess, Object result) {

                if(MainActivityController.font <= 9) {

                    return;
                }

                MainActivityController.font -- ;

                refreshList();

            }
        });

        UIUtils.showLoadingView(binding.getRoot());

        controller.getScreenContent(new AbstractCallback() {
            @Override
            public void onResult(boolean isSuccess, Object result) {

                UIUtils.hideLoadingView(binding.getRoot());

                if(isSuccess) {

                    CardsAdapter adapter = (CardsAdapter) result;

                    LinearLayoutManager manager = new LinearLayoutManager(getBaseContext());

                    manager.setOrientation(LinearLayoutManager.VERTICAL);

                    binding.cardsList.setLayoutManager(manager);

                    binding.cardsList.setAdapter(adapter);
                }
            }
        });
    }

    private void refreshList() {

        PlusMinusObservable.getInstance().setFontSizeChanged();
    }
}
