package com.promotion.food.Mapper;

import com.promotion.food.dto.TypeFoodDto;
import com.promotion.food.dto.TypeMenuDto;
import com.promotion.food.dto.TypeMenuFoodDto;
import com.promotion.food.dto.TypeMenuFoodResponseDto;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.enity.TypeMenu;
import com.promotion.food.enity.TypeMenuFood;
import org.springframework.stereotype.Component;


@Component
public class TypeMenuFoodMapper {

    public TypeMenuFoodResponseDto toDto(TypeMenuFood entity) {
        return new TypeMenuFoodResponseDto(
                entity.getId(),
                entity.getTypeMenu().getTypeMenuId(),
                entity.getTypeMenu().getTypeMenuName(),
                entity.getTypeFood().getTypeFoodId(),
                entity.getTypeFood().getNameTypeFood()
        );
    }
}

