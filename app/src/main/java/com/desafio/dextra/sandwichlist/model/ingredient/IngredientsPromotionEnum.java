package com.desafio.dextra.sandwichlist.model.ingredient;


/**
 * {
 * "id": 1,
 * "name": "Alface",
 * "price": 0.4,
 * "image": "https://goo.gl/9DhCgk"
 * },
 * {
 * "id": 2,
 * "name": "Bacon",
 * "price": 2,
 * "image": "https://goo.gl/8qkVH0"
 * },
 * {
 * "id": 3,
 * "name": "Hamburguer de Carne",
 * "price": 3,
 * "image": "https://goo.gl/U01SnT"
 * },
 * {
 * "id": 4,
 * "name": "Ovo",
 * "price": 0.8,
 * "image": "https://goo.gl/weL1Rj"
 * },
 * {
 * "id": 5,
 * "name": "Queijo",
 * "price": 1.5,
 * "image": "https://goo.gl/D69Ow2"
 * },
 * {
 * "id": 6,
 * "name": "Pão com gergelim",
 * "price": 1,
 * "image": "https://goo.gl/evgjyj"
 * }
 * ]
 */
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
