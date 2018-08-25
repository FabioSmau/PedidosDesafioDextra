package com.desafio.dextra.orders;

import com.desafio.dextra.data.model.order.Order;
import com.desafio.dextra.data.model.sandwich.Sandwich;

import java.util.List;

import io.reactivex.Single;

//todo Analisar se faz sentido esse cara ter cache.
public class OrderCacheRepository implements OrderRepository {

    private OrderRepository repository = new OrderRemoteRepository();

    @Override
    public Single<Order> addSandwichToCart(Sandwich sandwich) {
        return repository.addSandwichToCart(sandwich);
    }

    @Override
    public Single<List<Order>> getAllOrders() {
        return null;
    }
}
