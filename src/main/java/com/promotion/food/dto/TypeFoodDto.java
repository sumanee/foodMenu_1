package com.promotion.food.dto;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TypeFoodDto {

    private long typeFoodId;
    private String nameTypeFood;
    private Boolean activate;

}
