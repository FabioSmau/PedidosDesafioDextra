package com.desafio.dextra.sandwichlist.model.sandwich;

import android.util.Log;

import com.desafio.dextra.sandwichlist.model.ingredient.Ingredient;
import com.desafio.dextra.sandwichlist.model.promotions.DiscountPromotionChain;
import com.desafio.dextra.sandwichlist.model.promotions.LightPromotion;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> getIngredientsIdentifiers() {
        return null;
    }

    @Override
    public String getImageUrl() {
        return image;
    }

    @Override
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;

        double price = calculatePrice();
        Log.i("SANDWICH: ", getName() + "Preço Após desconto: " + price);
    }

    @Override
    public double calculatePrice() {
        double priceWithoutPromotions = 0;
        for (Ingredient ingredient : ingredients){
            priceWithoutPromotions += ingredient.getPrice();
        }

        Log.i("SANDWICH: ", getName() + "Preço: " + priceWithoutPromotions);

        return getPriceApplyingChainPromotion(priceWithoutPromotions);
    }

    private double getPriceApplyingChainPromotion(double price){
        DiscountPromotionChain lightPromotion = new LightPromotion();
        DiscountPromotionChain lotOfCheese = new LightPromotion();
        DiscountPromotionChain lotOfHamburguer = new LightPromotion();

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
