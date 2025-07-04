package com.promotion.food.controller;

import com.promotion.food.Mapper.TypeMenuFoodMapper;
import com.promotion.food.Mapper.TypeMenuMapper;
import com.promotion.food.dto.TypeMenuFoodByTypeMenuIdResponseDto;
import com.promotion.food.dto.TypeMenuFoodDto;

import com.promotion.food.dto.TypeMenuFoodResponseDto;
import com.promotion.food.enity.TypeMenu;
import com.promotion.food.enity.TypeMenuFood;
import com.promotion.food.repository.TypeMenuFoodRepository;
import com.promotion.food.service.TypeMenuFoodService;
import com.promotion.food.service.TypeMenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mapMenuFood")
@AllArgsConstructor
public class TypeMenuFoodController {

    private TypeMenuFoodService typeMenuFoodService;
    @Autowired
    private TypeMenuFoodMapper typeMenuFoodMapper;
    @PostMapping
    public ResponseEntity<TypeMenuFoodResponseDto> createTypeMenuFood(@RequestBody TypeMenuFoodDto dataTypeMenuFoodDto){
        TypeMenuFood typeMenuFood =  typeMenuFoodService.createTypeMenuFood(dataTypeMenuFoodDto);

        TypeMenuFoodResponseDto typeMenuFoodResponseDto = typeMenuFoodMapper.toDto(typeMenuFood);

        return  new ResponseEntity<>(typeMenuFoodResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<TypeMenuFoodByTypeMenuIdResponseDto> getMenuFoodByTypeMenuId(@PathVariable long id){
        TypeMenuFoodByTypeMenuIdResponseDto typeMenuFoodByTypeMenuIdResponseDto =  typeMenuFoodService.getTypeMenuFoodByTypeMenuId(id);

        return  ResponseEntity.ok(typeMenuFoodByTypeMenuIdResponseDto);
    }


}
