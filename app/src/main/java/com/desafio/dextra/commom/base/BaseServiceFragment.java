package com.desafio.dextra.commom.base;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.desafio.dextra.commom.base.alert.AlertView;
import com.desafio.dextra.commom.base.alert.DialogController;
import com.desafio.dextra.commom.base.loading.LoadableView;
import com.desafio.dextra.commom.base.loading.LoadingController;
import com.desafio.dextra.commom.base.viewmodel.BaseServiceViewModel;

import java.util.Objects;

public class BaseServiceFragment extends Fragment implements LoadableView, AlertView {

    private LoadableView loadableView;
    private AlertView alertView;

    public void setupBaseBehavior(BaseServiceViewModel viewModel) {
        loadableView = new LoadingController(Objects.requireNonNull(getActivity()).findViewById(android.R.id.content));
        alertView = new DialogController(getContext());

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
