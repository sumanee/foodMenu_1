package com.promotion.food.enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "promotion")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Promotion {

    @Id
    @Column(name = "promotion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long promotionId;
    @Column(name = "promotion_name")
    private String promotionName;
    @Column(name = "is_activate", nullable = false)
    private Boolean activate = true; // ✅ default เป็น true
}
