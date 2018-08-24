package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.data.model.ingredient.IngredientDto;
import com.desafio.dextra.data.model.sandwich.SandwichDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SandwishAPI {

    @GET("api/lanche")
    Single<List<SandwichDto>> getSandwichsList();

    @GET("api/ingrediente/de/{id}")
    Single<List<IngredientDto>> getIngredientOfSandwich(@Path("id") int id);

}
