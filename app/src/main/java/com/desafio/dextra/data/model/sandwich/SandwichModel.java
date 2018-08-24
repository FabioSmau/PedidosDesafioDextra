package com.desafio.dextra.data.model.sandwich;

import com.desafio.dextra.data.model.ingredient.Ingredient;
import com.desafio.dextra.data.model.ingredient.IngredientsPromotionEnum;
import com.desafio.dextra.data.model.promotions.DiscountPromotionChain;
import com.desafio.dextra.data.model.promotions.LightPromotion;
import com.desafio.dextra.data.model.promotions.LotOfPromotion;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SandwichModel implements Sandwich {

    private int id;
    private String name;
    private List<Integer> ingredientsIdentifiers;
    private List<Ingredient> ingredients;
    private String image;


    private SandwichModel(int id, String name, List<Integer> ingredientsIdentifiers, List<Ingredient> ingredients, String image) {
        this.id = id;
        this.name = name;
        this.ingredientsIdentifiers = ingredientsIdentifiers;
        this.ingredients = ingredients;
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
        return ingredients;
    }

    @Override
    public List<String> getIngredientsName() {
        List<String> names = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            names.add(ingredient.getName());
        }
        return names;
    }

    @Override
    public List<Integer> getIngredientsIdentifiers() {
        return ingredientsIdentifiers;
    }

    @Override
    public String getImageUrl() {
        return image;
    }

    @Override
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
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
        for (Ingredient ingredient : ingredients) {
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
                sandwichDto.getIngredients(),
                new ArrayList<>(),
                sandwichDto.getImage()
        );
    }
}
