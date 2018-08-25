package com.desafio.dextra.data.model.promotions.chain;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientsPromotionEnum;
import com.desafio.dextra.data.model.sandwich.Sandwich;

public class LotOfPromotion extends DiscountPromotionChain {

    private static final int MININUM_AMOUNT = 3;
    private IngredientsPromotionEnum type;

    public LotOfPromotion(IngredientsPromotionEnum type) {
        this.type = type;
    }

    @Override
    public double getPriceWithDiscount(double priceDefault, Sandwich sandwich) {

        if (containsLotOfType(sandwich)) {
            priceDefault = priceDefault - getDiscount(sandwich);
            super.getPriceWithDiscount(priceDefault, sandwich);
        }

        return super.getPriceWithDiscount(priceDefault, sandwich);
    }

    private boolean containsLotOfType(Sandwich sandwich) {
        if (sandwich.containsIngredient(type.getId())) {
            Ingredient ingredient = sandwich.getIngredient(type.getId());
            return ingredient.getAmount() >= MININUM_AMOUNT;
        }
        return false;
    }

    private double getDiscount(Sandwich sandwich) {
        Ingredient ingredient = sandwich.getIngredient(type.getId());
        int amount = ingredient.getAmount();
        int discountedCount = Math.round(amount / 3);
        return discountedCount * ingredient.getPriceUnit();
    }
}
