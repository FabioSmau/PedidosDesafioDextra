package com.desafio.dextra.data.model.ingredient;

import java.io.Serializable;

public interface Ingredient extends Serializable {

    int getId();
    int getAmount();
    void addAmount();
    void addAmount(int amount);
    void setAmount(int amount);
    String getName();
    double getPrice();
    double getPriceUnit();
    String getPriceUnitFormatted();
    String getImageUrl();
    boolean equals(int id);

}
