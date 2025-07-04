package com.promotion.food.service.impl;

import com.promotion.food.dto.MapPromotionResponseDto;
import com.promotion.food.enity.MapPromotion;
import com.promotion.food.enity.Promotion;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.enity.TypeMenu;
import com.promotion.food.repository.MapPromotionRepository;
import com.promotion.food.repository.PromotionRepository;
import com.promotion.food.repository.TypeFoodRepository;
import com.promotion.food.repository.TypeMenuRepository;
import com.promotion.food.service.MapPromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MapPromotionImpl implements MapPromotionService {

    private final MapPromotionRepository mapPromotionRepository;
    private final PromotionRepository promotionRepository;
    private final TypeFoodRepository typeFoodRepository;
    private final TypeMenuRepository typeMenuRepository;

    @Override
    public MapPromotion createMapPromotion(MapPromotionResponseDto dataMapPromotion) {
       Promotion promotion = promotionRepository.findById(dataMapPromotion.getPromotionId())
               .orElseThrow(() -> new RuntimeException("Promotion not found"));

        TypeFood typeFood = typeFoodRepository.findById(dataMapPromotion.getTypeFoodId())
                .orElseThrow(() -> new RuntimeException("TypeFood not found"));

        TypeMenu typeMenu = typeMenuRepository.findById(dataMapPromotion.getTypeMenuId())
                .orElseThrow(() -> new RuntimeException("TypeMenu not found"));

        MapPromotion mapPromotion = new MapPromotion();
        mapPromotion.setPromotion(promotion);
        mapPromotion.setTypeFood(typeFood);
        mapPromotion.setTypeMenu(typeMenu);

        MapPromotion saveMapPromotion = mapPromotionRepository.save(mapPromotion);
        return saveMapPromotion;
    }

    @Override
    public List<MapPromotion> getMapPromotionByPromotionId(long dataMapPromotionId) {
        List<MapPromotion> mapPromotionList = mapPromotionRepository.findByPromotion_PromotionIdAndIsActivateTrueAndPromotion_ActivateTrueAndTypeMenu_ActivateTrueAndTypeFood_ActivateTrue(dataMapPromotionId);


        return mapPromotionList;
    }
}
