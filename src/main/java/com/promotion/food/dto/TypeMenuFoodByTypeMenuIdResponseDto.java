package com.promotion.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeMenuFoodByTypeMenuIdResponseDto {

    private Long typeMenuId;
    private String typeMenuName;
    private List<FoodDto> arrayFood;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FoodDto {
        private Long typeFoodId;
        private String nameTypeFood;
        private boolean activeTypeFood;
    }
}
