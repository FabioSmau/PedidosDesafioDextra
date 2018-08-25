package com.desafio.dextra.ingredients.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.desafio.dextra.databinding.ItemIngredientListBinding;

public class IngredientsViewHolder extends RecyclerView.ViewHolder {

    private AmountChangeListener listener;
    private ItemIngredientListBinding binding;

    public IngredientsViewHolder(ItemIngredientListBinding binding, AmountChangeListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(IngredientDescription ingredient) {
        binding.setIngredientDescription(ingredient);

        binding.stepperView.setOnChangeListener((updatedValue, stepper) ->
                listener.onChangeAmount(updatedValue, ingredient.getId()));

    }
}
