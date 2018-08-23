package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.sandwichlist.model.ingredient.IngredientDto;
import com.desafio.dextra.sandwichlist.model.organizer.SandwichManagerImpl;
import com.desafio.dextra.sandwichlist.model.organizer.SandwichManager;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichModel;

import java.util.ArrayList;
import java.util.List;

public class SandwichPresenter implements SandwichListContract.Presenter, SandwichListContract.InteractorOutput {

    private SandwichListContract.View view;
    private SandwichManager sandwichManager = new SandwichManagerImpl();
    private SandwichListContract.Interactor interactor = SandwichInteractor.newInstanceWithOutput(this);

    public static SandwichListContract.Presenter newInstance() {
        return new SandwichPresenter();
    }

    @Override
    public void start(SandwichListContract.View view) {
        this.view = view;
        this.interactor.requestSandwiches();
    }

    @Override
    public void sendButtonClicked() {

    }


    @Override
    public void stop() {
        interactor.disposeAll();
        this.view = null;
    }

    @Override
    public void onGetSandwichesWithSuccess(List<SandwichDto> sandwiches) {
        view.hideLoading();

        sandwichManager.addSandwiches(sandwiches);
        view.addSandwiches(sandwichManager.getSandwichs());

        requestIngredients(sandwiches);
    }


    private void requestIngredients(List<SandwichDto> sandwiches) {
        for (SandwichDto dto : sandwiches){
            interactor.requestIngredients(dto.getId());
        }
    }

    @Override
    public void onGetSandwichesWithError(Throwable throwable) {
        view.hideLoading();
        view.showDialog(throwable.getMessage());
    }

    @Override
    public void onGetIngredientsWithSuccess(int idSandwich, List<IngredientDto> ingredient) {
        Sandwich sandwich = sandwichManager.addIngredientsToSandwich(idSandwich, ingredient);
        if (sandwich != null)
            view.updateSandwich(sandwich);
    }

    @Override
    public void onGetIngredientsWithError(Throwable throwable) {
        view.hideLoading();
        view.showDialog(throwable.getMessage());
    }
}
