package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.sandwichlist.model.ingredient.IngredientDto;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SandwishAPI {

    @GET("api/lanche")
    Observable<List<SandwichDto>> getSandwichs();

    @GET("api/ingrediente/de/{id}")
    Observable<List<IngredientDto>> getIngredientOfSandwich(@Path("id") int id);

}
