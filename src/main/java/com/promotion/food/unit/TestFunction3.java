package com.promotion.food.unit;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestFunction3 {

    public static void checkFizzBuzz(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }

    public static  void main(String[]args) {


        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob", "Alice");


        List<String> dataReturnEhgit = names.stream()
                .map(String::toUpperCase)
                .filter(name-> name.length() > 3).distinct().toList();
        System.out.println("dataReturnEhgit"+dataReturnEhgit);


        List<String> dataReturn = names.stream().map(String::toUpperCase).toList();

        System.out.println(dataReturn);

        Map<String,Long>  dataReturn1 = names.stream()
                .collect(Collectors.groupingBy(s -> s,Collectors.counting()));
        System.out.println(dataReturn1);

        // 2
        String textReverse = "Hello";
        String reversed = new StringBuilder(textReverse).reverse().toString();
        System.out.println("textReverse" + reversed);


        List<Integer> dataFive = Arrays.asList(10, 40, 20, 50, 30);
        Optional<Integer> max = dataFive.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println("max" + max);

        String min = dataFive.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder())).toString();

        System.out.println("min" + min);

        List<Integer> arraySort = dataFive.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("arraySort" +  arraySort);


        List<Integer> dataSix = Arrays.asList(1,2,3,4,5,6);

        int returnSix =  dataSix.stream().filter(m-> m % 2 == 0)
                .mapToInt(Integer::intValue).sum();
        System.out.println("returnSix" + returnSix);



       String dataTen = "I love Java and I love Spring";
        Map<String,Long>  returnTen = Arrays.stream(dataTen.split(" "))
                .collect(Collectors.groupingBy(s -> s,LinkedHashMap::new, Collectors.counting()));
        System.out.println("returnTen" + returnTen);


        List<Integer> numbers = Arrays.asList(5, 3, 2, 5, 1, 2, 4, 3);
        System.out.println("returnTen" +   numbers.stream().distinct().sorted().toList());

        Integer a = 12345;
        List<String>  sList =  Arrays.stream(a.toString().split("")).toList();
        List<Integer> integerList1 = sList.stream().map(n -> Integer.parseInt(n)).toList();
        Integer resuly = integerList1.stream().mapToInt(Integer::intValue).sum();


        int result = Arrays.stream(a.toString().split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("resuly=" + resuly);


        String text = "I love Java programming";
        Predicate<String> countVowels = i -> i.equals("A") || i.equals("E") || i.equals("I") || i.equals("O") || i.equals("U") ;

        long  textList = text.toUpperCase().chars().filter(c -> "AEIOU".indexOf(c) >= 0).count();

        System.out.println("textList=" + textList);

        int[] arr = {10, 20, 5, 8, 30, 25};

        System.out.println("textList=" +   Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null));


        String sentence = "I love Java";

        String[] words = sentence.split(" ");
        Collections.reverse(Arrays.asList(words));
        String reversedSentence = String.join(" ", words);
        System.out.println(reversedSentence); // Output: Java love I

    }

}

