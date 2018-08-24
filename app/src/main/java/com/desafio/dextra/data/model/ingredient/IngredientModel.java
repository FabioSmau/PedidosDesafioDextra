package com.desafio.dextra.data.model.ingredient;

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
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price * amount;
    }

    @Override
    public String getImageUrl() {
        return image;
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
}
