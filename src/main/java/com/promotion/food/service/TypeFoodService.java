package com.promotion.food.service;

import com.promotion.food.enity.TypeFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeFoodService {

    TypeFood createTypeFood(TypeFood typeFood);
    Page<TypeFood> searchTypeFood(String typeFoodName, Pageable pageable);
    List<TypeFood> getListTypeFood();
    TypeFood getTypeFoodById(Long typeFoodId);
    TypeFood updateTypeFood(TypeFood dataTypeFood, Long id);
    TypeFood isActivate(Long id);
    TypeFood inActivate(Long id);

}
