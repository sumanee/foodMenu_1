package com.promotion.food.service;

import com.promotion.food.enity.Ingredient;

import javax.swing.*;
import java.util.List;

public interface IngredientService {
    Ingredient createIngredient (Ingredient dataIngredient);
    List<Ingredient> getListIngredient ();



}
