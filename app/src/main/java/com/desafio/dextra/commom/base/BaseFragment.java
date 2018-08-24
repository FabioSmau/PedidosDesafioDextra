package com.desafio.dextra.commom.base;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;

import com.desafio.dextra.commom.base.alert.AlertView;
import com.desafio.dextra.commom.base.alert.DialogController;
import com.desafio.dextra.commom.base.loading.LoadableView;
import com.desafio.dextra.commom.base.loading.LoadingController;

import java.util.Objects;

public class BaseFragment extends Fragment implements LoadableView, AlertView {

    private LoadableView loadableView;
    private AlertView alertView;

    public void setupBaseFragment(){
        loadableView = new LoadingController(Objects.requireNonNull(getActivity()).findViewById(android.R.id.content));
        alertView = new DialogController(getContext());
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
}
