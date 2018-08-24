package com.desafio.dextra.promotion;

import com.desafio.dextra.data.model.promotions.PromotionDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PromotionAPI {

    @GET("api/promocao")
    Single<List<PromotionDto>> getPromotionsList();

}
