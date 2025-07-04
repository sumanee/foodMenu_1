package com.promotion.food.service.impl;

import com.promotion.food.enity.Promotion;
import com.promotion.food.repository.PromotionRepository;
import com.promotion.food.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromotionImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Override
    public Promotion createPromotion(Promotion promotion) {
        Promotion savePromotion =  promotionRepository.save(promotion);
        return savePromotion;
    }
}
