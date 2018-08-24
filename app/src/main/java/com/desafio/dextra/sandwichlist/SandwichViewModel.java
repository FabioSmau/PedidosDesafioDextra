package com.desafio.dextra.sandwichlist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.desafio.dextra.commom.SingleLiveEvent;
import com.desafio.dextra.data.DisposableManager;
import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.recyclerview.SandwichDescription;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class SandwichViewModel extends ViewModel {

    private SingleLiveEvent<Boolean> loadingState = new SingleLiveEvent<>();
    private SingleLiveEvent<Throwable> errorState = new SingleLiveEvent<>();
    private MutableLiveData<List<SandwichDescription>> sandwichesDescriptorLiveData = new MutableLiveData<>();

    private SandwichDataManager updater = new SandwichDataManager();
    private SandwichRepository repository = new SandwichRemoteRepository();

//    public SandwichViewModel() {
//        this.loadingState.setValue(false);
//        this.errorState.setValue(null);
//    }

    public MutableLiveData<List<SandwichDescription>> getSandwichesDescriptorLiveData() {
        return sandwichesDescriptorLiveData;
    }

    public void start() {
        getSandwiches();
    }

    private void getSandwiches() {
        if (sandwichesDescriptorLiveData.getValue() == null) {
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
        }
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
                .subscribe(
                        ingredients -> updater.updateSandwich(sandwich, ingredients)
                );
        DisposableManager.add(disposable);
    }


    public SingleLiveEvent<Boolean> getLoadingState() {
        return loadingState;
    }

    public SingleLiveEvent<Throwable> getErrorState() {
        return errorState;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManager.dispose();
    }

    private void showProgress() {
        loadingState.setValue(true);
    }

    private void hideProgress() {
        loadingState.setValue(false);
    }

    private void showDialogError(Throwable error) {
        errorState.setValue(error);
    }

    private void hideDialogError() {
        errorState.setValue(null);
    }

    private void onReceiveSandwiches(List<Sandwich> sandwiches) {
        updater.initUpdater(sandwiches);
        sandwichesDescriptorLiveData.setValue(updater.getSandwichDescriptions());
    }


}
