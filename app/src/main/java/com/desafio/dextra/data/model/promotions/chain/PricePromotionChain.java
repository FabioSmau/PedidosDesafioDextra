package com.desafio.dextra.data.model.promotions.chain;

import com.desafio.dextra.data.model.sandwich.Sandwich;

public interface PricePromotionChain {

    void setNext(PricePromotionChain itemChain);
    double getPriceWithDiscount(double priceDefault, Sandwich sandwich);

}
