package com.promotion.food.service.impl;

import com.promotion.food.dto.TypeMenuFoodByTypeMenuIdResponseDto;
import com.promotion.food.dto.TypeMenuFoodDto;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.enity.TypeMenu;
import com.promotion.food.enity.TypeMenuFood;
import com.promotion.food.repository.TypeFoodRepository;
import com.promotion.food.repository.TypeMenuFoodRepository;
import com.promotion.food.repository.TypeMenuRepository;
import com.promotion.food.service.TypeMenuFoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TypeMenuFoodImpl implements TypeMenuFoodService {

    private final TypeMenuFoodRepository typeMenuFoodRepository;
    private final TypeMenuRepository typeMenuRepository;
    private final TypeFoodRepository typeFoodRepository;

    @Override
    public TypeMenuFood createTypeMenuFood(TypeMenuFoodDto dataTypeMenuFoodDto) {


        TypeMenu typeMenu =   typeMenuRepository.findById(dataTypeMenuFoodDto.getTypeMenuId())
                .orElseThrow(() -> new RuntimeException("TypeMenu not found"));

        TypeFood typeFood =   typeFoodRepository.findById(dataTypeMenuFoodDto.getTypeFoodId())
                .orElseThrow(() -> new RuntimeException("TypeFood not found"));

        TypeMenuFood typeMenuFood = new TypeMenuFood();
        typeMenuFood.setTypeFood(typeFood);
        typeMenuFood.setTypeMenu(typeMenu);
        TypeMenuFood saveTypeMenuFood =  typeMenuFoodRepository.save(typeMenuFood);
        System.out.println(saveTypeMenuFood);
        return saveTypeMenuFood;
    }

    @Override
    public TypeMenuFoodByTypeMenuIdResponseDto getTypeMenuFoodByTypeMenuId(long dataTypeMenuId) {
        TypeMenu typeMenu = typeMenuRepository.findByTypeMenuIdAndActivateTrue(dataTypeMenuId)
                .orElseThrow(() -> new RuntimeException("TypeMenu not found"));

        List<TypeMenuFood> typeMenuFoods = typeMenuFoodRepository.findByTypeMenu_TypeMenuIdAndIsActivateTrue(dataTypeMenuId);

        List<TypeMenuFoodByTypeMenuIdResponseDto.FoodDto> foods = typeMenuFoods.stream()
                .map(menuFood -> new TypeMenuFoodByTypeMenuIdResponseDto.FoodDto(
                        menuFood.getTypeFood().getTypeFoodId(),
                        menuFood.getTypeFood().getNameTypeFood(),
                        menuFood.getTypeFood().getActivate()
                )).toList();

        return new TypeMenuFoodByTypeMenuIdResponseDto(
                typeMenu.getTypeMenuId(),
                typeMenu.getTypeMenuName(),
                foods
        );
    }


}
