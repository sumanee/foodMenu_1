package com.promotion.food.service;

import com.promotion.food.enity.Promotion;
import org.springframework.stereotype.Service;


public interface PromotionService {
    Promotion createPromotion(Promotion promotion);
}
