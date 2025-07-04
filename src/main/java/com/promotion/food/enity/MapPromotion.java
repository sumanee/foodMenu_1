package com.promotion.food.enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "map_promotion")
@ToString
public class MapPromotion {

    @Id
    @Column(name = "map_promotion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mapPromotionId;

    @Column(name = "is_activate")
    private boolean isActivate =  true;

    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = false)
    private  Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "type_menu_id", nullable = false)
    private  TypeMenu typeMenu;

    @ManyToOne
    @JoinColumn(name = "type_food_id", nullable = false)
    private  TypeFood typeFood;


}
