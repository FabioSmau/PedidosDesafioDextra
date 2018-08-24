package com.desafio.dextra.data.model.promotions;

import com.desafio.dextra.data.model.ingredient.Ingredient;

import java.util.List;

public interface PricePromotionChain {

    void setNext(PricePromotionChain itemChain);
    double getPriceWithDiscount(double priceDefault, List<Ingredient> ingredients);

}
