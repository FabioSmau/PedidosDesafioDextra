package com.desafio.dextra.sandwichlist.model.promotions;

import com.desafio.dextra.sandwichlist.model.ingredient.Ingredient;

import java.util.List;

public interface PricePromotionChain {

    void setNext(PricePromotionChain itemChain);
    double getPriceWithDiscount(double priceDefault, List<Ingredient> ingredients);

}
