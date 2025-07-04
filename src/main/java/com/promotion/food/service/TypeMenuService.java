package com.promotion.food.service;

import com.promotion.food.dto.TypeMenuDto;
import com.promotion.food.enity.TypeMenu;

import java.util.List;

public interface TypeMenuService  {

    TypeMenuDto createTypeMenu (TypeMenuDto typeMenuDto);
    List<TypeMenuDto> getListTypeMenu();

    TypeMenuDto updateTypeMenu(TypeMenuDto typeMenuDto,Long id);
    TypeMenuDto isActivate(Long id);
    TypeMenuDto inActivate(Long id);

    TypeMenuDto getTypeMenuById(Long id);


}
