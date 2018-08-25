package com.desafio.dextra.data.model.order;

import java.util.ArrayList;
import java.util.List;

public class OrdersConverter {

    public List<Order> convert(List<OrderDto> orderDtos) {
        List<Order> orders = new ArrayList<>();
        for (OrderDto dto : orderDtos) {
            orders.add(OrderModel.valueOf(dto));
        }
        return orders;
    }

}
