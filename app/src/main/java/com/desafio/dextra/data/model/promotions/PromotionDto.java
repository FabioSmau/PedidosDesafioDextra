package com.desafio.dextra.data.model.promotions;


/**
 * * {
 * "id": 1,
 * "name": "Light",
 * "description": "Se o lanche tem alface e não tem bacon, ganha 10% de desconto."
 * },
 */
public class PromotionDto {

    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
