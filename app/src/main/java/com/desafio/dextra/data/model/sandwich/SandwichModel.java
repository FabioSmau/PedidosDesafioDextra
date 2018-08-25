package com.desafio.dextra.data.model.sandwich;

import android.annotation.SuppressLint;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientModel;
import com.desafio.dextra.data.model.ingredient.IngredientNullObject;
import com.desafio.dextra.data.model.promotions.strategy.ChainOfPromotionsStrategy;
import com.desafio.dextra.data.model.promotions.strategy.DiscountStrategy;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

public class SandwichModel implements Sandwich {

    private int id;
    private String name;
    private String image;

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, Ingredient> ingredients = new HashMap<>();

    public SandwichModel(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients.values());
    }

    @Override
    public List<String> getIngredientsName() {
        HashSet<String> names = new LinkedHashSet<>();
        for (Ingredient ingredient : getIngredients()) {
            names.add(ingredient.getName());
        }
        return new ArrayList<>(names);
    }

    @Override
    public void clearAllIngredients() {
        this.ingredients.clear();
    }

    @Override
    public String getImageUrl() {
        return image;
    }

    @Override
    public void addIngredients(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            addIngredient(ingredient);
        }
    }


    @Override
    public void addIngredient(Ingredient ingredient) {
        if (ingredient.getAmount() == 0) return;
        if (ingredients.containsKey(ingredient.getId())) {
            Ingredient ingredientFromHash = ingredients.get(ingredient.getId());
            ingredientFromHash.addAmount(ingredient.getAmount());
        } else {
            ingredients.put(ingredient.getId(), ingredient);
        }
    }


    @Override
    public String getPriceWithPromotionFormatted() {
        double price = getTotalPriceWithPromotion(new ChainOfPromotionsStrategy(this));

        if (price > 0) {
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
            return currencyFormatter.format(price);
        }

        return "";
    }

    @Override
    public double getTotalPriceWithPromotion(DiscountStrategy strategy) {
        //strategy, caso tenham outros tipos de promocoes podemos implementar de formas diferentes
        //e usar um factory de strategy para calcular o preco
        double priceWithoutPromotions = getTotalPriceWithoutPromotion();
        return strategy.getPrice(priceWithoutPromotions);
    }

    @Override
    public double getTotalPriceWithoutPromotion() {
        double priceWithoutPromotions = 0;
        for (Ingredient ingredient : getIngredients()) {
            priceWithoutPromotions += ingredient.getPrice();
        }
        return priceWithoutPromotions;
    }

    @Override
    public boolean containsIngredient(int id) {
        return ingredients.containsKey(id);
    }

    @Override
    public Ingredient getIngredient(int id) {
        if (containsIngredient(id)) {
            return ingredients.get(id);
        }
        return new IngredientNullObject();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Sandwich)) {
            return false;
        }

        Sandwich sandwich = (Sandwich) obj;
        return getId() == sandwich.getId();
    }


    public static Sandwich valueOf(SandwichDto sandwichDto) {
        return new SandwichModel(
                sandwichDto.getId(),
                sandwichDto.getName(),
                sandwichDto.getImage()
        );
    }
}
