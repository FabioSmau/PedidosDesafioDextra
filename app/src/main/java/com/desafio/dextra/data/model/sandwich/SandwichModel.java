package com.desafio.dextra.data.model.sandwich;

import android.annotation.SuppressLint;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientsPromotionEnum;
import com.desafio.dextra.data.model.promotions.DiscountPromotionChain;
import com.desafio.dextra.data.model.promotions.LightPromotion;
import com.desafio.dextra.data.model.promotions.LotOfPromotion;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
        List<String> names = new ArrayList<>();
        for (Ingredient ingredient : getIngredients()) {
            names.add(ingredient.getName());
        }
        return names;
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
        if (ingredients.containsKey(ingredient.getId())) {
            Ingredient ingredientFromHash = ingredients.get(ingredient.getId());
            ingredientFromHash.addAmount();
        } else {
            ingredients.put(ingredient.getId(), ingredient);
        }
    }


    @Override
    public String getPriceWithPromotionFormatted() {
        double price = getTotalPriceWithPromotion();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
        return currencyFormatter.format(price);
    }

    @Override
    public double getTotalPriceWithPromotion() {
        double priceWithoutPromotions = getTotalPriceWithoutPromotion();
        return getPriceApplyingChainPromotion(priceWithoutPromotions);
    }

    @Override
    public double getTotalPriceWithoutPromotion() {
        double priceWithoutPromotions = 0;
        for (Ingredient ingredient : getIngredients()) {
            priceWithoutPromotions += ingredient.getPrice();
        }
        return priceWithoutPromotions;
    }

    private double getPriceApplyingChainPromotion(double price) {
        DiscountPromotionChain lightPromotion = new LightPromotion();
        DiscountPromotionChain lotOfCheese = new LotOfPromotion(IngredientsPromotionEnum.CHEESE);
        DiscountPromotionChain lotOfHamburguer = new LotOfPromotion(IngredientsPromotionEnum.HAMBURGUER);

        lightPromotion.setNext(lotOfCheese);
        lotOfCheese.setNext(lotOfHamburguer);

        return lightPromotion.getPriceWithDiscount(price, getIngredients());
    }

    public static Sandwich valueOf(SandwichDto sandwichDto) {
        return new SandwichModel(
                sandwichDto.getId(),
                sandwichDto.getName(),
                sandwichDto.getImage()
        );
    }
}
