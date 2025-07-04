package com.promotion.food.service.impl;

import com.promotion.food.Mapper.TypeMenuMapper;
import com.promotion.food.dto.TypeMenuDto;
import com.promotion.food.enity.TypeMenu;
import com.promotion.food.repository.TypeMenuRepository;
import com.promotion.food.service.TypeMenuService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeMenuImpl implements TypeMenuService {

    @Autowired
    private TypeMenuRepository typeMenuRepository;
    @Autowired
    private TypeMenuMapper typeMenuMapper;
    @Override
    public TypeMenuDto createTypeMenu(TypeMenuDto typeMenuDto) {
        TypeMenu dataTypeMenu  = typeMenuMapper.dtoToEntity(typeMenuDto);
        TypeMenu saveTypeMenu =  typeMenuRepository.save(dataTypeMenu);
        TypeMenuDto returnTypeMenu  = typeMenuMapper.entityToDto(saveTypeMenu);
        return returnTypeMenu;
    }



    @Override
    public List<TypeMenuDto> getListTypeMenu() {
        List<TypeMenu> listMenu = typeMenuRepository.findAll();
        List<TypeMenuDto> listMenuDto = listMenu.stream().map(typeMenuMapper::entityToDto)
                .collect(Collectors.toList());
        return listMenuDto;
    }

    @Override
    public TypeMenuDto updateTypeMenu(TypeMenuDto typeMenuDto, Long id) {
        TypeMenu typeMenu = typeMenuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMenu not found with id: " + id));

     //   TypeMenu mappTypeMenu =  typeMenuMapper.dtoToEntity(typeMenuDto);

        typeMenu.setTypeMenuName(typeMenuDto.getTypeMenuName());
        TypeMenu updated = typeMenuRepository.save(typeMenu);
        return typeMenuMapper.entityToDto(updated); // ใช้ Mapper แปลงเป็น DTO
    }

    @Override
    public TypeMenuDto isActivate(Long id) {
        TypeMenu typeMenu = typeMenuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMenu not found with id: " + id));

        typeMenu.setActivate(true);
        TypeMenu updated = typeMenuRepository.save(typeMenu);

        return typeMenuMapper.entityToDto(updated); // ใช้ Mapper แปลงเป็น DTO
    }

    @Override
    public TypeMenuDto inActivate(Long id) {
        TypeMenu typeMenu = typeMenuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMenu not found with id: " + id));

        typeMenu.setActivate(false);
        TypeMenu updated = typeMenuRepository.save(typeMenu);

        return typeMenuMapper.entityToDto(updated); // ใช้ Mapper แปลงเป็น DTO


    }

    @Override
    public TypeMenuDto getTypeMenuById(Long id) {
        TypeMenu typeMenu =  typeMenuRepository.getById(id);
        TypeMenuDto typeMenuDto  = typeMenuMapper.entityToDto(typeMenu);
    return typeMenuDto;
    }
}
