package com.promotion.food.repository;

import com.promotion.food.enity.MapPromotion;
import com.promotion.food.enity.TypeMenuFood;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MapPromotionRepository extends JpaRepository<MapPromotion,Long> {
/*
* SELECT p.promotion_name ,tm.type_menu_name ,tf.name_type_food FROM menu_management.map_promotion mp
*RIGHT JOIN menu_management.promotion p ON (mp.promotion_id = p.promotion_id)
*RIGHT JOIN menu_management.type_food tf  ON (mp.type_food_id = tf.type_food_id)
 *RIGHT JOIN menu_management.type_menu tm  ON (mp.type_menu_id = tm.type_menu_id)
*WHERE mp .promotion_id  = 1 and mp.is_activate = true and p.is_activate = true and tf.is_activate = true and tm.is_activate = true
* **/

    List<MapPromotion> findByPromotion_PromotionIdAndIsActivateTrueAndPromotion_ActivateTrueAndTypeMenu_ActivateTrueAndTypeFood_ActivateTrue(Long promotionId);


}
