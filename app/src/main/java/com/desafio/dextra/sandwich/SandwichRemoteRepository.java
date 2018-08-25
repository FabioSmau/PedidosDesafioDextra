package com.desafio.dextra.sandwich;

import com.desafio.dextra.data.model.sandwich.SandwichModel;
import com.desafio.dextra.data.remote.RetrofitSingleton;
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
        SandwichAPI sandwichAPI = retrofit.create(SandwichAPI.class);

        return sandwichAPI.getSandwichesList()
                .subscribeOn(Schedulers.io())
                .map(sandwichDtos -> new SandwichConverter().convert(sandwichDtos))
                .observeOn(AndroidSchedulers.mainThread());
    }

//    @Override
//    public Single<List<Ingredient>> getIngredientsOfSandwich(int idSandwich) {
//        Retrofit retrofit = RetrofitSingleton.getInstance();
//        SandwichAPI sandwishAPI = retrofit.create(SandwichAPI.class);
//
//        return sandwishAPI.getIngredientOfSandwich(idSandwich)
//                .subscribeOn(Schedulers.io())
//                .map(ingredientDtos -> new IngredientsConverter().convert(ingredientDtos))
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//    @Override
//    public Single<List<Ingredient>> getAllIngredients() {
//        Retrofit retrofit = RetrofitSingleton.getInstance();
//        SandwichAPI sandwishAPI = retrofit.create(SandwichAPI.class);
//
//        return sandwishAPI.getAllIngredients()
//                .subscribeOn(Schedulers.io())
//                .map(ingredientDtos -> new IngredientsConverter().convert(ingredientDtos))
//                .observeOn(AndroidSchedulers.mainThread());
//    }

    @Override
    public Single<Sandwich> getSandiwich(int id) {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        SandwichAPI sandwichAPI = retrofit.create(SandwichAPI.class);

        return sandwichAPI.getSandwich(id)
                .subscribeOn(Schedulers.io())
                .map(SandwichModel::valueOf)
                .observeOn(AndroidSchedulers.mainThread());
    }

}
