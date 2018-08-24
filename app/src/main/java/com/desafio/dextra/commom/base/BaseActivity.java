package com.desafio.dextra.commom.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.base.alert.AlertView;
import com.desafio.dextra.commom.base.alert.DialogController;
import com.desafio.dextra.commom.base.loading.LoadableView;
import com.desafio.dextra.commom.base.loading.LoadingController;


public class BaseActivity extends AppCompatActivity implements AlertView, LoadableView {

    private LoadableView loadableView;
    private AlertView alertView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadableView = new LoadingController(findViewById(android.R.id.content));
        alertView = new DialogController(this);
    }

    @Override
    public void showLoading() {
        loadableView.showLoading();
    }

    @Override
    public void hideLoading() {
        loadableView.hideLoading();
    }

    public void initToolbar(){
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public void showDialog(String message) {
        alertView.showDialog(message);
    }

    @Override
    public void showDialog(String message, DialogInterface.OnClickListener positiveClick) {
        alertView.showDialog(message, positiveClick);
    }

}
