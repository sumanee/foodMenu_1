package com.promotion.food.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.promotion.food.enity.Promotion;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.enity.TypeMenu;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapPromotionResponseDto {
    private long mapPromotionId;
    private long promotionId;
    private long typeMenuId;
    private long typeFoodId;

    private Promotion promotion;
    private TypeMenu typeMenu;

    private TypeFood typeFood;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class  PromotionPayloadDto {
        private String promotionName;
        private List<TypeMenuDto> typeMenu;
        // getter/setter
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class  TypeMenuDto {
        private String typeMenuName;
        private List<TypeFoodDto> typeFood;
        // getter/setter
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class  TypeFoodDto {
        private String nameTypeFood;
        // getter/setter
    }


}
