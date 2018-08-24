package com.desafio.dextra.data.model.promotions;

public class PromotionModel implements Promotion {

    private int id;
    private String name;
    private String description;

    public PromotionModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    public String getDescription() {
        return description;
    }

    public static Promotion valueOf(PromotionDto promotionDto) {
        return new PromotionModel(
                promotionDto.getId(),
                promotionDto.getName(),
                promotionDto.getDescription()
        );
    }
}
