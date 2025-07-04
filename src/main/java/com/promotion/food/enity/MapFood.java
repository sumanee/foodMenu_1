package com.promotion.food.enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "map_food")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MapFood {

    @Id
    @Column(name = "map_food_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long map_food_id;

    @ManyToOne
    @JoinColumn(name = "type_food_id")
    private TypeFood typeFood;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "is_activate")
    private Boolean activate = true;


}
