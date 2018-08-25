package com.desafio.dextra.sandwich;

import android.arch.lifecycle.MutableLiveData;

import com.desafio.dextra.commom.base.viewmodel.BaseServiceViewModel;
import com.desafio.dextra.data.DisposableManager;
import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.ingredients.IngredientsCacheRepository;
import com.desafio.dextra.ingredients.IngredientsRepository;
import com.desafio.dextra.sandwich.recyclerview.SandwichDescription;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class SandwichViewModel extends BaseServiceViewModel {

    private MutableLiveData<List<SandwichDescription>> sandwichesDescriptorLiveData = new MutableLiveData<>();
    private SandwichDataManager updater = new SandwichDataManager();

    private SandwichRepository sandwichRepository = new SandwichCacheRepository();
    private IngredientsRepository ingredientsRepository = new IngredientsCacheRepository();


    public void start() {
        getSandwiches();
    }

    public MutableLiveData<List<SandwichDescription>> listSandwiches() {
        return sandwichesDescriptorLiveData;
    }

    private void getSandwiches() {
        Single<List<Sandwich>> single = sandwichRepository.getSandwichs();

        Disposable disposable = single
                .doOnSubscribe(disposable1 -> showProgress())
                .doOnSubscribe(disposable12 -> hideDialogError())
                .doAfterTerminate(this::hideProgress)
                .doAfterSuccess(this::getIngredients)
                .subscribe(
                        this::onReceiveSandwiches,
                        this::showDialogError

                );

        DisposableManager.add(disposable);
    }

    private void getIngredients(List<Sandwich> sandwiches) {
        for (Sandwich sandwich : sandwiches) {
            getIngredientsOfSandwich(sandwich);
        }
    }

    private void getIngredientsOfSandwich(Sandwich sandwich) {
        Single<List<Ingredient>> single = ingredientsRepository.getIngredientsOfSandwich(sandwich.getId());

        Disposable disposable = single
                .doOnSubscribe(disposable12 -> hideDialogError())
                .subscribe(ingredients -> updater.updateSandwich(sandwich, ingredients));

        DisposableManager.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManager.dispose();
    }

    private void onReceiveSandwiches(List<Sandwich> sandwiches) {
        updater.initUpdater(sandwiches);
        sandwichesDescriptorLiveData.setValue(updater.getSandwichDescriptions());
    }

}
