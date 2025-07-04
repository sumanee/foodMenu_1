package com.promotion.food.unit;

import javax.swing.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.Long.sum;


public class TestFunction {


    public static  void main(String[]args){
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob", "Alice");
        List<String> result11 = names.stream()
                .map(String::toUpperCase)
                .toList();

       // List<String> result11 = names.stream().map(name->   name.toUpperCase()).toList();
        System.out.println("OK"+result11);

        Predicate<String> finNameSizeEqualThree = i -> i.length() == 3;
        List<String> result12 = names.stream().filter(finNameSizeEqualThree).collect(Collectors.toList());

        System.out.println("OK"+result12);

        Integer result13 = names.size();
        System.out.println("result13 = "+result13);

        Predicate<String> finNameNotEqualJohn = i -> !i.toLowerCase().equals("john");
        List<String> result14 = names.stream().filter(finNameNotEqualJohn).collect(Collectors.toList());
        System.out.println("result14 = "+result14);


        List<String> result15 = names.stream().distinct().sorted().toList();
        System.out.println("result15 = "+result15);
         //anyMatch อย่างน้อย allMatch ทุกค่า  noneMatch ไม่มีค่านี้เลย
        Predicate<String> finNameEqualJohn = i -> i.toLowerCase().equals("john");
        boolean result16 = names.stream().anyMatch(finNameEqualJohn);
        System.out.println("result16 = "+result16);


        Predicate<String> finNameLengthMothan = i -> i.length() > 2;
        boolean result17 = names.stream().allMatch(finNameLengthMothan);
        System.out.println("result17 = "+result17);

        Map<Integer,List<String>> result18 = names.stream()
                .collect(Collectors.groupingBy(name -> name.length()));
        System.out.println("result18 = "+result18);

        Map<String,Long> result19 = names.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy(name->name, Collectors.counting()));
        System.out.println("result19 = "+result19);

        String result20 = names.stream().map(String::toUpperCase).sorted()
                .collect(Collectors.joining(","));
        System.out.println("result20 = "+result20);


        String result21 = names.stream().reduce((name1, name2) -> {
                    if (name1.length() >= name2.length()) {
                        return name1; // ถ้ายาวเท่ากันหรือ name1 ยาวกว่า → เก็บ name1 (ตัวแรกที่เจอ)
                    } else {
                        return name2;
                    }
                })
                .orElse("ไม่มีชื่อ");
        System.out.println("result21 = "+result21);

        Map<Integer,Long> result22 = names.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy(name->name.length(), Collectors.counting()));
        System.out.println("result22 = "+result22);

        //Day 3
        System.out.println("------------");
        Map<Integer, List<String>> result23 = names.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy(name->name.length()));
        System.out.println("result23 = "+result23);


        Map<String, Long> result24 = names.stream().sorted()
                .collect(Collectors.groupingBy(name-> name,Collectors.counting()));
        System.out.println("result24 = "+result24);

        // เรียงตามค่า (จำนวนชื่อที่ซ้ำ) จากมากไปน้อย = reverseOrder   น้อยไปมาก = naturalOrder
        Map<String, Long> sortedResult24 = result24.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new // ✅ เพื่อรักษาลำดับ
                ));
        System.out.println("sortedResult24 = "+sortedResult24);

       String result25 = names.stream().sorted().collect(Collectors.joining("-"));
       System.out.println("result25 = "+result25);

        List<String> names1 = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob", "Alice","aaaaaaa");

       String result26 =  names1.stream().reduce((name1, name2) -> {
                    if (name1.length() >= name2.length()) {
                        return name1; // ถ้ายาวเท่ากันหรือ name1 ยาวกว่า → เก็บ name1 (ตัวแรกที่เจอ)
                    } else {
                        return name2;
                    }
                })
                .orElse("ไม่มีชื่อ");
        System.out.println("result26 = "+result26);


        Predicate<String> startWithA = i -> i.toLowerCase().startsWith("a");
        Long result27 = names.stream().filter(startWithA).count();
        System.out.println("result27 = "+result27);

        Predicate<String> lengthMoreThree = i -> i.length() > 3 && !i.toLowerCase().contains("o");;
        List<String> result28 = names.stream().filter(lengthMoreThree).collect(Collectors.toList());
        System.out.println("result28 = "+result28);


        List<String> result30 = names.stream().distinct().toList();
        System.out.println("result30 = "+result30);

        System.out.println("==================");
        Map<Integer,List<String>> result31 =  names.stream().map(String::toUpperCase).distinct()
                .collect(Collectors.groupingBy(name -> name.length()));
        System.out.println("result31 = "+result31);

        Map<String,List<String>> result32 =  names.stream().map(String::toUpperCase).distinct()
                .collect(Collectors.groupingBy(name -> name.substring(0,1)));
        System.out.println("result32 = "+result32);

        Predicate<String> findWithoutA = i ->  !i.toLowerCase().contains("a");;
        String result33 = names.stream().map(String::toLowerCase).filter(findWithoutA)
                .reduce((String name1 ,String name2) -> {
                    if(name1.length() > name2.length())
                    {
                        return  name2 ;
                    }
                    else {
                        return name1;
                    }
                }).orElse("Find not found");
        System.out.println("result33 = "+result33);


        Integer result35 =  names.stream().mapToInt(String::length).max().orElse(0);
               // .collect(Collectors.groupingBy(name -> name,Collectors.counting()))
        System.out.println("result35 = "+result35);

        Predicate<String> findLength = i ->  i.length() > 3;

        Map<Boolean,List<String>>  result36 = names.stream()
                .collect(Collectors.partitioningBy(findLength));
        System.out.println("result36 = "+result36);

        Predicate<String> result37_1 = i ->  !i.equals("Alice");

       String result37 = names.stream().filter(result37_1).collect(Collectors.joining(";"));
       System.out.println("result37 = "+result37);
        Integer sumData = 0;

        Integer result38 = names.stream().mapToInt(name -> name.length()).sum();

        System.out.println("result38 = "+result38);




    }




}
