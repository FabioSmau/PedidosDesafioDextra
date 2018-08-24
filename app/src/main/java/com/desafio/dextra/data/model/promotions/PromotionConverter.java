package com.desafio.dextra.data.model.promotions;

import com.desafio.dextra.promotion.recycler.PromotionDescriptor;

import java.util.ArrayList;
import java.util.List;

public class PromotionConverter {

    public List<Promotion> convertPromotions(List<PromotionDto> promotionDtos) {
        List<Promotion> promotions = new ArrayList<>();
        for (PromotionDto dto : promotionDtos) {
            promotions.add(PromotionModel.valueOf(dto));
        }
        return promotions;
    }


    public List<PromotionDescriptor> convertPromotionsDescriptor(List<Promotion> promotionsModel) {
        List<PromotionDescriptor> promotions = new ArrayList<>();
        for (Promotion promotion : promotionsModel) {
            promotions.add(PromotionDescriptor.valueOf(promotion));
        }
        return promotions;
    }

}
