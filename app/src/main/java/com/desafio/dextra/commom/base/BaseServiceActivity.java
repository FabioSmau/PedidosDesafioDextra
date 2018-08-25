package com.desafio.dextra.commom.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.base.alert.AlertView;
import com.desafio.dextra.commom.base.alert.DialogController;
import com.desafio.dextra.commom.base.loading.LoadableView;
import com.desafio.dextra.commom.base.loading.LoadingController;
import com.desafio.dextra.commom.base.viewmodel.BaseServiceViewModel;


public class BaseServiceActivity extends AppCompatActivity implements AlertView, LoadableView {

    private LoadableView loadableView;
    private AlertView alertView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadableView = new LoadingController(findViewById(android.R.id.content));
        alertView = new DialogController(this);
    }

    protected void setupButtonHome() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void showLoading() {
        loadableView.showLoading();
    }

    @Override
    public void hideLoading() {
        loadableView.hideLoading();
    }


    @Override
    public void showDialog(String message) {
        alertView.showDialog(message);
    }

    @Override
    public void showDialog(String message, DialogInterface.OnClickListener positiveClick) {
        alertView.showDialog(message, positiveClick);
    }

    public void setupBaseBehavior(BaseServiceViewModel viewModel) {
        setupErrorState(viewModel);
        setupLoadingState(viewModel);
    }

    private void setupErrorState(BaseServiceViewModel viewModel) {
        viewModel.onError().observe(this, (throwable -> {
            if (throwable == null) {
                return;
            }
            showDialog(throwable.getMessage());
        }));
    }

    private void setupLoadingState(BaseServiceViewModel viewModel) {
        viewModel.onChangeLoadingState().observe(this, loading -> {
            if (loading == null)
                return;

            if (loading) {
                showLoading();
            } else {
                hideLoading();
            }
        });
    }

}
