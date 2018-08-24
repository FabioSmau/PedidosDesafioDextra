package com.desafio.dextra.data.model.ingredient;

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

}
