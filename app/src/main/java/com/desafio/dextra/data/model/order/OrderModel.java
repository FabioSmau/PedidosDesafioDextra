package com.desafio.dextra.data.model.order;

import com.desafio.dextra.data.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class OrderModel implements Order {

    private int id;
    private int inSandwich;
    private List<Integer> extras;
    private long date;

    public OrderModel(int id, int inSandwich, long date) {
        this.id = id;
        this.inSandwich = inSandwich;
        this.extras = new ArrayList<>();
        this.date = date;
    }

    public OrderModel(int id, int inSandwich, List<Integer> extras, long date) {
        this.id = id;
        this.inSandwich = inSandwich;
        this.extras = extras;
        this.date = date;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getInSandwich() {
        return 0;
    }

    @Override
    public List<Integer> getExtras() {
        return null;
    }

    @Override
    public long getDate() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Order)) {
            return false;
        }

        Order order = (Order) obj;
        return getId() == order.getId();
    }

    public static Order valueOf(OrderDto dto){
        return new OrderModel(dto.getId(), dto.getInSandwich(), dto.getExtras(), dto.getDate());
    }
}
