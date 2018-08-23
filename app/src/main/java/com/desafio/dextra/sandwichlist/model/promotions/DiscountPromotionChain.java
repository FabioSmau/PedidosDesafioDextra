package com.desafio.dextra.sandwichlist.model.promotions;

import com.desafio.dextra.sandwichlist.model.ingredient.Ingredient;

import java.util.List;

public class DiscountPromotionChain implements PricePromotionChain {

    private PricePromotionChain next;


    @Override
    public void setNext(PricePromotionChain itemChain) {
        this.next = itemChain;
    }

    @Override
    public double getPriceWithDiscount(double priceDefault, List<Ingredient> ingredients) {
        if (next != null){
            next.getPriceWithDiscount(priceDefault, ingredients);
        }
        return priceDefault;
    }


}
