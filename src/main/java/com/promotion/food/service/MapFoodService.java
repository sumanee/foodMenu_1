package com.promotion.food.service;

import com.promotion.food.dto.MapFoodDto;
import com.promotion.food.enity.MapFood;

import java.util.List;

public interface MapFoodService {
    MapFood createMapFood(MapFoodDto dataMapFoodDto);
    List<MapFood> getMapFoodByTypeFoodId(Long typeFoodId);

}
