import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SubmissionPublisher;

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

    }
}
