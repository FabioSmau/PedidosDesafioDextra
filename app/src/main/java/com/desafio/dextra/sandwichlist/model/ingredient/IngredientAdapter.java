package com.desafio.dextra.sandwichlist.model.ingredient;

public class IngredientAdapter implements Ingredient {

    private IngredientDto ingredientDto;

    public IngredientAdapter(IngredientDto ingredientDto) {
        this.ingredientDto = ingredientDto;
    }

    @Override
    public int getId() {
        return ingredientDto.getId();
    }

    @Override
    public String getName() {
        return ingredientDto.getName();
    }

    @Override
    public double getPrice() {
        return ingredientDto.getPrice();
    }

    @Override
    public String getImageUrl() {
        return ingredientDto.getImage();
    }
}
