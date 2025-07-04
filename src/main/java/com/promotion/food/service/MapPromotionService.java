package com.promotion.food.service;

import com.promotion.food.dto.MapPromotionResponseDto;
import com.promotion.food.enity.MapPromotion;

import java.util.List;

public interface MapPromotionService {

    MapPromotion createMapPromotion (MapPromotionResponseDto dataMapPromotion);
    List<MapPromotion> getMapPromotionByPromotionId (long dataMapPromotionId);

}
