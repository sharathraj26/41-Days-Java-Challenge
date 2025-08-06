package Concepts.Arrays;

public class Easy {
    public static void main(String[] args){
        int[] a = {2,4,5,3,1};
        int max = a[0];
        int min = a[0];
        boolean search = false;
        int e = 9;
        //Sort The given Array
        for(int i = 0;i<a.length;i++){
            for(int j =i+1;j<a.length;j++){
                if(a[i] > a[j]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }

            //find Max Element
            if(a[i] > max)
                max = a[i];

            //find Min Element
            if(a[i] < min)
                min = a[i];

            //Find Element
            if(a[i] == e)
                search = true;

        }
        System.out.println("Sorted Array");
        for(int x : a)
            System.out.print(x);
        System.out.println();
        System.out.println("Maximum Element in Array : " + max);
        System.out.println("Minimum Element in Array : " + min);
        System.out.println("Search Element in Array : " + search);
    }
}
