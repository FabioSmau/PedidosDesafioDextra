package com.desafio.dextra.sandwichlist.model.converter;

import android.util.SparseArray;

import com.desafio.dextra.sandwichlist.model.ingredient.Ingredient;
import com.desafio.dextra.sandwichlist.model.ingredient.IngredientDto;
import com.desafio.dextra.sandwichlist.model.ingredient.IngredientModel;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichModel;

import java.util.ArrayList;
import java.util.List;

public class SandwichDtoConverter implements SandwichConverter {

    private List<SandwichDto> sandwichDtos;
    private SparseArray<IngredientDto> ingredientDtoSparse;

    public SandwichDtoConverter(List<SandwichDto> sandwichDtos, List<IngredientDto> ingredientDtos) {
        this.sandwichDtos = sandwichDtos;
        this.ingredientDtoSparse = convertIngredientsDto(ingredientDtos);
    }

    private SparseArray<IngredientDto> convertIngredientsDto(List<IngredientDto> ingredients) {
        SparseArray<IngredientDto> array = new SparseArray<>();
        for (IngredientDto dto : ingredients) {
            array.put(dto.getId(), dto);
        }
        return array;
    }

    @Override
    public List<Sandwich> convert() {
        List<Sandwich> sandwiches = new ArrayList<>();
        for (SandwichDto dto : sandwichDtos) {
            List<Ingredient> ingredients = getIngredientsFromSandwich(dto);
            Sandwich sandwichConverted = SandwichModel.valueOf(dto);
            sandwichConverted.setIngredients(ingredients);
        }
        return sandwiches;
    }

    private List<Ingredient> getIngredientsFromSandwich(SandwichDto dto) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (Integer idIngredient : dto.getIngredients()) {
            IngredientDto ingredientDto = ingredientDtoSparse.get(idIngredient);
            if (ingredientDto != null) {
                ingredients.add(IngredientModel.valueOf(ingredientDto));
            }
        }
        return ingredients;
    }
}
