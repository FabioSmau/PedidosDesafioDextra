package com.desafio.dextra.ingredients;

import android.annotation.SuppressLint;
import android.util.Pair;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.ingredients.recyclerview.IngredientDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IngredientDataManager {

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, Pair<Ingredient, IngredientDescription>> ingredientsHash = new HashMap<>();

    public void initWithIngredients(List<Ingredient> ingredients) {
        if (this.ingredientsHash.isEmpty()) {
            for (Ingredient ingredient : ingredients) {
                ingredient.setAmount(0);
                this.ingredientsHash.put(
                        ingredient.getId(),
                        new Pair<>(ingredient, IngredientDescription.valueOf(ingredient))
                );
            }
        }
    }

    public void updateAmountOfIngredient(int amount, int idIngredient) {

        if (this.ingredientsHash.containsKey(idIngredient)) {
            Pair<Ingredient, IngredientDescription> pair = this.ingredientsHash.get(idIngredient);

            Ingredient ingredient = pair.first;
            ingredient.setAmount(amount);

            IngredientDescription description = pair.second;
            description.setAmount(amount);
        }
    }

    public ArrayList<Ingredient> getListIngredients() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (Pair<Ingredient, IngredientDescription> pair : this.ingredientsHash.values()) {
            ingredients.add(pair.first);
        }
        return ingredients;
    }

    public List<IngredientDescription> getListIngredientsDescription() {
        List<IngredientDescription> ingredients = new ArrayList<>();
        for (Pair<Ingredient, IngredientDescription> pair : this.ingredientsHash.values()) {
            ingredients.add(pair.second);
        }
        return ingredients;
    }
}
