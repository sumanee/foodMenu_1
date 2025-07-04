package com.promotion.food.service.impl;

import com.promotion.food.enity.Ingredient;
import com.promotion.food.repository.IngredientRepository;
import com.promotion.food.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;


@Service
@AllArgsConstructor
public class IngredientImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    @Override
    public Ingredient createIngredient(Ingredient dataIngredient) {
        Ingredient ingredient = ingredientRepository.save(dataIngredient);
        return ingredient;
    }

    @Override
    public List<Ingredient> getListIngredient() {
        List<Ingredient> ingredientList = ingredientRepository.findByActivateTrueOrderByIngredientNameAsc();
        return ingredientList;
    }
}
