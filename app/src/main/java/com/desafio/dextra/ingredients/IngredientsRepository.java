package com.desafio.dextra.ingredients;

import com.desafio.dextra.data.model.ingredient.Ingredient;

import java.util.List;

import io.reactivex.Single;

public interface IngredientsRepository {

    Single<List<Ingredient>> getIngredientsOfSandwich(int idSandwich);
    Single<List<Ingredient>> getAllIngredients();

}
