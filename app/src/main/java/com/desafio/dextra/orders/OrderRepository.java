package com.desafio.dextra.orders;

import com.desafio.dextra.data.model.order.Order;
import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;

public interface OrderRepository {

    Single<Order> addSandwichToCart(Sandwich sandwich);

    Single<List<Order>> getAllOrders();
}
