package com.promotion.food.service.impl;

import com.promotion.food.dto.MapFoodDto;
import com.promotion.food.enity.Ingredient;
import com.promotion.food.enity.MapFood;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.repository.IngredientRepository;
import com.promotion.food.repository.MapFoodRepository;
import com.promotion.food.repository.TypeFoodRepository;
import com.promotion.food.service.MapFoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MapFoodImpl implements MapFoodService {

    private final MapFoodRepository mapFoodRepository;
    private final TypeFoodRepository typeFoodRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public MapFood createMapFood(MapFoodDto dataMapFoodDto) {
        Ingredient ingredient = ingredientRepository.findById(dataMapFoodDto.getIngredientId())
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        TypeFood typeFood = typeFoodRepository.findById(dataMapFoodDto.getTypeFoodId())
                .orElseThrow(() -> new RuntimeException("TypeFood not found"));

        MapFood mapFood = new MapFood();
        mapFood.setTypeFood(typeFood);
        mapFood.setIngredient(ingredient);
        MapFood saveMapFood =  mapFoodRepository.save(mapFood);
        return saveMapFood;
    }

    @Override
    public  List<MapFood> getMapFoodByTypeFoodId(Long typeFoodId) {
        List<MapFood> mapFood = mapFoodRepository.findByTypeFood_TypeFoodIdAndActivateTrueAndTypeFood_ActivateTrueAndIngredient_ActivateTrue(typeFoodId);
        return mapFood;
    }
}
