package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.sandwichlist.model.ingredient.IngredientDto;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SandwishAPI {

    @GET("api/lanche")
    Observable<List<SandwichDto>> getSandwichs();

    @GET("api/lanche")
    Single<List<SandwichDto>> getSandwichsList();

    @GET("api/ingrediente/de/{id}")
    Observable<List<IngredientDto>> getIngredientOfSandwich(@Path("id") int id);

}
