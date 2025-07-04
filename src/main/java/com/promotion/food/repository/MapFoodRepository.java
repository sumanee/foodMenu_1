package com.promotion.food.repository;

import com.promotion.food.enity.MapFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapFoodRepository extends JpaRepository<MapFood,Long> {
    /*
    *
SELECT tf.name_type_food ,i.ingredient_name  , i.ingredient_price  FROM menu_management.map_food mf
INNER JOIN menu_management.type_food tf ON(mf.type_food_id = tf.type_food_id)
INNER JOIN menu_management.ingredient i  ON(mf.ingredient_id = i.ingredient_id)
WHERE mf.type_food_id = 3 AND mf.is_activate = true and tf.is_activate  = true and i.is_activate  = true

* */

//findByTypeFood_TypeFoodIdAndActivateTrueAndTypeFood_ActivateTrueAndIngredient_ActivateTrue
    List<MapFood> findByTypeFood_TypeFoodIdAndActivateTrueAndTypeFood_ActivateTrueAndIngredient_ActivateTrue(Long TypeFoodId);
}
