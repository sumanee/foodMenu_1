package com.promotion.food.controller;


import com.promotion.food.dto.PageResponseDto;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.service.TypeFoodService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/typeFood")
@AllArgsConstructor
@CrossOrigin("*")

public class TypeFoodController {

    private final TypeFoodService typeFoodService;
    @PostMapping
    public ResponseEntity<TypeFood> createTypeFood(@RequestBody TypeFood dataTypeFood){
        TypeFood typeFood =  typeFoodService.createTypeFood(dataTypeFood);
        return  new ResponseEntity<>(typeFood, HttpStatus.CREATED);

    }

    @GetMapping("/search")
    public ResponseEntity< PageResponseDto<TypeFood>> searchTypeFood( @RequestParam String typeFoodName,
                                                           @RequestParam(defaultValue = "0") int page,         // หน้าเริ่มที่ 0
                                                           @RequestParam(defaultValue = "10") int size,
                                                           @RequestParam(defaultValue = "typeFoodId") String sortBy,
                                                           @RequestParam(defaultValue = "asc") String sortDir)
    {
        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<TypeFood> resultPage = typeFoodService.searchTypeFood(typeFoodName, pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("data", resultPage.getContent());
        response.put("page", resultPage.getNumber());
        response.put("totalPages", resultPage.getTotalPages());

        return  new ResponseEntity<>(new PageResponseDto<>(resultPage), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TypeFood>> getListTypeFood (){
        List<TypeFood> listTypeFood = typeFoodService.getListTypeFood();
        return  new ResponseEntity<>(listTypeFood,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeFood> getListTypeFoodById (@PathVariable Long id){
        TypeFood listTypeFood = typeFoodService.getTypeFoodById(id);
        return  new ResponseEntity<>(listTypeFood,HttpStatus.OK);
    }


    @PatchMapping("/activate")
    public ResponseEntity<TypeFood>  isActivate (@RequestParam Long id){
        TypeFood listTypeFood = typeFoodService.isActivate(id);
        return  new ResponseEntity<>(listTypeFood,HttpStatus.OK);
    }

    @PatchMapping("/inactivate")
    public ResponseEntity<TypeFood>  inActivate (@RequestParam Long id){
        TypeFood listTypeFood = typeFoodService.inActivate(id);
        return  new ResponseEntity<>(listTypeFood,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeFood>  updateTypeFood (@PathVariable Long id,@RequestBody TypeFood dataTypeFood){
        TypeFood listTypeFood = typeFoodService.updateTypeFood(dataTypeFood,id);
        return  new ResponseEntity<>(listTypeFood,HttpStatus.OK);
    }





}
