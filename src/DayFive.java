import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class DayFive {
    public static void main(String[] arg){


        //Input: arr = [1, 5, 7, -1, 5], target = 6
        //Expected Output: 3
        //(Do not count same pair twice, e.g., (1,5) and (5,1))
        HashMap<Integer, Integer> Outputmap = new HashMap<>();
        int target =6;
        int count=0;
        int[] Input1 = {1, 5, 7, -1, 5};
        for(int i =0;i<Input1.length;i++){
            int c = target - Input1[i];
            if(Outputmap.containsKey(c)){
                count += Outputmap.get(c);
            }
            Outputmap.put(Input1[i], Outputmap.getOrDefault(Input1[i],0)+1);
        }
        System.out.println(Outputmap);
        System.out.println(count);








    }
}
