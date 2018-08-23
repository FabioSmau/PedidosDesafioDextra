package com.desafio.dextra.sandwichlist.model.organizer;

import com.desafio.dextra.sandwichlist.model.ingredient.Ingredient;
import com.desafio.dextra.sandwichlist.model.ingredient.IngredientDto;
import com.desafio.dextra.sandwichlist.model.ingredient.IngredientModel;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.Nullable;

public class SandwichManagerImpl implements SandwichManager {

    private List<Sandwich> sandwiches = new ArrayList<>();

    @Override
    public void addSandwiches(List<SandwichDto> sandwiches) {
        this.sandwiches.clear();
        this.sandwiches.addAll(convertToSandwich(sandwiches));
    }

    private List<Sandwich> convertToSandwich(List<SandwichDto> sandwichDtos) {
        List<Sandwich> sandwiches = new ArrayList<>();
        for (SandwichDto dto : sandwichDtos) {
            Sandwich sandwich = SandwichModel.valueOf(dto);
            sandwiches.add(sandwich);
        }
        return sandwiches;
    }


    @Override
    @Nullable
    public synchronized Sandwich addIngredientsToSandwich(int idSandwich, List<IngredientDto> ingredients) {
        for (Sandwich sandwich : sandwiches) {
            if (sandwich.getId() == idSandwich) {
                sandwich.setIngredients(convertToIngredients(ingredients));
                return sandwich;
            }
        }
        return null;
    }

    private List<Ingredient> convertToIngredients(List<IngredientDto> ingredientsDto) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (IngredientDto dto : ingredientsDto) {
            Ingredient ingredient = IngredientModel.valueOf(dto);
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    @Override
    public List<Sandwich> getSandwichs() {
        return sandwiches;
    }

}
