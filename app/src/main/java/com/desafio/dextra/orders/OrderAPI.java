package com.desafio.dextra.orders;

import com.desafio.dextra.data.model.order.OrderDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrderAPI {

    @PUT("api/pedido/{idSandwich}")
    Single<OrderDto> addSandwichToCart(@Path("idSandwich") int idSandwich);

    @PUT("api/pedido/{idSandwich}")
    Single<OrderDto> addSandwichToCart(@Path("idSandwich") int idSandwich, @Field("extras[]") List<Integer> extras);

    @GET("api/pedido")
    Single<List<OrderDto>> getAllOrders();

}
