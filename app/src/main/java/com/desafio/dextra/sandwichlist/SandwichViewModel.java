package com.desafio.dextra.sandwichlist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.desafio.dextra.commom.SingleLiveEvent;
import com.desafio.dextra.commom.base.viewmodel.BaseServiceViewModel;
import com.desafio.dextra.data.DisposableManager;
import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.recyclerview.SandwichDescription;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class SandwichViewModel extends BaseServiceViewModel {

    private MutableLiveData<List<SandwichDescription>> sandwichesDescriptorLiveData = new MutableLiveData<>();
    private SandwichDataManager updater = new SandwichDataManager();
    private SandwichRepository repository = new SandwichCacheRepository();

    public MutableLiveData<List<SandwichDescription>> getSandwichesDescriptorLiveData() {
        return sandwichesDescriptorLiveData;
    }

    public void start() {
        getSandwiches();
    }

    private void getSandwiches() {
//        if (sandwichesDescriptorLiveData.getValue() == null) {
            Single<List<Sandwich>> single = repository.getSandwichs();

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
//        }
    }

    private void getIngredients(List<Sandwich> sandwiches) {
        for (Sandwich sandwich : sandwiches) {
            getIngredientsOfSandwich(sandwich);
        }
    }

    private void getIngredientsOfSandwich(Sandwich sandwich) {
        Single<List<Ingredient>> single = repository.getIngredientsOfSandwich(sandwich);

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
