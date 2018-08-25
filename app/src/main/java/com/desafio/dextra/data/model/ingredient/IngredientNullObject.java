package com.desafio.dextra.data.model.ingredient;

public class IngredientNullObject implements Ingredient {
    @Override
    public int getId() {
        return -1;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public void addAmount() {

    }

    @Override
    public void addAmount(int amount) {

    }

    @Override
    public void setAmount(int amout) {

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getPriceUnit() {
        return 0;
    }

    @Override
    public String getPriceUnitFormatted() {
        return "";
    }

    @Override
    public String getImageUrl() {
        return "";
    }

    @Override
    public boolean equals(int id) {
        return false;
    }
}
