package com.desafio.dextra.ingredients;

import android.annotation.SuppressLint;

import com.desafio.dextra.data.model.ingredient.Ingredient;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;

public class IngredientsCacheRepository implements IngredientsRepository {

    private IngredientsRepository repository = new IngredientsRemoteRepository();

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, Single<List<Ingredient>>> ingredientsCacheHash = new HashMap<>();
    private Single<List<Ingredient>> ingredientsCache;

    @Override
    public Single<List<Ingredient>> getIngredientsOfSandwich(int idSandwich) {
        if (ingredientsCacheHash.containsKey(idSandwich)) {
            return ingredientsCacheHash.get(idSandwich);
        } else {
            Single<List<Ingredient>> single = repository.getIngredientsOfSandwich(idSandwich);
            ingredientsCacheHash.put(idSandwich, single.cache());
            return repository.getIngredientsOfSandwich(idSandwich);
        }
    }

    @Override
    public Single<List<Ingredient>> getAllIngredients() {
        Single<List<Ingredient>> ingredients = repository.getAllIngredients();

        if (ingredientsCache == null) {
            ingredientsCache = ingredients.cache();
        }

        return ingredientsCache;
    }
}
