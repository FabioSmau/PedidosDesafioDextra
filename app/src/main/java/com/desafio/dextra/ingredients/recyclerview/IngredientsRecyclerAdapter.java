package com.desafio.dextra.ingredients.recyclerview;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.desafio.dextra.R;
import com.desafio.dextra.databinding.ItemIngredientListBinding;

import java.util.ArrayList;
import java.util.List;

public class IngredientsRecyclerAdapter extends RecyclerView.Adapter<IngredientsViewHolder> {

    private AmountChangeListener listener;
    private List<IngredientDescription> ingredients = new ArrayList<>();

    public IngredientsRecyclerAdapter(AmountChangeListener listener) {
        this.listener = listener;
    }

    public void addIngredients(List<IngredientDescription> ingredients) {
        this.ingredients.addAll(ingredients);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemIngredientListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_ingredient_list,
                viewGroup,
                false
        );

        return new IngredientsViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder ingredientsViewHolder, int i) {
        ingredientsViewHolder.bind(ingredients.get(i));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}
