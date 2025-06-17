import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SubmissionPublisher;
import java.util.*;
import java.util.stream.Collectors;

public class DayFive {
    public static void main(String[] arg){


        //Input: arr = [1, 5, 7, -1, 5], target = 6
        //Expected Output: 3
        System.out.println("---(Do not count same pair twice, e.g., (1,5) and (5,1))");
        HashMap<Integer, Integer> Outputmap = new HashMap<>();
        int target =9;
        int count=0;
        int[] Input1 = {2, 7, 11, 15};
        for(int i =0;i<Input1.length;i++){
            int c = target - Input1[i];
            if(Outputmap.containsKey(c)){
                count += Outputmap.get(c);
            }
            Outputmap.put(Input1[i], Outputmap.getOrDefault(Input1[i],0)+1);
        }
        System.out.println(Outputmap);
        System.out.println(count);


        System.out.println("---Return the indices of the two numbers that add up to a given target.");
        //Input: nums = [2, 7, 11, 15], target = 9
        //Expected Output: [0, 1]
        HashMap<Integer, Integer> omap2 = new HashMap<>();
        int target1 =6;
        int count1=0;
        int[] Input2 = {1, 5, 7, -1, 5};
        for(int i=0;i<Input2.length;i++){
            int c = target1-Input2[i];
            if(omap2.containsKey(c)){
                System.out.println("["+omap2.get(c) + "," + i+"]");
            }
            omap2.put(Input2[i],i );
        }
        System.out.println(omap2);
        System.out.println(count1);


        //Count the number of distinct pairs of elements whose sum is equal to k.
        //Input: arr = [1, 2, 3, 4, 3], k = 6
        //Expected Output: 2
        System.out.println("---pairs: (2,4), (3,3)) – count only unique value pairs, not positions");
        int k = 6;
        int c2 = 0;
        HashMap<Integer,Boolean> map3 = new HashMap<>();
        int[] Input3 = {1, 2, 3, 4, 3};
        for(int i = 0;i<Input3.length;i++){
            int z = k - Input3[i];
            if(map3.containsKey(z) && !map3.get(z) && !map3.getOrDefault(Input3[i],false)){
                c2++;
                map3.put(Input3[i],true);
                map3.put(z,true);

            }
            map3.put(Input3[i],false);
        }
        System.out.println(map3);
        System.out.println(c2);


        //1. Group Words by Length
        //Input: ["hi", "hello", "apple", "to", "tea", "sun"]
        //Output: {2=[hi, to], 3=[tea, sun], 5=[hello, apple]}
        List<String> input4 = Arrays.asList("hi", "hello", "apple", "to", "tea", "sun");
        Map<Integer,List<String>> output4 = input4.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(output4);

        //Input: ["apple", "apricot", "banana", "blueberry", "cherry"]
        //Output: {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
        List<String> input5 = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry");
        Map<Character,List<String>> output5 = input5.stream()
                .collect(Collectors.groupingBy(s->s.charAt(0)));
        System.out.println(output5);

        //5. Group Numbers by Even or Odd
        //Input: [1, 2, 3, 4, 5, 6]
        //Output: {true=[2, 4, 6], false=[1, 3, 5]}
        List<Integer> Input6 = Arrays.asList(1,2,3,4,5,6);
        Map<Boolean,List<Integer>> output6 = Input6.stream()
                .collect(Collectors.groupingBy(a-> a%2 ==0));
        System.out.println(output6);

        //7. Group by Word Frequency
        //Input: ["apple", "banana", "apple", "orange", "banana", "apple"]
        //Output: {apple=3, banana=2, orange=1}
        //Use groupingBy + counting().
        List<String> Input7 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String,Long> output7 = Input7.stream()
                .collect(Collectors.groupingBy(s ->s,Collectors.counting()));
        System.out.println(output7);

         //8. Group Integers by Number of Digits
         //Input: [1, 23, 456, 78, 4, 1023]
        // Output: {1=[1,4], 2=[23,78], 3=[456], 4=[1023]}
        List<Integer> Input8 = Arrays.asList(1, 23, 456, 78, 4, 1023);
        Map<Integer, List<Integer>> output8 = Input8.stream()
                .collect(Collectors.groupingBy(s-> String.valueOf(s).length()));
         System.out.println(output8);

                //Contain Duplicates in the given array
                HashMap<Integer,Integer> seen = new HashMap<>();
                int[] nums = {1, 2, 3, 4, 3};
                int c = 0;
                boolean x = false;
                for(int i =0;i<nums.length;i++){
                    if(seen.containsKey(nums[i])){
                        x= true;
                        System.out.print(nums[i] + "-- duplicate ");
                    }
                    seen.put(nums[i],i);
                }
               System.out.println(seen);
               System.out.println(x);

               //Prefix sum logic
               int[] result = new int[nums.length];

               int sum = 0;

               for(int i =0;i<nums.length;i++){
                   sum += nums[i];
                   result[i] = sum;
                }

               //No Duplicates in given sub String
                int maxlen = 0;
                HashSet<Character> hs = new HashSet<>();
                int i=0;
                String s = "abcabcbb";
                for(int j=0;j<s.length();j++){

                    while(hs.contains(s.charAt(j))){
                        hs.remove(s.charAt(i));
                        i++;
                    }
                    hs.add(s.charAt(j));
                    maxlen = Math.max(maxlen,j-i+1);
                }
                System.out.println("Max-length of Sub-String : "+ maxlen);







    }
}
