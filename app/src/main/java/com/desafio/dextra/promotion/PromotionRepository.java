package com.desafio.dextra.promotion;

import com.desafio.dextra.data.model.promotions.Promotion;

import java.util.List;

import io.reactivex.Single;

public interface PromotionRepository {

    Single<List<Promotion>> getPromotions();

}
