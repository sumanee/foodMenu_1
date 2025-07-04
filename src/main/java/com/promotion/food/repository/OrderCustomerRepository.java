package com.promotion.food.repository;

import com.promotion.food.enity.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer,Long> {

    //                   findByNumberTableAndActivateTrueAndTypeFood_ActivateTrueAndIngredient_ActivateTrue
    List<OrderCustomer> findByNumberTableAndActivateTrueAndTypeFood_ActivateTrueAndIngredient_ActivateTrue(Integer numberTable);
}
