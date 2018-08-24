package com.desafio.dextra.commom.base.loading;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafio.dextra.R;


public class LoadingController implements LoadableView {

    private ViewGroup rootView;
    private View loadingOverlayLayout;

    public LoadingController(android.view.ViewGroup rootView) {
        this.rootView = rootView;
    }

    @SuppressLint("InflateParams")
    @Override
    public void showLoading() {
        if (loadingOverlayLayout == null)
            loadingOverlayLayout = LayoutInflater
                    .from(rootView.getContext())
                    .inflate(R.layout.loading_overlay, null);

        if (rootView != null && loadingOverlayLayout != null) {
            rootView.removeView(loadingOverlayLayout);
            rootView.addView(loadingOverlayLayout);
        }
    }

    @Override
    public void hideLoading() {
        if (loadingOverlayLayout != null && rootView != null)
            rootView.removeView(loadingOverlayLayout);
    }
}
