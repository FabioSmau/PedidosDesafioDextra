package com.desafio.dextra.data.model.promotions.chain;

import com.desafio.dextra.data.model.sandwich.Sandwich;

public class DiscountPromotionChain implements PricePromotionChain {

    private PricePromotionChain next;

    @Override
    public void setNext(PricePromotionChain itemChain) {
        this.next = itemChain;
    }

    @Override
    public double getPriceWithDiscount(double priceDefault, Sandwich sandwich) {
        if (next != null){
            next.getPriceWithDiscount(priceDefault, sandwich);
        }
        return priceDefault;
    }


}
