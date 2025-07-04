package com.promotion.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {

    private long ingredientId;
    private String ingredientName;
    private Double ingredientPrice;
    private Boolean activate;
}
