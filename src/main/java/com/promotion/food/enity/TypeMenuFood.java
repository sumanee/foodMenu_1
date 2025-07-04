package com.promotion.food.enity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "type_menu_food")
@ToString
public class TypeMenuFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "type_menu_id", nullable = false)
    private TypeMenu typeMenu;

    // Many-to-One to TypeFood
    @ManyToOne
    @JoinColumn(name = "type_food_id", nullable = false)
    private TypeFood typeFood;

    @Column(name = "is_activate")
    private Boolean isActivate = true;


    @Override
    public String toString() {
        return "TypeMenuFood{" +
                "id=" + id +
                ", typeMenuId=" + (typeMenu != null ? typeMenu.getTypeMenuId() : null) +
                ", typeFoodId=" + (typeFood != null ? typeFood.getTypeFoodId() : null) +
                '}';
    }
}
