package com.desafio.dextra.data.model.promotions;

/**
 * {
 "id": 1,
 "name": "Light",
 "description": "Se o lanche tem alface e não tem bacon, ganha 10% de desconto."
 },
 */
public interface Promotion {
    int getId();
    String getName();
    String getDescription();
}
