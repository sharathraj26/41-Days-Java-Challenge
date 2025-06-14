import java.util.Arrays;
import java.util.stream.Collectors;

public class DayThree {
    public static void main(String[] args){

        // input : welcome home
        // output : emoh emoclew
        String input1 = "Welcome home";
        String output1 = Arrays.stream(input1.split(" ")).toList()
                .stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(output1);


        //1. Maximum Sum Sub-array of Size K
        //Problem: Given an array of integers and a number k, find the maximum sum of a sub-array of size k.
        //Input: arr = [2,1,5,1,3,2], k = 3
        //Output: 9 (from sub-array [5,1,3])
        //Tags: Easy
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
            System.out.println(val + " ");
        }

        //First Negative Number in Every Window of Size K
        //Problem: For each window of size k, print the first negative integer in that window. If none, print 0.
        //Input: arr = [12,-1,-7,8,-15,30,16,28], k = 3
        //Output: [-1, -1, -7, -15, -15, 0]
        //Tags: Medium
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
        for(int a : result){
            System.out.print(a+" ");
        }


        // 3. Count Occurrences of Anagrams
        //Problem: Given a string and a pattern, count how many anagrams of the pattern exist in the string using a fixed window.
        //Input: txt = "forxxorfxdofr", pat = "for"
        //Output: 3 (for, orf, ofr)
        //Tags: Medium

        


    }
    }

