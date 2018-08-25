package com.desafio.dextra.ingredients;

import com.desafio.dextra.data.model.ingredient.IngredientDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IngredientsAPI {

    @GET("api/ingrediente")
    Single<List<IngredientDto>> getAllIngredients();

    @GET("api/ingrediente/de/{id}")
    Single<List<IngredientDto>> getIngredientOfSandwich(@Path("id") int id);

}
