package com.desafio.dextra.sandwichlist;

import com.desafio.dextra.remote.DisposableManager;
import com.desafio.dextra.remote.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SandwichRemoteRepository implements SandwichRepository {

    private SandwichListContract.InteractorOutput output;
    private Retrofit retrofit = RetrofitSingleton.getInstance();

    public static SandwichRepository newInstanceWithOutput(SandwichListContract.InteractorOutput output) {
        return new SandwichRemoteRepository(output);
    }

    private SandwichRemoteRepository(SandwichListContract.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void requestSandwichs() {
        SandwishAPI api = retrofit.create(SandwishAPI.class);

        Disposable disposable = api.getSandwichs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sandwichs -> output.onGetSandwichesWithSuccess(sandwichs),
                        throwable -> output.onGetSandwichesWithError(throwable)
                );

        DisposableManager.add(disposable);
    }

    @Override
    public void requestIngredients(int id) {
        SandwishAPI api = retrofit.create(SandwishAPI.class);

        Disposable disposable = api.getIngredientOfSandwich(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        ingredients -> output.onGetIngredientsWithSuccess(id, ingredients),
                        throwable -> output.onGetSandwichesWithError(throwable)
                );

        DisposableManager.add(disposable);
    }
}
