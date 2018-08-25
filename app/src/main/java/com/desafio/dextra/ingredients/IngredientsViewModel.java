package com.desafio.dextra.ingredients;

import android.arch.lifecycle.MutableLiveData;

import com.desafio.dextra.commom.base.viewmodel.BaseServiceViewModel;
import com.desafio.dextra.data.DisposableManager;
import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.ingredients.recyclerview.IngredientDescription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class IngredientsViewModel extends BaseServiceViewModel {

    private MutableLiveData<List<IngredientDescription>> ingredientsDescriptorLiveData = new MutableLiveData<>();
    private IngredientDataManager ingredientsAmountController = new IngredientDataManager();

    private IngredientsRepository repository = new IngredientsCacheRepository();

    public MutableLiveData<List<IngredientDescription>> listIngredients() {
        return ingredientsDescriptorLiveData;
    }

    public void start() {
        loadAllIngredients();
    }

    private void loadAllIngredients() {
        Single<List<Ingredient>> single = repository.getAllIngredients();

        Disposable disposable = single
                .doOnSubscribe(disposable1 -> showProgress())
                .doOnSubscribe(disposable12 -> hideDialogError())
                .doAfterTerminate(this::hideProgress)
                .subscribe(
                        this::onReceiveIngredients,
                        this::showDialogError
                );

        DisposableManager.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManager.dispose();
    }

    private void onReceiveIngredients(List<Ingredient> ingredients) {
        ingredientsAmountController.initWithIngredients(ingredients);
        updateRecyclerView(ingredientsAmountController.getListIngredientsDescription());
    }

    private void updateRecyclerView(List<IngredientDescription> ingredients) {
        ingredientsDescriptorLiveData.setValue(ingredients);
    }

    public void onUpdateAmountOfIngredient(int amount, int idIngredient) {
        ingredientsAmountController.updateAmountOfIngredient(amount, idIngredient);
    }

    public IngredientResult getIngredientsResult(){
        return new IngredientResult(ingredientsAmountController.getListIngredients());
    }
}
