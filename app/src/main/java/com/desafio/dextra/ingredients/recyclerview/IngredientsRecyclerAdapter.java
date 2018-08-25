package com.desafio.dextra.ingredients.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class IngredientsRecyclerAdapter  extends RecyclerView.Adapter<IngredientsViewHolder>{

    private List<IngredientDescription> ingredients = new ArrayList<>();

    public void addIngredients(List<IngredientDescription> ingredients){
        this.ingredients.addAll(ingredients);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder ingredientsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
