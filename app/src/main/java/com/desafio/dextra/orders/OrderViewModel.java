package com.desafio.dextra.orders;

import android.arch.lifecycle.MutableLiveData;

import com.desafio.dextra.commom.base.viewmodel.BaseServiceViewModel;
import com.desafio.dextra.data.DisposableManager;
import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.ingredients.IngredientsCacheRepository;
import com.desafio.dextra.ingredients.IngredientsRepository;
import com.desafio.dextra.sandwich.SandwichCacheRepository;
import com.desafio.dextra.sandwich.SandwichRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class OrderViewModel extends BaseServiceViewModel {

    private MutableLiveData<Sandwich> sandwichMutableLiveData = new MutableLiveData<>();

    private SandwichRepository sandwichRepository = new SandwichCacheRepository();
    private IngredientsRepository ingredientsRepository = new IngredientsCacheRepository();


    public void start(int idSandwich) {
        getSanchwichAndIngredients(idSandwich);
    }

    public MutableLiveData<Sandwich> getSandwich() {
        return sandwichMutableLiveData;
    }

    private void getSanchwichAndIngredients(int idSandwich) {

        Single<Sandwich> singleSandwich = sandwichRepository.getSandiwich(idSandwich);
        Single<List<Ingredient>> singleIngredients = ingredientsRepository.getIngredientsOfSandwich(idSandwich);

        Disposable disposable = singleSandwich
                .doOnSubscribe(disposable1 -> showProgress())
                .doOnSubscribe(disposable12 -> hideDialogError())
                .doAfterTerminate(this::hideProgress)
                .zipWith(singleIngredients, (sandwich, ingredients) -> {
                    sandwich.clearAllIngredients();
                    sandwich.addIngredients(ingredients);
                    return sandwich;
                })
                .subscribe(
                        this::onReceiveSandwich,
                        this::showDialogError
                );

        DisposableManager.add(disposable);

    }

    private void onReceiveSandwich(Sandwich sandwich) {
        sandwichMutableLiveData.setValue(sandwich);
    }
}
