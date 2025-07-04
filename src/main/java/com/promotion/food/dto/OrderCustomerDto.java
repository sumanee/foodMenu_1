package com.promotion.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class OrderCustomerDto {
    private  long orderId;
    private  Integer numberTable;
    private  long typeFoodId;
    private  long ingredientId;

    @AllArgsConstructor
    @Setter
    @Getter
    @NoArgsConstructor
    public static class  TypeFood {
        private Integer numberTable;
        private List<OrderCustomerDto.TypeFoods> TypeFoodList;
    }

    @AllArgsConstructor
    @Setter
    @Getter
    @NoArgsConstructor
    public static class  TypeFoods {
        private String typeFoodName;
        private List<OrderCustomerDto.IngredientDto> ingredientList;
    }


    @AllArgsConstructor
    @Setter
    @Getter
    @NoArgsConstructor
    public static class  IngredientDto {
        private String ingredientName;
        private Long count; // ← เพิ่มนับจำนวน

    }


}
