package com.promotion.food.repository;

import com.promotion.food.enity.TypeMenuFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMenuFoodRepository extends JpaRepository<TypeMenuFood,Long> {
    //  List<TypeMenu> findByActivateTrue();
    List<TypeMenuFood> findByTypeMenu_TypeMenuIdAndIsActivateTrue(Long typeMenuId);

}
