package com.desafio.dextra.data.model.promotions;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientsPromotionEnum;

import java.util.List;

public class LightPromotion extends DiscountPromotionChain {

    @Override
    public double getPriceWithDiscount(double priceDefault, List<Ingredient> ingredients) {
        boolean containsLettuce = containsLettuce(ingredients);
        boolean notContainsBacon = notContainsBacon(ingredients);

        //se cair na regra, aplica 10% de desconto
        if (containsLettuce && notContainsBacon) {
            return priceDefault * 0.9;
        }

        return super.getPriceWithDiscount(priceDefault, ingredients);
    }

    private boolean containsLettuce(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            if (IngredientsPromotionEnum.fromId(ingredient.getId()).equals(IngredientsPromotionEnum.LETTUCE)) {
                return true;
            }
        }
        return false;
    }

    private boolean notContainsBacon(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            if (IngredientsPromotionEnum.fromId(ingredient.getId()).equals(IngredientsPromotionEnum.BACON)) {
                return false;
            }
        }
        return true;
    }
}
