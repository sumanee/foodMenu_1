package com.promotion.food.service.impl;

import com.promotion.food.dto.OrderCustomerDto;
import com.promotion.food.enity.Ingredient;
import com.promotion.food.enity.OrderCustomer;
import com.promotion.food.enity.TypeFood;
import com.promotion.food.repository.IngredientRepository;
import com.promotion.food.repository.OrderCustomerRepository;
import com.promotion.food.repository.TypeFoodRepository;
import com.promotion.food.service.OrderCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderCustomerImpl implements OrderCustomerService {
    private  final OrderCustomerRepository orderCustomerRepository;
    private  final IngredientRepository ingredientRepository;
    private  final TypeFoodRepository typeFoodRepository;
    @Override
    public OrderCustomer createOrder(OrderCustomerDto dataOrderCustomerDto) {

        TypeFood typeFood = typeFoodRepository
                .findByTypeFoodIdAndActivateTrue(dataOrderCustomerDto.getTypeFoodId())
                .orElseThrow(() -> new RuntimeException("Type Food not found"));

        Ingredient ingredient = ingredientRepository.findByIngredientIdAndActivateTrue(dataOrderCustomerDto.getIngredientId())
                .orElseThrow(()-> new RuntimeException("Ingredient not found"));

        OrderCustomer orderCustomer = new OrderCustomer();
        orderCustomer.setTypeFood(typeFood);
        orderCustomer.setIngredient(ingredient);
        orderCustomer.setNumberTable(dataOrderCustomerDto.getNumberTable());
        OrderCustomer saveOrderCustomer =  orderCustomerRepository.save(orderCustomer);
        return orderCustomer;
    }

    @Override
    public List<OrderCustomer> getOrderByNumberTable(Integer numberTable) {
        List<OrderCustomer> orderCustomerList = orderCustomerRepository.findByNumberTableAndActivateTrueAndTypeFood_ActivateTrueAndIngredient_ActivateTrue(numberTable);
        return orderCustomerList;
    }
}
