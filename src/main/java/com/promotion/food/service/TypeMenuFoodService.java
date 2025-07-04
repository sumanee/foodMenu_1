package com.promotion.food.service;

import com.promotion.food.dto.TypeMenuFoodByTypeMenuIdResponseDto;
import com.promotion.food.dto.TypeMenuFoodDto;
import com.promotion.food.enity.TypeMenuFood;

public interface TypeMenuFoodService {

    TypeMenuFood createTypeMenuFood(TypeMenuFoodDto dataTypeMenuFoodDto);
    TypeMenuFoodByTypeMenuIdResponseDto getTypeMenuFoodByTypeMenuId(long dataTypeMenuId);

}
