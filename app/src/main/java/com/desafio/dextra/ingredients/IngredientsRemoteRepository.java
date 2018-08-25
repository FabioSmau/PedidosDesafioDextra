package com.desafio.dextra.ingredients;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientsConverter;
import com.desafio.dextra.data.remote.RetrofitSingleton;
import com.desafio.dextra.sandwich.SandwichAPI;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class IngredientsRemoteRepository implements IngredientsRepository {

    @Override
    public Single<List<Ingredient>> getIngredientsOfSandwich(int idSandwich) {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        IngredientsAPI ingredientsAPI = retrofit.create(IngredientsAPI.class);

        return ingredientsAPI.getIngredientOfSandwich(idSandwich)
                .subscribeOn(Schedulers.io())
                .map(ingredientDtos -> new IngredientsConverter().convert(ingredientDtos))
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<List<Ingredient>> getAllIngredients() {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        IngredientsAPI ingredientsAPI = retrofit.create(IngredientsAPI.class);

        return ingredientsAPI.getAllIngredients()
                .subscribeOn(Schedulers.io())
                .map(ingredientDtos -> new IngredientsConverter().convert(ingredientDtos))
                .observeOn(AndroidSchedulers.mainThread());
    }

}
