import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
public class DayThreeAndFour {
    public static void main(String[] args){

        // input : welcome home
        // output : emoh emoclew
        String input1 = "Welcome home";
        String output1 = Arrays.stream(input1.split(" ")).toList()
                .stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(output1);


        //Maximum Sum Sub-array of Size K
        //Problem: Given an array of integers and a number k, find the maximum sum of a sub-array of size k.
        //Input: arr = [2,1,5,1,3,2], k = 3
        //Output: 9 (from sub-array [5,1,3])
        //Tags: Easy
        System.out.println("-----------------------------------------");
        int[] arr = {2, 1, 2, 1, 5, 1, 3, 2};
        int k = 3;
        int maxSum = 0;
        int[] maxArr = new int[k];

        for (int i = 0; i <= arr.length - k; i++) {
            int curSum = 0;
            for (int j = 0; j < k; j++) {
                curSum += arr[i + j];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                for (int j = 0; j < k; j++) {
                    maxArr[j] = arr[i + j];
                }
            }
        }

        System.out.println("Maximum Sum: " + maxSum);
        System.out.print("Max Sub-array: ");
        for (int val : maxArr) {
            System.out.print(val + " ");
        }
        System.out.println();

        //First Negative Number in Every Window of Size K
        //Problem: For each window of size k, print the first negative integer in that window. If none, print 0.
        //Input: arr = [12,-1,-7,8,-15,30,16,28], k = 3
        //Output: [-1, -1, -7, -15, -15, 0]
        //Tags: Medium
        System.out.println("-----------------------------------------");
        int arr2[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k2 = 3;
        int n = arr2.length;
        int[] result = new int[n - k2 + 1];

        for(int i =0;i <= arr2.length - k2;i++){
            boolean found = false;
            for(int j=i;j<i+k2;j++){
                if(arr2[j] < 0){
                    result[i] = arr2[j];
                    found = true;
                    break;
                }
            }
            if(!found){
                result[i] = 0;
            }
        }
        System.out.print("All First Naegitive in Sub-array: ");
        for(int a : result){
            System.out.print(a+" ");
        }
        System.out.println();


        //Maximum of All Sub-arrays of Size K
        //Problem: Return an array of the maximum values from every contiguous sub-array of size k.
        //Input: arr = [1,3,-1,-3,5,3,6,7], k = 3
        //Output: [3,3,5,5,6,7]
        //Tags: Hard
        //Hint: Use a deque for O(n) time.
        System.out.println("-----------------------------------------");
        int[] input3 = {1,3,-1,-3,5,3,6,7};
        int[] rarr = new int[input3.length-3+1];
        for(int i = 0;i <= input3.length-3;i++){
            int max = 0;
            for(int j=i;j<i+3;j++){
                if(input3[j]>max){
                    max = input3[j];
                }
            }
            rarr[i] = max;
        }
        System.out.print("All Max in Sub-array: ");
        for(int a: rarr){
            System.out.print(a+" ");
        }
        System.out.println();

        //Find K Closest Elements (can simulate with sliding window)
        //Problem: Find the k closest elements to a given value x in a sorted array.
        //Input: arr = [1,2,3,4,5], k = 4, x = 3
        //Output: [1,2,3,4]
        //Tags: Medium (uses binary search + window idea)
        System.out.println("-----------------------------------------");
        int x=3;
        int q=4;
        int[] input4 = {1,2,3,4,5};
        int[] result4 = new int[input4.length - x +1];
        for(int i=0;i<=input4.length - x;i++){
            int l = input4[i];
            for(int j=i;j<i+x;j++){
                if(input4[j] < l ){
                    l = input4[j];
                }
            }
            result4[i] = l;
        }

        for(int rs : result4){
            System.out.print(rs + "");
        }
        System.out.println();


        //Sort a list of strings by increasing length.
        //Input: ["apple", "bat", "banana", "a"]
        //Expected Output:["a", "bat", "apple", "banana"]
        List<String> input5 = Arrays.asList("apple", "bat", "banana", "a");
        List<String> output5 = input5.stream()
                .sorted()
                .toList();
        System.out.println("Stream sort -"+output5);

        //Given a list of words, return the top 3 longest words, in descending order of length.
        //Input: ["java", "stream", "comparator", "code", "practice"]
        //Expected Output: ["comparator", "practice", "stream"]
        List<String> input6 = Arrays.asList("raja9830","java", "stream", "comparator", "code", "practice");
        List<String> output6 = input6.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(3)
                .toList();
        System.out.println("Longest String -"+ output6);


        //Given a list of words, extract all distinct characters used across all words, sorted.
        //Input:["apple", "banana"]
        //Expected Output: [a, b, e, l, n, p]
        List<String> input7 = Arrays.asList("apple","banana");
        List<String> output7 = input7.stream()
                .flatMap(a->Arrays.stream(a.split("")))
                .distinct()
                .sorted()
                .toList();
        System.out.println( "List of Distinct words in list -" + output7);

        //Group a list of words by their first letter.
        //Input: ["apple", "ant", "banana", "bat", "cat"]
        //Expected Output (Map):
        //a -> [apple, ant]
        //b -> [banana, bat]
        //c -> [cat]
        List<String> input8 = Arrays.asList("apple", "ant", "banana", "bat", "cat");
        Map<Character,List<String>> output8 = input8.stream()
                .collect(Collectors.groupingBy(a->a.charAt(0)));
        System.out.println(output8);

        //Given a list of words, count the frequency of each word using streams.
        //Input: ["apple", "banana", "apple", "apple", "banana", "cherry"]
        //Expected Output: {apple=3, banana=2, cherry=1}
        List<String> input9 = Arrays.asList("apple", "banana", "apple", "apple", "banana", "cherry");
        Map<String, Long> output9 = input9.stream()
                .collect(Collectors.groupingBy(word-> word ,TreeMap:: new ,Collectors.counting()));
        System.out.println(output9);

    }
    }

