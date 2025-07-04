package com.promotion.food.enity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "type_food")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeFoodId;
    @Column(name = "nameTypeFood", nullable = true)
    private String nameTypeFood;
    @Column(name = "isActivate")
    private Boolean activate = true;







}
