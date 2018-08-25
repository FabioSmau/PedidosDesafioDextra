package com.desafio.dextra.ingredients;

import com.desafio.dextra.data.model.ingredient.Ingredient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IngredientResult implements Serializable {

    private List<Ingredient> extras = new ArrayList<>();

    public IngredientResult(List<Ingredient> extras) {
        this.extras = extras;
    }

    public List<Ingredient> getExtras() {
        if (extras == null)
            extras = new ArrayList<>();

        return extras;
    }
}
