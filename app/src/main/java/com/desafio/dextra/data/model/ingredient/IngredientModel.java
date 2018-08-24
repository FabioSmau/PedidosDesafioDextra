package com.desafio.dextra.data.model.ingredient;

public class IngredientModel implements Ingredient {

    private int id;
    private String name;
    private double price;
    private String image;

    private IngredientModel(int id, String name, double price, String image) {
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
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getImageUrl() {
        return image;
    }

    public static Ingredient valueOf(IngredientDto dto){
        return new IngredientModel(dto.getId(), dto.getName(), dto.getPrice(), dto.getImage());
    }
}
