
import java.util.*;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collector;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DaySix {

    public static boolean isPrime(int n) {
        return n>1 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i->n%i != 0);
    }
   public static void main(String[] args){


       //In Java 8 write the factorial program for n = 5
       int n = 5;
       int output1 = IntStream.rangeClosed(1,n).reduce(1,(a,b)->a*b);
       System.out.println("Factorial : - "+ output1);


       //Find prime number in given list
       List<Integer> input2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
       List<Integer> output2 = input2.stream()
               .filter(DaySix::isPrime)
               .toList();
       System.out.println("Prime numbers : - "+ output2);

       //1. Reverse List Using Custom Collector
       //Input: List<String> input = Arrays.asList("apple", "banana", "cherry");
       //Expected Output: ["cherry", "banana", "apple"]
       List<String> input3 = Arrays.asList("apple", "banana", "cherry");
       List<String> output3 = input3.stream()
               .collect(Collector.of(
                       ArrayList :: new,
                       (list,item) -> list.add(0,item),
                       (left,right) -> {right.addAll(left); return right;}

               ));
       System.out.println("List Reversed: " + output3);


       //2. Concatenate Uppercase Words with Dash
       //Input:List<String> input = Arrays.asList("a", "b", "c");
       //Expected Output:"A-B-C"
       //Hint: Use a StringBuilder in a custom collector, append toUpperCase() and join with -.
       List<String> input4 = Arrays.asList("a", "b", "c");
       String output4 = input4.stream()
               .map(String::toUpperCase)
               .collect(Collectors.joining("-"));
       System.out.println("String concatination : "+output4);



       
   }
}
