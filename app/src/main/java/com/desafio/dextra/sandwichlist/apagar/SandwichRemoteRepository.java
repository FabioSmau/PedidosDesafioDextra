package com.desafio.dextra.sandwichlist.apagar;

import com.desafio.dextra.remote.RetrofitSingleton;
import com.desafio.dextra.sandwichlist.SandwishAPI;
import com.desafio.dextra.sandwichlist.model.sandwich.Sandwich;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichDto;
import com.desafio.dextra.sandwichlist.model.sandwich.SandwichModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SandwichRemoteRepository implements SandwichRepository {

    @Override
    public Single<List<Sandwich>> getSandwichs() {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        SandwishAPI sandwishAPI = retrofit.create(SandwishAPI.class);

        return sandwishAPI.getSandwichsList()
                .subscribeOn(Schedulers.io())
                .map(this::convertModels)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private List<Sandwich> convertModels(List<SandwichDto> sandwichDtos) {
        List<Sandwich> sandwiches = new ArrayList<>();
        for (SandwichDto dto : sandwichDtos) {
            sandwiches.add(SandwichModel.valueOf(dto));
        }
        return sandwiches;
    }

}
