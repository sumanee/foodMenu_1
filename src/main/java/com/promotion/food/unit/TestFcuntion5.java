package com.promotion.food.unit;

import java.util.*;
import java.util.stream.Collectors;

public class TestFcuntion5 {
    public static  void main(String[]args){
        List<String> data1 = new ArrayList<>();
        data1.add("A");
        data1.add("B");
        data1.add("C");

        System.out.println(data1);

        List<String> data2 = new ArrayList<>();
        data2.add("A");
        data2.add("B");
        data2.add("C");
        data2.add("A");
        System.out.println(data2);

        Set<Integer> data3 = new HashSet<>();
        data3.add(1);
        data3.add(2);
        data3.add(3);
        data3.add(2);

        TreeSet<String> data4 = new TreeSet<>();

        data4.add("Banana");
        data4.add("Apple");
        data4.add("Orange");


        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");

       Map<String,Long> dataOne =  words.stream()
                .collect(
                        Collectors.groupingBy(string ->  string.substring(0,1),Collectors.counting()));

        System.out.println(dataOne);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.stream().collect(Collectors.partitioningBy(n-> n%2==0));
        System.out.println(  numbers.stream().collect(Collectors.partitioningBy(n-> n%2==0)));
        List<String> names = Arrays.asList("John", "Jane", "Bob");

        System.out.println(names.stream().collect(Collectors.joining(",")));

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5,6));

        List<Integer> a = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(a);

         List<Integer> nums = Arrays.asList(10, 20, 5, 7, 30);
        System.out.println(nums.stream().max(Comparator.naturalOrder()).orElse(0));

        List<String> words1 = Arrays.asList("car", "bike", "bus", "train", "truck");
        System.out.println(   words1.stream().collect(Collectors.groupingBy(String::length)));

        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println( fruits.stream().collect(Collectors.groupingBy(s-> s,Collectors.counting())));

        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");

        System.out.println(  items.stream().collect(Collectors.toSet()));


        List<Integer> nums1 = Arrays.asList(5, 10, 15, 20);

        System.out.println(  nums1.stream().mapToInt(Integer::intValue).summaryStatistics().getSum());
        System.out.println(  nums1.stream().mapToInt(Integer::intValue).sum());



    }
}
