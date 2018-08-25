package com.desafio.dextra.data.model.order;

import java.util.List;

public interface Order {

    int getId();
    int getInSandwich();
    List<Integer> getExtras();
    long getDate();

}
