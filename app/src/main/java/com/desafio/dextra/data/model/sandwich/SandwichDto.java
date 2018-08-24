package com.desafio.dextra.data.model.sandwich;

import java.io.Serializable;
import java.util.List;


public class SandwichDto implements Serializable {

    private int id;
    private String name;
    private List<Integer> ingredients;
    private String image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getIngredients() {
        return ingredients;
    }

    public String getImage() {
        return image;
    }
}
