package com.promotion.food.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@Table(name = "order_customer")
@AllArgsConstructor
@NoArgsConstructor

public class OrderCustomer {

    @Id
    @Column(name = "order_customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderCustomerId;

    @Column(name = "number_table")
    private Integer numberTable;

    @ManyToOne
    @JoinColumn(name = "type_food_id")
    private  TypeFood typeFood;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private  Ingredient ingredient;

    @Column(name = "is_activate")
    private Boolean activate = true;


}
