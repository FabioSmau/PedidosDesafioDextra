package com.desafio.dextra.data.model.promotions.chain;

import com.desafio.dextra.data.model.ingredient.IngredientsPromotionEnum;
import com.desafio.dextra.data.model.sandwich.Sandwich;

public class LightPromotion extends DiscountPromotionChain {

    @Override
    public double getPriceWithDiscount(double priceDefault, Sandwich sandwich) {

        boolean containsLettuce = sandwich.containsIngredient(IngredientsPromotionEnum.LETTUCE.getId());
        boolean notContainsBacon = !sandwich.containsIngredient(IngredientsPromotionEnum.BACON.getId());

        //se cair na regra, aplica 10% de desconto
        if (containsLettuce && notContainsBacon) {
            priceDefault = priceDefault * 0.9;
            return super.getPriceWithDiscount(priceDefault, sandwich);
        }

        return super.getPriceWithDiscount(priceDefault, sandwich);
    }
}
