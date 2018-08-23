package com.desafio.dextra.sandwichlist.model.sandwich;

import com.desafio.dextra.sandwichlist.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class SandwichAdapter implements Sandwich {

    private SandwichDto sandwichDto;

    public SandwichAdapter(SandwichDto sandwichDto) {
        this.sandwichDto = sandwichDto;
    }

    @Override
    public int getId() {
        return sandwichDto.getId();
    }

    @Override
    public String getName() {
        return sandwichDto.getName();
    }

    @Override
    public List<Ingredient> getIngredients() {
        return new ArrayList<>();
    }

    @Override
    public List<Integer> getIngredientsIdentifiers() {
        return sandwichDto.getIngredients();
    }

    @Override
    public String getImageUrl() {
        return sandwichDto.getImage();
    }

    @Override
    public void setIngredients(List<Ingredient> ingredientsIdentifier) {

    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
