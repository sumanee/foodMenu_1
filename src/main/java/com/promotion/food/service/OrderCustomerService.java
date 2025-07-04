package com.promotion.food.service;


import com.promotion.food.dto.OrderCustomerDto;
import com.promotion.food.enity.OrderCustomer;

import java.util.List;

public interface OrderCustomerService {
    OrderCustomer createOrder (OrderCustomerDto dataOrderCustomerDto);
    List<OrderCustomer> getOrderByNumberTable(Integer numberTable);
}
