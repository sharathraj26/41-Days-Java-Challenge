import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class PracticeCoding {
    public static void main(String[] arg) {
        //aabbbcc it should be 2a3b2c
        String s = "aabbbcc";
        StringBuilder str = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                str.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        str.append(count).append(s.charAt(s.length() - 1));
        System.out.println(str);
        System.out.println("------------------------");




        //Revers words in sendence
        String z = "Java is object oriented";
          String[] x = z.split(" ");
        for(int i=x.length -1 ;i>=0;i--){
           System.out.print(x[i] + " ");
        }
        System.out.println();
        System.out.println("------------------------");



        //find first non-repeated Character swish is "w"
        String e1 = "swish";
        int cont = 1;
        LinkedHashMap<Character,Integer> seen = new LinkedHashMap<>();
        for(int i = 0;i<e1.length();i++){
                seen.put(e1.charAt(i),seen.getOrDefault(e1.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry : seen.entrySet()){
            if (entry.getValue() == 1){
            System.out.println("First non-repeated character: " + entry.getKey());
            return;}
        }
        System.out.println("------------------------");



        //Check list and istl is same or not
        String s1 = "List";
        String s2 = "istl";
        if(IsAnagram(s1,s2)){
            System.out.println("Yes, It is Matching String.");
        }else{
            System.out.println("No, It not Matching String");
        }

    }
    public static boolean IsAnagram(String a, String b){
        a = a.toLowerCase();
        b = b.toLowerCase();
        if(a.length() != b.length()){
            return false;
        }
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);

        return Arrays.equals(a1, b1);

    }
}
