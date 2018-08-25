package com.desafio.dextra.ingredients;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafio.dextra.R;
import com.desafio.dextra.commom.base.BaseServiceFragment;
import com.desafio.dextra.databinding.FragmentIngredientsListBinding;
import com.desafio.dextra.ingredients.recyclerview.AmountChangeListener;
import com.desafio.dextra.ingredients.recyclerview.IngredientDescription;
import com.desafio.dextra.ingredients.recyclerview.IngredientsRecyclerAdapter;

import java.util.List;

public class IngredientsListFragment extends BaseServiceFragment {

    private static final String TAG = "IngredientsListFragment";

    private FragmentIngredientsListBinding binding;
    private IngredientsRecyclerAdapter adapter;
    private IngredientsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ingredients_list, container, false);

        viewModel = ViewModelProviders.of(this).get(IngredientsViewModel.class);

        setupBaseBehavior(viewModel);
        setupRecyclerView();
        setupPromotions();

        viewModel.start();

        return binding.getRoot();
    }

    private void setupPromotions() {
        viewModel.listIngredients().observe(this, (promotion -> {
            if (promotion == null)
                return;

            addItensRecyclerView(promotion);
        }));
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.recyclerIngredients;
        adapter= new IngredientsRecyclerAdapter((amount, idIngredient) -> {
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void addItensRecyclerView(List<IngredientDescription> ingredientDescriptionList) {
        adapter.addIngredients(ingredientDescriptionList);
    }

}
