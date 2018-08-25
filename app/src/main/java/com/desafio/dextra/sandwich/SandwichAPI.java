package com.desafio.dextra.sandwich;

import com.desafio.dextra.data.model.sandwich.SandwichDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SandwichAPI {

    @GET("api/lanche")
    Single<List<SandwichDto>> getSandwichesList();

    @GET("api/lanche/{id}")
    Single<SandwichDto> getSandwich(@Path("id") int id);

}
