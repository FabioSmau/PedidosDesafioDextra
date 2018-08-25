package com.desafio.dextra.data.model.ingredient;

import com.desafio.dextra.ingredients.recyclerview.IngredientDescription;

import java.util.ArrayList;
import java.util.List;

public class IngredientsConverter {

    public List<Ingredient> convert(List<IngredientDto> ingredientDtos) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (IngredientDto dto : ingredientDtos) {
            ingredients.add(IngredientModel.valueOf(dto));
        }
        return ingredients;
    }

    public List<IngredientDescription> convertDescription(List<Ingredient> ingredients) {
        List<IngredientDescription> promotions = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            promotions.add(IngredientDescription.valueOf(ingredient));
        }
        return promotions;
    }

}
