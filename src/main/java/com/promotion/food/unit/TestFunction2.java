package com.promotion.food.unit;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestFunction2 {

        public static  void main(String[]args){
            List<String> names = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob", "Alice");
            List<String> result1 = names.stream().distinct().sorted().toList();
            System.out.println("Result1="+ result1);

            List<String> result2 = names.stream().skip(2).toList();
            System.out.println("result2="+ result2);

            List<String> result3 = names.stream().limit(3).toList();
            System.out.println("result3="+ result3);

            Predicate<String> check4 = i -> i.length() > 2;
            boolean result4 =  names.stream().allMatch(check4);
            System.out.println("result4="+ result4);


            Predicate<String> check5 = i -> i.toLowerCase().equals("bob");
            boolean result5 =  names.stream().allMatch(check4);
            System.out.println("result5="+ result5);

            Predicate<String> check6 = i -> i.length() < 3;
            boolean result6 =  names.stream().noneMatch(check6);
            System.out.println("result6="+ result6);

           String result7 = names.stream().collect(Collectors.joining("|"));
            System.out.println("result7="+ result7);

            List<String> result8 = names.stream()
                    .flatMap(name -> Arrays.stream(name.split(""))).toList();
            System.out.println("result8="+ result8);

            Predicate<String> check9 = i -> i.length() > 3;
            List<String> result9 = names.stream()
                    .filter(check9)
                    .peek(name -> System.out.println("ผ่าน filter: " + name)) // peek ดูค่าก่อน collect.toList();
                    .toList();
            System.out.println("result9="+ result9);


            Map<String,Long> result17 = names.stream()
                    .flatMap(name -> Arrays.stream(name.split("")))
                    .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

            System.out.println("result17="+ result17);
            List<String> newNames = Arrays.asList("Alice", "Bob", "Alice", "David", "Eve");

            Map<Character, Long> result21 = names.stream()
                    .flatMap(name -> name.toLowerCase().chars().mapToObj(c -> (char) c))
                    .filter(ch -> ch >= 'a' && ch <= 'z') // เฉพาะตัวอักษร
                    .collect(Collectors.groupingBy(
                            ch -> ch,
                            Collectors.counting()
                    ));
            System.out.println("result21="+ result21);
        }
}
