package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.data.remote.RetrofitSingleton;
import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientsConverter;
import com.desafio.dextra.data.model.sandwich.SandwichConverter;
import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SandwichRemoteRepository implements SandwichRepository {

    @Override
    public Single<List<Sandwich>> getSandwichs() {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        SandwishAPI sandwishAPI = retrofit.create(SandwishAPI.class);

        return sandwishAPI.getSandwichsList()
                .subscribeOn(Schedulers.io())
                .map(sandwichDtos -> new SandwichConverter().convert(sandwichDtos))
                .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public Single<List<Ingredient>> getIngredientsOfSandwich(Sandwich sandwich) {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        SandwishAPI sandwishAPI = retrofit.create(SandwishAPI.class);

        return sandwishAPI.getIngredientOfSandwich(sandwich.getId())
                .subscribeOn(Schedulers.io())
                .map(ingredientDtos -> new IngredientsConverter().convert(ingredientDtos))
                .observeOn(AndroidSchedulers.mainThread());
    }

}
