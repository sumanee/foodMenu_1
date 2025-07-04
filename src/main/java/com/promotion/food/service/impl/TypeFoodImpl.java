package com.promotion.food.service.impl;

import com.promotion.food.enity.TypeFood;
import com.promotion.food.enity.TypeMenu;
import com.promotion.food.repository.TypeFoodRepository;
import com.promotion.food.service.TypeFoodService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeFoodImpl implements TypeFoodService {

    private final TypeFoodRepository typeFoodRepository;
    @Override
    public TypeFood createTypeFood(TypeFood typeFood) {
        TypeFood saveTypeFood =   typeFoodRepository.save(typeFood);
        return saveTypeFood;
    }

    @Override
    public List<TypeFood> getListTypeFood() {
        List<TypeFood> listTypeFood = typeFoodRepository.findAll();
        return listTypeFood;
    }

    @Override
    public Page<TypeFood> searchTypeFood(String typeFoodName, Pageable pageable) {
        Page<TypeFood> resultSearchTypeFood = typeFoodRepository
                .findByNameTypeFoodContainingIgnoreCase(typeFoodName,pageable);


        return resultSearchTypeFood;
    }

    @Override
    public TypeFood getTypeFoodById(Long typeFoodId) {
        System.out.println("typeFoodId"+typeFoodId);
        TypeFood dataTypeFood =  typeFoodRepository.findById(typeFoodId)
                .orElseThrow(() -> new EntityNotFoundException("TypeMenu not found with id: " + typeFoodId));;
        return dataTypeFood;
    }

    @Override
    public TypeFood updateTypeFood(TypeFood dataTypeFood, Long id) {
        TypeFood queryTypeFood = typeFoodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMenu not found with id: " + id));;

        TypeFood saveTypeFood = new TypeFood();
        saveTypeFood.setTypeFoodId(id);
        saveTypeFood.setNameTypeFood(dataTypeFood.getNameTypeFood());
        saveTypeFood.setActivate(dataTypeFood.getActivate());
        TypeFood updated = typeFoodRepository.save(saveTypeFood);

        return updated;
    }

    @Override
    public TypeFood isActivate(Long id) {
        TypeFood queryTypeFood = typeFoodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMenu not found with id: " + id));

        TypeFood saveTypeFood = new TypeFood();
        saveTypeFood.setNameTypeFood(queryTypeFood.getNameTypeFood());
        saveTypeFood.setTypeFoodId(id);
        saveTypeFood.setActivate(true);
        TypeFood updated = typeFoodRepository.save(saveTypeFood);
        return updated;

    }

    @Override
    public TypeFood inActivate(Long id) {
        TypeFood queryTypeFood = typeFoodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMenu not found with id: " + id));

        TypeFood saveTypeFood = new TypeFood();
        saveTypeFood.setNameTypeFood(queryTypeFood.getNameTypeFood());
        saveTypeFood.setTypeFoodId(id);
        saveTypeFood.setActivate(false);
        TypeFood updated = typeFoodRepository.save(saveTypeFood);
        return updated;
    }
}
