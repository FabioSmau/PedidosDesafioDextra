package com.desafio.dextra.promotion;

import com.desafio.dextra.data.model.promotions.Promotion;

import java.util.List;

import io.reactivex.Single;

public class PromotionCacheRepository implements PromotionRepository {

    private PromotionRepository repository = new PromotionRemoteRepository();
    private Single<List<Promotion>> promotionsCache;

    @Override
    public Single<List<Promotion>> getPromotions() {
        Single<List<Promotion>> promotions = repository.getPromotions();

        if (promotionsCache == null) {
            promotionsCache = promotions.cache();
        }

        return promotionsCache;
    }

}
