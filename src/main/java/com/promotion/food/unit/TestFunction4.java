package com.promotion.food.unit;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.*;
import java.util.*;


public class TestFunction4 {
    public static int[] twoSum() {
        int[] nums = {3,2,1,4};
        int target = 6;

        Map<Integer, Integer> map = new HashMap<>(); // เก็บค่า -> ดัชนี

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println("complement="+complement);

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
            System.out.println("complement="+map);

        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static String checkFizzBuzz(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }
    public static Boolean checkPanama(String text) {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();
        return processed.equals(reversed);




    }
    public static  void main(String[]args) {

        int[] result = twoSum();  // เรียกใช้ฟังก์ชัน
        System.out.println("result=" +Arrays.toString(result));


        String textOne = "hello";
        String resultOne = "";
        for (int i = textOne.length() - 1; i >= 0; i--) {
            resultOne += textOne.charAt(i);
        }
        String reversed = new StringBuilder(textOne).reverse().toString();
        System.out.println("reversed=" + reversed);
        System.out.println("resultOne=" + resultOne);

        List<Integer> dataTwo = Arrays.asList(10, 30, 5, 50, 20);
      // int resultTwo =  dataTwo.stream().distinct().sorted(Comparator.reverseOrder()).findFirst().orElse(0);
        Optional<Integer> resultTwo = dataTwo.stream().max(Comparator.naturalOrder());
        System.out.println("resultTwo=" + resultTwo);

        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob", "Alice");

        List<String> resultThree = names.stream().distinct().toList();
        System.out.println("resultThree=" + resultThree);

        Map<String, Long> countMap = names.stream()
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));

        LinkedHashMap<String, Long> sortedMap = countMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        sortedMap.forEach((k, v) -> System.out.println(k + " = " + v));
        System.out.println("resultFour=" + sortedMap);

      //  List<Integer> newOne = Arrays.asList(1,3,5,7,8);
        List<Integer> newOne = Arrays.asList(1,3,5);

        List<Boolean> stepOne = newOne.stream().map(integer -> integer % 2 == 0).toList();
        Predicate<Boolean> finNameEqualJohn = a -> a;
        System.out.println("resultFour=" +  stepOne.stream().anyMatch(finNameEqualJohn));


        List<String> input = Arrays.asList("10", "20", "abc", "30");
        List<Integer> returnTwo = input.stream()
                .flatMap(s -> {
                    try {
                        return Stream.of(Integer.parseInt(s));
                    } catch (NumberFormatException e) {
                        return Stream.empty(); // ถ้า parse ไม่ได้ ข้าม
                    }
                })
                .toList();
        System.out.println("resultFour=" +  returnTwo);


        List<Integer> newThree = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> returnThree = newThree.stream()
                .filter(integer -> integer % 2 == 0)
                .toList();
        System.out.println("returnThree=" +  returnThree);

        List<Integer> newFour = Arrays.asList(10, 25, 3, 47, 22);

        System.out.println("returnThree=" +    newFour.stream().max(Comparator.naturalOrder()).orElse(null));


        List<String> newFive = Arrays.asList("Java", "Spring", "Boot");
        System.out.println("returnThree=" +  newFive.stream().collect(Collectors.joining("-")));

        List<Integer> newSix = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
        Map<Integer, Long> returnSix = newSix.stream()
                .collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));
        Set<Integer> returnSixTwo = returnSix.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)  // เอา key ออกมา
                .collect(Collectors.toSet());


        System.out.println("returnSixTwo=" + returnSixTwo);

        String textServen = "A man a plan a canal Panama";
        String a = Arrays.stream(textServen.toLowerCase().split(" ")).collect(Collectors.joining(""));
        String b = new StringBuilder(a).reverse().toString();

        System.out.println("returnSixTwo=" + a.equals(b));



        List<String> inputA = Arrays.asList("Java", "Spring", "Boot");

        LinkedHashMap<String, Integer> outputA =  inputA.stream()
                .collect(Collectors.toMap(
                s -> s,
                s -> s.length(),
                (e1, e2) -> e1,
                LinkedHashMap::new
        ));

        System.out.println("returnSixTwo=" +outputA);
        List<Integer> inputB = Arrays.asList(5, 10, 15, 20);


        System.out.println("mapToInt=" + inputB.stream() .mapToInt(Integer::intValue).sum());


        Map<String, Integer> inputC = Map.of("a", 10, "b", 20, "c", 30);

        double average = inputC.entrySet().stream()
                .collect(Collectors.averagingInt(Map.Entry::getValue));


        List<String> inputD = Arrays.asList("Java", "Spring", "Boot");


        System.out.println("mapToInt=" +  inputD.stream().sorted(Comparator.naturalOrder()).toList());
        List<Integer> inputF = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("mapToInt=" +  inputF.stream().filter(a1 -> a1 % 2 != 0).toList());

        System.out.println("mapToInt=" +   inputF.stream().max(Comparator.naturalOrder()).orElse(0));


        List<Integer> inputG = Arrays.asList(1,2,3,4,5);


        System.out.println("mapToInt=" +    inputG.stream().filter(integer -> integer %2 == 0).mapToInt(Integer::intValue).sum());

    }





}
