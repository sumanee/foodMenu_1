package com.promotion.food.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class PromotionDto {
    private long promotionId;
    private String promotionName;
    private boolean isActivate;
}
