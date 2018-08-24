package com.desafio.dextra.data.model.ingredient;

public enum IngredientsPromotionEnum {
    LETTUCE(1),
    BACON(2),
    HAMBURGUER(3),
    CHEESE(5),
    UNKNOWN(0);

    private int id;

    IngredientsPromotionEnum(int id) {
        this.id = id;
    }

    public static IngredientsPromotionEnum fromId(int id) {
        for (IngredientsPromotionEnum item : values()) {
            if (item.id == id) {
                return item;
            }
        }
        return UNKNOWN;
    }
}
