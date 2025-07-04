package com.promotion.food.controller;


import com.promotion.food.dto.OrderCustomerDto;
import com.promotion.food.enity.OrderCustomer;
import com.promotion.food.service.OrderCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Keymap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderCustomerService orderCustomerService;
    @PostMapping
    public ResponseEntity<OrderCustomer> createOrder(@RequestBody OrderCustomerDto dataOrderCustomerDto){
        OrderCustomer orderCustomer = orderCustomerService.createOrder(dataOrderCustomerDto);
        return  new ResponseEntity<>(orderCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderCustomerDto.TypeFood>> getOrderByNumberTable(@RequestParam Integer  dataNumberTable){
        List<OrderCustomer> orderCustomer = orderCustomerService.getOrderByNumberTable(dataNumberTable);
/*
        Map<Integer, List<OrderCustomer>>  collectOrderCustomer = orderCustomer.stream()
                .collect(Collectors.groupingBy(oc -> oc.getNumberTable()));

        List<OrderCustomerDto.TypeFood> result = collectOrderCustomer.entrySet().stream().map(entry -> {
            Integer numberTable = entry.getKey();
            List<OrderCustomer> items = entry.getValue();

            // Group by typeFoodName -> เพื่อรวม ingredient ตามแต่ละเมนู
            Map<String, List<String>> typeFoodToIngredientNames = items.stream()
                    .collect(Collectors.groupingBy(
                            oc -> oc.getTypeFood().getNameTypeFood(),
                            Collectors.mapping(oc -> oc.getIngredient().getIngredientName(), Collectors.toList())
                    ));

            // Convert Map เป็น List<TypeFoods>
            List<OrderCustomerDto.TypeFoods> typeFoodList = typeFoodToIngredientNames.entrySet().stream()
                    .map(e -> new OrderCustomerDto.TypeFoods(
                            e.getKey(), // typeFoodName
                            e.getValue().stream()
                                    .map(OrderCustomerDto.IngredientDto::new)
                                    .collect(Collectors.toList())
                    ))
                    .collect(Collectors.toList());

            return new OrderCustomerDto.TypeFood(numberTable, typeFoodList);
        }).collect(Collectors.toList());

*/


        List<OrderCustomerDto.TypeFood> result = orderCustomer.stream()
                .collect(Collectors.groupingBy(OrderCustomer::getNumberTable))
                .entrySet().stream()
                .map(entry -> {
                    Integer numberTable = entry.getKey();
                    List<OrderCustomer> items = entry.getValue();

                    Map<String, Map<String, Long>> groupedData = items.stream()
                            .collect(Collectors.groupingBy(
                                    oc -> oc.getTypeFood().getNameTypeFood(),
                                    Collectors.groupingBy(
                                            oc -> oc.getIngredient().getIngredientName(),
                                            Collectors.counting()
                                    )
                            ));

                    List<OrderCustomerDto.TypeFoods> typeFoodList = groupedData.entrySet().stream()
                            .map(typeEntry -> {
                                String typeFoodName = typeEntry.getKey();
                                List<OrderCustomerDto.IngredientDto> ingredientList = typeEntry.getValue().entrySet().stream()
                                        .map(ingEntry -> new OrderCustomerDto.IngredientDto(ingEntry.getKey(), ingEntry.getValue()))
                                        .collect(Collectors.toList());
                                return new OrderCustomerDto.TypeFoods(typeFoodName, ingredientList);
                            })
                            .collect(Collectors.toList());

                    return new OrderCustomerDto.TypeFood(numberTable, typeFoodList);
                })
                .collect(Collectors.toList());


        //!
        List<Map<String, Object>> salesData = Arrays.asList(
                Map.of("storeId", "S001", "category", "Beverage", "sales", 1500),
                Map.of("storeId", "S001", "category", "Food", "sales", 4000),
                Map.of("storeId", "S002", "category", "Beverage", "sales", 1000),
                Map.of("storeId", "S002", "category", "Food", "sales", 3000),
                Map.of("storeId", "S003", "category", "Beverage", "sales", 2000),
                Map.of("storeId", "S003", "category", "Food", "sales", 3500)
        );

        List<Map<String, Object>> return1 = salesData.stream()
                .filter(Keymap -> "S002".equals(Keymap.get("storeId")))
                .collect(Collectors.toList());

        System.out.println("return1----------" + return1);
        Map<String, Integer> return2 = salesData.stream()
                .collect(Collectors.groupingBy(
                        map -> (String) map.get("category"),
                        Collectors.summingInt(map -> (Integer) map.get("sales"))
                ));

        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob", "Alice");

        Map<String, Long> nameCount = names.stream().
                collect(Collectors.groupingByConcurrent(name -> name, Collectors.counting()));
        System.out.println("nameCount----------" + nameCount);

        // โจทย์ที่ 2: แสดงผลด้วย entrySet
        for (Map.Entry<String, Long> entry : nameCount.entrySet()) {
            System.out.println("ชื่อ: " + entry.getKey() + ", พบ: " + entry.getValue() + " ครั้ง");
        }

      String returnName =  names.stream().filter(name -> name.equalsIgnoreCase("alice"))
              .findFirst()
              .orElse("ไม่เจอ");
       System.out.println("returnName = "+returnName);

        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 20);
        ageMap.put("Bob", 25);
        ageMap.put("John", 22);

        System.out.println("ageMap = "+ageMap);

        Map<String, Long> listCountName = names.stream()
                .collect(Collectors.groupingBy(name -> name ,Collectors.counting()));

        //!1
        List<String> listNameExOne =  names.stream().filter(name ->  !name.equalsIgnoreCase("alice"))
                .sorted().toList();
        System.out.println("listNameExOne = "+listNameExOne);
        //!2
        Long listNameExTwo =  names.stream().filter(name -> name.length() > 3).count();
        System.out.println("listNameExTwo = "+listNameExTwo);
        //!3
        List<String> listNameExThree =  names.stream().map(String::toUpperCase).distinct().sorted().toList();
        System.out.println("listNameExThree = "+listNameExThree);
        //!4
        Map<String, Long> listNameExFour1 =  names.stream()
                .collect(Collectors.groupingBy(name -> name,Collectors.counting()));

        System.out.println("listNameExFour1 = "+listNameExFour1);

        //!5
        String listNameExFive =  names.stream().filter(name -> name.length() > 3).findFirst().orElse("....");
        System.out.println("listNameExFive = "+listNameExFive);

        List<String> namesRound1 = Arrays.asList("alice", "Bob", "Alice", "John", "Bob", "Alice");


        //!
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }




}
