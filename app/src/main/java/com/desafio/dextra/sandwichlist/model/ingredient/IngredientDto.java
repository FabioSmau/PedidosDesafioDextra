package com.desafio.dextra.sandwichlist.model.ingredient;

import java.io.Serializable;

public class IngredientDto implements Serializable {

    private int id;
    private String name;
    private double price;
    private String image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
