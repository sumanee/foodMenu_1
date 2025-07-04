package com.promotion.food.repository;

import com.promotion.food.enity.TypeFood;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface TypeFoodRepository extends JpaRepository<TypeFood,Long> {

    Optional<TypeFood> findByTypeFoodIdAndActivateTrue(Long typeFoodId);

    Page<TypeFood> findByNameTypeFoodContainingIgnoreCase(String keyword, Pageable pageable);

}
