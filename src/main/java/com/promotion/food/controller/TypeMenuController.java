package com.promotion.food.controller;

import com.promotion.food.dto.TypeMenuDto;

import com.promotion.food.service.TypeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/typeMenu")
@CrossOrigin("*")
public class TypeMenuController {

    @Autowired
    private TypeMenuService typeMenuService;

    @PostMapping
    public ResponseEntity<TypeMenuDto> createTypeMenu(@RequestBody TypeMenuDto dataTypeMenuDto){
        TypeMenuDto typeMenuDto = typeMenuService.createTypeMenu(dataTypeMenuDto);
        System.out.println("typeMenuDto"+typeMenuDto);
        return  new ResponseEntity<>(typeMenuDto, HttpStatus.CREATED) ;
    }

    @GetMapping
    public  ResponseEntity<List<TypeMenuDto>> getTypeMenu(){
       List<TypeMenuDto> listTypeMenuDto = typeMenuService.getListTypeMenu();
       return   ResponseEntity.ok(listTypeMenuDto);
    }

    @PatchMapping("activate")
    public  ResponseEntity<TypeMenuDto> updateStatusActivate(@RequestParam long id){
        TypeMenuDto typeMenuDto = typeMenuService.isActivate(id);
        return   ResponseEntity.ok(typeMenuDto);
    }
    @PatchMapping("inActivate")
    public  ResponseEntity<TypeMenuDto> updateStatusInactivate(@RequestParam long id){
        TypeMenuDto typeMenuDto = typeMenuService.inActivate(id);
        return   ResponseEntity.ok(typeMenuDto);
    }

    @PutMapping("update/{id}")
    public  ResponseEntity<TypeMenuDto> updateTypeMenu(@PathVariable long id,@RequestBody TypeMenuDto dataTypeMenuDto){
        TypeMenuDto typeMenuDto = typeMenuService.updateTypeMenu(dataTypeMenuDto,id);
        return   ResponseEntity.ok(typeMenuDto);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<TypeMenuDto> getTypeMenuById(@PathVariable Long id){
        TypeMenuDto typeMenuDto = typeMenuService.getTypeMenuById(id);
        return   ResponseEntity.ok(typeMenuDto);
    }


}
