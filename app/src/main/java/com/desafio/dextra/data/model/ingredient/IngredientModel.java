package com.desafio.dextra.data.model.ingredient;

import java.text.NumberFormat;
import java.util.Locale;

public class IngredientModel implements Ingredient {

    private int id;
    private int amount = 1;
    private String name;
    private double price;
    private String image;

    public IngredientModel(int id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void addAmount() {
        this.amount++;
    }

    @Override
    public void addAmount(int amount) {
        this.amount = this.amount + amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price * amount;
    }

    @Override
    public double getPriceUnit() {
        return price;
    }

    @Override
    public String getPriceUnitFormatted() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
        return currencyFormatter.format(getPriceUnit());
    }

    @Override
    public String getImageUrl() {
        return image;
    }

    @Override
    public boolean equals(int id) {
        return getId() == id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Ingredient)) {
            return false;
        }

        Ingredient ingredient = (Ingredient) obj;
        return getId() == ingredient.getId();
    }

    public static Ingredient valueOf(IngredientDto dto) {
        return new IngredientModel(dto.getId(), dto.getName(), dto.getPrice(), dto.getImage());
    }


    public static Ingredient clone(Ingredient ingredient){
        Ingredient clone = new IngredientModel(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getPriceUnit(),
                ingredient.getImageUrl()
        );
        clone.setAmount(ingredient.getAmount());
        return clone;
    }
}
