package com.promotion.food.repository;

import com.promotion.food.enity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository  extends JpaRepository<Promotion,Long> {

}
