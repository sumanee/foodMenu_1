package com.promotion.food.unit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestFunction1 {
    public static  void main(String[]args){
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob", "Alice");

        Map<Integer,List<String>> result41 =  names.stream().map(String::toUpperCase)
                .collect(Collectors.groupingBy(String::length));
        System.out.println("result41"+result41);

      Map<String,Long> result42 = names.stream().map(name -> name.toLowerCase().substring(0,1))
                .collect(
                        Collectors.groupingBy(
                                name -> name.toLowerCase().substring(0,1),Collectors.counting()
                        )
                );
        System.out.println("result41"+result42);
/*หาค่ารวม: .mapToInt(String::length).sum()

หาค่ามากสุด: .mapToInt(String::length).max().orElse(0)

หาค่าที่ไม่ซ้ำ: .map(String::length).distinct().toList()*/
        Map<String, Integer> result44 = names.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy
                        (
                        name -> name,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        count-> 0
                                        )
                        )
                );

        Map<String, Integer> finalResult44 = new HashMap<>();
        for (String name : result44.keySet()) {
            long count = names.stream().filter(n -> n.equalsIgnoreCase(name)).count();
            finalResult44.put(name, name.length() * (int) count);
        }

        System.out.println("finalResult44"+finalResult44);

        Map<Character, Long> result45 = names.stream()
                .map(String::toLowerCase)
                .flatMap(name -> name.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("result45="+result45);

        Map<Boolean, List<String>> result46 = names.stream()
                .collect(Collectors.partitioningBy(name -> name.toLowerCase().contains("o")));
        System.out.println("result46="+result46);

        String result47 = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> entry.getKey() + "(" + entry.getValue() + ")")
                .collect(Collectors.joining(","));

        System.out.println("result47="+result47);

        Map<Integer, String> result48 = names.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> String.join("|", list)
                        )
                ));
        System.out.println("result48="+result48);


        Map<Integer, List<String>> result49 = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(String::length));
        System.out.println("result49="+result49);

        Map<String, Long>  result50 =  names.stream()
                .collect(Collectors.groupingBy(name -> name ,Collectors.counting()));
        System.out.println("result50="+result50);

        Map<String, Long>  result51 = names.stream().map(String::toLowerCase)
               .flatMap(name -> Arrays.stream(name.split("")))
               .collect(Collectors.groupingBy(r -> r,Collectors.counting()));

        System.out.println("result51="+result51);


        ;


    }
}
