package com.desafio.dextra.sandwichlist.model.organizer;

import com.desafio.dextra.sandwichlist.model.ingredient.IngredientDto;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;

import java.util.List;

public interface SandwichManager {

    void addSandwiches(List<SandwichDto> sandwiches);
    Sandwich addIngredientsToSandwich(int idSandwich, List<IngredientDto>ingredients);
    List<Sandwich> getSandwichs();
}
