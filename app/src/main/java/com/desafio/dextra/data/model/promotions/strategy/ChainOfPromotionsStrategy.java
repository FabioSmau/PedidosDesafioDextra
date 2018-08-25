package com.desafio.dextra.data.model.promotions.strategy;

import com.desafio.dextra.data.model.ingredient.IngredientsPromotionEnum;
import com.desafio.dextra.data.model.promotions.chain.DiscountPromotionChain;
import com.desafio.dextra.data.model.promotions.chain.LightPromotion;
import com.desafio.dextra.data.model.promotions.chain.LotOfPromotion;
import com.desafio.dextra.data.model.sandwich.Sandwich;

public class ChainOfPromotionsStrategy implements DiscountStrategy {

    private Sandwich sandwich;

    public ChainOfPromotionsStrategy(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public double getPrice(double priceWithoutPromotion) {
        DiscountPromotionChain lightPromotionChain = new LightPromotion();
        DiscountPromotionChain lotOfCheeseChain = new LotOfPromotion(IngredientsPromotionEnum.CHEESE);
        DiscountPromotionChain lotOfHamburguerChain = new LotOfPromotion(IngredientsPromotionEnum.HAMBURGUER);

        lightPromotionChain.setNext(lotOfCheeseChain);
        lotOfCheeseChain.setNext(lotOfHamburguerChain);
        lotOfHamburguerChain.setNext(null);

        return lightPromotionChain.getPriceWithDiscount(priceWithoutPromotion, sandwich);
    }

}
