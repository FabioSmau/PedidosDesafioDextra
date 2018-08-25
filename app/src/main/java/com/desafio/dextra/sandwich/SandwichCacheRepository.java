package com.desafio.dextra.sandwich;

import android.annotation.SuppressLint;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;

public class SandwichCacheRepository implements SandwichRepository {

    private SandwichRepository repository = new SandwichRemoteRepository();

//    @SuppressLint("UseSparseArrays")
//    private HashMap<Integer, Single<List<Ingredient>>> ingredientsCacheHash = new HashMap<>();
//    private Single<List<Ingredient>> ingredientsCache;

    private Single<List<Sandwich>> sandwichesCache;
    private Single<Sandwich> sandwichCache;

    @Override
    public Single<List<Sandwich>> getSandwichs() {
        Single<List<Sandwich>> sandwiches = repository.getSandwichs();

        if (sandwichesCache == null) {
            sandwichesCache = sandwiches.cache();
        }

        return sandwichesCache;
    }

//    @Override
//    public Single<List<Ingredient>> getIngredientsOfSandwich(int idSandwich) {
//        if (ingredientsCacheHash.containsKey(idSandwich)) {
//            return ingredientsCacheHash.get(idSandwich);
//        } else {
//            Single<List<Ingredient>> single = repository.getIngredientsOfSandwich(idSandwich);
//            ingredientsCacheHash.put(idSandwich, single.cache());
//            return repository.getIngredientsOfSandwich(idSandwich);
//        }
//    }
//
//    @Override
//    public Single<List<Ingredient>> getAllIngredients() {
//        Single<List<Ingredient>> ingredients = repository.getAllIngredients();
//
//        if (ingredientsCache == null) {
//            ingredientsCache = ingredients.cache();
//        }
//
//        return ingredientsCache;
//    }

    @Override
    public Single<Sandwich> getSandiwich(int idSandwich) {
        Single<Sandwich> sandwich = repository.getSandiwich(idSandwich);

        if (sandwichCache == null) {
            sandwichCache = sandwich.cache();
        }

        return sandwichCache;
    }
}
