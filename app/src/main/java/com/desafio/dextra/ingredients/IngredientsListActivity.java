package com.desafio.dextra.ingredients;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.base.BaseServiceActivity;
import com.desafio.dextra.databinding.ActivityIngredientsListBinding;
import com.desafio.dextra.ingredients.recyclerview.AmountChangeListener;
import com.desafio.dextra.ingredients.recyclerview.IngredientDescription;
import com.desafio.dextra.ingredients.recyclerview.IngredientsRecyclerAdapter;

import java.util.List;

public class IngredientsListActivity extends BaseServiceActivity implements AmountChangeListener {

    private static final String TAG = "IngredientsListActivity";
    public static final String SELECTED_EXTRA_INGREDIENTS = "IngredientsListActivity";
    public static final int REQUEST_CODE = 2000;

    private ActivityIngredientsListBinding binding;
    private IngredientsRecyclerAdapter adapter;
    private IngredientsViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_ingredients_list);
        viewModel = ViewModelProviders.of(this).get(IngredientsViewModel.class);

        setupButtonHome();
        setupBaseBehavior(viewModel);
        setupRecyclerView();
        setIngredientsObserve();
        setupButtonConfirmClick();

        viewModel.start();
    }

    private void setupButtonConfirmClick() {
        binding.buttonConfirm.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(SELECTED_EXTRA_INGREDIENTS, viewModel.getIngredientsResult());
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void setIngredientsObserve() {
        viewModel.listIngredients().observe(this, (promotion -> {
            if (promotion == null)
                return;

            addItensRecyclerView(promotion);
        }));
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.recyclerIngredients;
        adapter = new IngredientsRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void addItensRecyclerView(List<IngredientDescription> ingredientDescriptionList) {
        adapter.addIngredients(ingredientDescriptionList);
    }

    @Override
    public void onChangeAmount(int amount, int idIngredient) {
        viewModel.onUpdateAmountOfIngredient(amount, idIngredient);
    }
}
