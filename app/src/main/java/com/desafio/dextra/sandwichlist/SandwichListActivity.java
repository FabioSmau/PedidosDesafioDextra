package com.desafio.dextra.sandwichlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.BaseActivity;
import com.desafio.dextra.databinding.ActivitySandwichListBinding;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;

import java.util.List;

public class SandwichListActivity extends BaseActivity implements SandwichListContract.View {

    private static final String TAG = "SandwichListActivity";

    private SandwichListContract.Presenter presenter = SandwichPresenter.newInstance();
    private ActivitySandwichListBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sandwich_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    public void addSandwiches(List<Sandwich> sandwiches) {
        Log.i(TAG, "Sucesso chegou lista de sanduiches: ");

        for (Sandwich sandwich : sandwiches) {
            Log.i(TAG, "Sanduiche: " + sandwich.getName());
        }
    }

    @Override
    public void updateSandwich(Sandwich sandwich) {
        Log.i(TAG, "Atualizando item --- " + sandwich.getName());
    }
}
