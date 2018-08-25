package com.desafio.dextra.orders;

import com.desafio.dextra.data.model.order.Order;
import com.desafio.dextra.data.model.order.OrderModel;
import com.desafio.dextra.data.model.order.OrdersConverter;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.data.remote.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class OrderRemoteRepository implements OrderRepository {

    private Retrofit retrofit = RetrofitSingleton.getInstance();
    private OrderAPI orderAPI = retrofit.create(OrderAPI.class);


    @Override
    public Single<Order> addSandwichToCart(Sandwich sandwich) {
        //todo Implementar os IDS extras

        return orderAPI.addSandwichToCart(sandwich.getId(), new ArrayList<>())
                .subscribeOn(Schedulers.io())
                .map(OrderModel::valueOf)
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<List<Order>> getAllOrders() {
        return orderAPI.getAllOrders()
                .subscribeOn(Schedulers.io())
                .map(orderDtos -> new OrdersConverter().convert(orderDtos))
                .observeOn(AndroidSchedulers.mainThread());
    }

}
