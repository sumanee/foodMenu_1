package com.promotion.food.dto;

import com.promotion.food.enity.Ingredient;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MapFoodDto {

    private long mapFoodId;
    private long typeFoodId;
    private long ingredientId;



    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class IngredientList {
        private String typeFoodName;
        private List<IngredientDto> ingredientList;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class IngredientDto {
       private long ingredientId;
        private String ingredientName;
    }



}
