package com.desafio.dextra.sandwichlist.apagar;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.desafio.dextra.remote.DisposableManager;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class SandwichViewModel extends ViewModel {

    private MutableLiveData<List<Sandwich>> sandwichesLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingState = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorState = new MutableLiveData<>();

    private SandwichRepository repository = new SandwichRemoteRepository();

    public SandwichViewModel() {
        this.loadingState.setValue(false);
        this.errorState.setValue(null);
    }

    public MutableLiveData<List<Sandwich>> getSandwichesLiveData() {
        return sandwichesLiveData;
    }

    public void start() {
        getSandwiches();
    }

    public void getSandwiches() {
        if (sandwichesLiveData.getValue() == null) {
            Single<List<Sandwich>> single = repository.getSandwichs();

            Disposable disposable = single
                    .doOnSubscribe(disposable1 -> loadingState.setValue(true))
                    .doOnSubscribe(disposable12 -> errorState.setValue(null))
                    .doAfterTerminate(() -> loadingState.setValue(false))
                    .subscribe(
                            sandwichesLiveData::setValue,
                            errorState::setValue
                    );
            DisposableManager.add(disposable);
        }
    }


    public MutableLiveData<Boolean> getLoadingState() {
        return loadingState;
    }

    public MutableLiveData<Throwable> getErrorState() {
        return errorState;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManager.dispose();
    }
}
