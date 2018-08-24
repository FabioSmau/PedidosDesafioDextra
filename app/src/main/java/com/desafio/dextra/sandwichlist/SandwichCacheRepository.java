package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;

public class SandwichCacheRepository implements SandwichRepository {

    private SandwichRepository repository = new SandwichRemoteRepository();
    private Single<List<Sandwich>> sandwichesCache;
    private Single<List<Ingredient>> ingredientsCache;

    @Override
    public Single<List<Sandwich>> getSandwichs() {
        Single<List<Sandwich>> sandwiches = repository.getSandwichs();

        if (sandwichesCache == null) {
            sandwichesCache = sandwiches.cache();
        }

        return sandwichesCache;
    }

    @Override
    public Single<List<Ingredient>> getIngredientsOfSandwich(Sandwich sandwich) {
        Single<List<Ingredient>> ingredients = repository.getIngredientsOfSandwich(sandwich);

        if (ingredientsCache == null) {
            ingredientsCache = ingredients.cache();
        }

        return ingredientsCache;
    }
}
