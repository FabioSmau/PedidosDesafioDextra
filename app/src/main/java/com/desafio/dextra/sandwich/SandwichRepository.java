package com.desafio.dextra.sandwich;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;

public interface SandwichRepository {

    Single<List<Sandwich>> getSandwichs();
//    Single<List<Ingredient>> getIngredientsOfSandwich(int idSandwich);
//    Single<List<Ingredient>> getAllIngredients();
    Single<Sandwich> getSandiwich(int idSandwich);

}
