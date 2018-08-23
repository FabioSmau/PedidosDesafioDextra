package com.desafio.dextra.sandwichlist.apagar;

import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;

public interface SandwichRepository {

    Single<List<Sandwich>> getSandwichs();

}
