package com.desafio.dextra.sandwich;

import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;

public class SandwichCacheRepository implements SandwichRepository {

    private SandwichRepository repository = new SandwichRemoteRepository();

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


    @Override
    public Single<Sandwich> getSandiwich(int idSandwich) {
        Single<Sandwich> sandwich = repository.getSandiwich(idSandwich);

        if (sandwichCache == null) {
            sandwichCache = sandwich.cache();
        }

        return sandwichCache;
    }
}
