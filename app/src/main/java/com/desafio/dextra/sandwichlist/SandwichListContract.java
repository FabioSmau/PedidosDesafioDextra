package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.commom.DisposableInteractor;
import com.desafio.dextra.commom.alert.AlertView;
import com.desafio.dextra.commom.loading.LoadableView;
import com.desafio.dextra.mvpcommom.BaseInteractor;
import com.desafio.dextra.mvpcommom.BaseInteractorOutput;
import com.desafio.dextra.mvpcommom.BasePresenter;
import com.desafio.dextra.sandwichlist.model.ingredient.IngredientDto;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;

import java.util.List;

public class SandwichListContract {

    public interface View extends LoadableView, AlertView {
        void addSandwiches(List<Sandwich> sandwiches);
        void updateSandwich(Sandwich sandwich);
    }

    public interface Presenter extends BasePresenter<View> {
        void sendButtonClicked();

    }

    public interface Interactor extends BaseInteractor<InteractorOutput>, DisposableInteractor {
        void requestSandwiches();
        void requestIngredients(int id);
    }

    public interface InteractorOutput extends BaseInteractorOutput<Interactor> {
        void onGetSandwichesWithSuccess(List<SandwichDto> sandwiches);
        void onGetSandwichesWithError(Throwable throwable);

        void onGetIngredientsWithSuccess(int idSandwich, List<IngredientDto> ingredients);
        void onGetIngredientsWithError(Throwable throwable);

    }

}
