package com.promotion.food.controller;


import com.promotion.food.dto.IngredientDto;
import com.promotion.food.dto.MapFoodDto;
import com.promotion.food.dto.MapPromotionResponseDto;
import com.promotion.food.enity.Ingredient;
import com.promotion.food.enity.MapFood;
import com.promotion.food.enity.MapPromotion;
import com.promotion.food.service.IngredientService;
import com.promotion.food.service.MapFoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    private final MapFoodService mapFoodService;
    @PostMapping
    public ResponseEntity<Ingredient> createIngredient (@RequestBody Ingredient dataIngredient){
        Ingredient ingredient =   ingredientService.createIngredient(dataIngredient);

        return  new ResponseEntity<>(ingredient, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> createIngredient (){
        List<Ingredient> ingredientList =   ingredientService.getListIngredient();
        return  new ResponseEntity<>(ingredientList, HttpStatus.OK);

    }

    @PostMapping("/map")
    public ResponseEntity<MapFood> mapFood (@RequestBody MapFoodDto dataMapFoodDto){
        MapFood mapFood =   mapFoodService.createMapFood(dataMapFoodDto);
System.out.println("mapFood"+ mapFood);
        return  new ResponseEntity<>(mapFood, HttpStatus.CREATED);

    }

    @GetMapping("/map")
    public ResponseEntity< List<MapFoodDto.IngredientList>> getMapFoodByTypeFoodId (@RequestParam Long id){
        List<MapFood> mapFood =   mapFoodService.getMapFoodByTypeFoodId(id);

        Map<Long, List<MapFood>>  groupedTypeFood = mapFood.stream()
                .collect(Collectors.groupingBy(mf -> mf.getTypeFood().getTypeFoodId()));

        System.out.println("groupedTypeFood"+ groupedTypeFood);

        List<MapFoodDto.IngredientList> ingredientLists = groupedTypeFood.entrySet().stream()
                .map(entry -> {
                    List<MapFood> items = entry.getValue();
                    String typeFoodName = items.get(0).getTypeFood().getNameTypeFood();

                    List<MapFoodDto.IngredientDto> ingredientDtos = items.stream()
                            .map(mp -> new MapFoodDto.IngredientDto(
                                    mp.getIngredient().getIngredientId(),
                                    mp.getIngredient().getIngredientName()
                            ))
                            .toList();

                    return new MapFoodDto.IngredientList(typeFoodName, ingredientDtos);
                })
                .toList();



        return  new ResponseEntity<>(ingredientLists, HttpStatus.CREATED);

    }

}
