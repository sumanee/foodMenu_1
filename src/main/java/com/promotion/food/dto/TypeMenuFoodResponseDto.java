package com.promotion.food.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeMenuFoodResponseDto {
    private Long id;
    private Long typeMenuId;
    private String typeMenuName;
    private Long typeFoodId;
    private String typeFoodName;
}
