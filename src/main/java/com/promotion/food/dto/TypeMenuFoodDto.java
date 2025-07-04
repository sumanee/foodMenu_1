package com.promotion.food.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeMenuFoodDto {

    private Long id;              // optional
    private Long typeMenuId;
    private Long typeFoodId;
}
