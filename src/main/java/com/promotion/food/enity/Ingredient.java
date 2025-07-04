package com.promotion.food.enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Table(name = "Ingredient")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private long ingredientId;

    @Column(name = "ingredient_name")
    private String ingredientName;


    @Column(name = "ingredient_price")
    private Double ingredientPrice;

    @Column(name = "is_activate", nullable = false)
    private Boolean activate = true; // ✅ default เป็น true

}
