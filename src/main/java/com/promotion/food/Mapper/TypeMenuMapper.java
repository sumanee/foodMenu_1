package com.promotion.food.Mapper;

import com.promotion.food.dto.TypeMenuDto;
import com.promotion.food.enity.TypeMenu;
import org.springframework.stereotype.Component;

@Component
public class TypeMenuMapper {

    public TypeMenu dtoToEntity(TypeMenuDto dto) {
        System.out.println("dto"+dto);
        return new TypeMenu(
                dto.getTypeMenuName(),
                dto.getActivate()
        );
    }

    public TypeMenuDto entityToDto(TypeMenu entity) {
        return new TypeMenuDto(
                entity.getTypeMenuId(),
                entity.getTypeMenuName(),
                entity.getActivate()
        );
    }
}
