package com.desafio.dextra.promotion;

import com.desafio.dextra.data.model.promotions.Promotion;
import com.desafio.dextra.data.model.promotions.PromotionConverter;
import com.desafio.dextra.data.remote.RetrofitSingleton;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PromotionRemoteRepository implements PromotionRepository {

    @Override
    public Single<List<Promotion>> getPromotions() {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        PromotionAPI promtionAPI = retrofit.create(PromotionAPI.class);

        return promtionAPI.getPromotionsList()
                .subscribeOn(Schedulers.io())
                .map(promotions -> new PromotionConverter().convertPromotions(promotions))
                .observeOn(AndroidSchedulers.mainThread());
    }
}
