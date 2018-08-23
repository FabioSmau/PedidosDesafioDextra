package com.desafio.dextra.commom;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.alert.AlertDescriptor;
import com.desafio.dextra.commom.alert.AlertView;
import com.desafio.dextra.commom.alert.DialogController;
import com.desafio.dextra.commom.loading.LoadableView;
import com.desafio.dextra.commom.loading.LoadingController;


public class BaseActivity extends AppCompatActivity implements LoadableView, AlertView, SuicidalView {

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
//        runOnUiThread(() -> loadableView.showLoading());

        loadableView.showLoading();
    }

    @Override
    public void hideLoading() {
        loadableView.hideLoading();
//        runOnUiThread(() -> loadableView.hideLoading());
    }

    public void initToolbar(){
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }


    @Override
    public void showDialog(AlertDescriptor alertDescriptor) {
        runOnUiThread(() -> alertView.showDialog(alertDescriptor));
    }

    @Override
    public void showDialog(String message) {
        runOnUiThread(() -> alertView.showDialog(message));
    }

    @Override
    public void showDialog(String message, DialogInterface.OnClickListener positiveClick) {
        runOnUiThread(() -> alertView.showDialog(message, positiveClick));
    }

    @Override
    public void suicide() {
        finish();
    }
}
