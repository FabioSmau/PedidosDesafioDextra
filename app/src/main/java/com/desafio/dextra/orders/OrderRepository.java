package com.desafio.dextra.orders;

import com.desafio.dextra.data.model.sandwich.Sandwich;

import io.reactivex.Single;

public interface OrderRepository {

    Single<Boolean> addOrderToCart(Sandwich sandwich);


}
