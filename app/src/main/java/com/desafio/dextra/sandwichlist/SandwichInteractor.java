package com.desafio.dextra.sandwichlist;


import com.desafio.dextra.remote.DisposableManager;

public class SandwichInteractor implements SandwichListContract.Interactor {

    private SandwichListContract.InteractorOutput output;
    private SandwichRepository remoteRepository;

    public static SandwichListContract.Interactor newInstanceWithOutput(SandwichListContract.InteractorOutput output){
        return new SandwichInteractor(output);
    }

    private SandwichInteractor(SandwichListContract.InteractorOutput output) {
        this.output = output;
        this.remoteRepository = SandwichRemoteRepository.newInstanceWithOutput(output);
    }

    @Override
    public void requestSandwiches() {
        remoteRepository.requestSandwichs();
    }

    @Override
    public void requestIngredients(int id) {
        remoteRepository.requestIngredients(id);
    }

    @Override
    public void disposeAll() {
        DisposableManager.dispose();
    }

}
