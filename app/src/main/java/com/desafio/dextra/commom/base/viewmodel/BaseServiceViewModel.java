package com.desafio.dextra.commom.base.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.desafio.dextra.commom.SingleLiveEvent;

public class BaseServiceViewModel extends ViewModel {

    private SingleLiveEvent<Boolean> loadingState = new SingleLiveEvent<>();
    private SingleLiveEvent<Throwable> errorState = new SingleLiveEvent<>();

    public SingleLiveEvent<Boolean> onChangeLoadingState() {
        return loadingState;
    }

    public SingleLiveEvent<Throwable> onError() {
        return errorState;
    }

    protected void showProgress() {
        loadingState.setValue(true);
    }

    protected void hideProgress() {
        loadingState.setValue(false);
    }

    protected void showDialogError(Throwable error) {
        errorState.setValue(error);
    }

    protected void hideDialogError() {
        errorState.setValue(null);
    }
}
