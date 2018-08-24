package com.desafio.dextra.data.model.promotions;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientEmpty;
import com.desafio.dextra.data.model.ingredient.IngredientsPromotionEnum;

import java.util.List;

public class LotOfPromotion extends DiscountPromotionChain {

    private IngredientsPromotionEnum type;

    public LotOfPromotion(IngredientsPromotionEnum type) {
        this.type = type;
    }

    @Override
    public double getPriceWithDiscount(double priceDefault, List<Ingredient> ingredients) {

        if (containsLotOfType(ingredients)) {
            return priceDefault - getDiscount(ingredients);
        }

        return super.getPriceWithDiscount(priceDefault, ingredients);
    }

    private int countIngredients(List<Ingredient> ingredients) {
        int count = 0;
        for (Ingredient ingredient : ingredients) {
            if (IngredientsPromotionEnum.fromId(ingredient.getId()).equals(type)) {
                count++;
            }
        }
        return count;
    }

    private Ingredient getIngredientByType(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            if (IngredientsPromotionEnum.fromId(ingredient.getId()).equals(type)) {
                return ingredient;
            }
        }
        return new IngredientEmpty();
    }

    private boolean containsLotOfType(List<Ingredient> ingredients) {
        int cheeseCount = countIngredients(ingredients);
        return cheeseCount >= 3;
    }


    private double getDiscount(List<Ingredient> ingredients) {
        int count = countIngredients(ingredients);

        if (count >= 3) {
            int discounted = Math.round(count / 3);

            Ingredient ingredient = getIngredientByType(ingredients);
            return ingredient.getPrice() * discounted;
        }
        return 0;
    }

}
