package com.promotion.food.repository;

import com.promotion.food.enity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    List<Ingredient> findByActivateTrueOrderByIngredientNameAsc();

    Optional<Ingredient> findByIngredientIdAndActivateTrue(Long ingredientId);

}
