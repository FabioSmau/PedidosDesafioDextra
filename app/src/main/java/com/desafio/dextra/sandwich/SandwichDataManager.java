package com.desafio.dextra.sandwich;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.sandwich.Sandwich;
import com.desafio.dextra.sandwich.recyclerview.SandwichDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SandwichDataManager {

    private HashMap<Sandwich, SandwichDescription> sandwichesMap = new HashMap<>();

    public void initUpdater(List<Sandwich> sandwiches) {
        for (Sandwich sandwich : sandwiches) {
            sandwich.clearAllIngredients();
            sandwichesMap.put(sandwich, SandwichDescription.valueOf(sandwich));
        }
    }

    public List<SandwichDescription> getSandwichDescriptions() {
        return new ArrayList<>(sandwichesMap.values());
    }

    public void updateSandwich(Sandwich sandwich, List<Ingredient> ingredients) {
        if (sandwichesMap.containsKey(sandwich)) {
            sandwich.addIngredients(ingredients);
            updateSandwichDescription(sandwich);
        }
    }


    private void updateSandwichDescription(Sandwich sandwich) {
        SandwichDescription description = sandwichesMap.get(sandwich);
        description.setPrice(sandwich.getPriceWithPromotionFormatted());
        description.setIngredients(sandwich.getIngredientsName());
    }

}
