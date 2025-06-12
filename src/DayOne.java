import java.util.*;
public class DayOne {
    public static void main(String[] args){
        String a = "2a3b3c";
        //it should be print 2aa3bbb3ccc
        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int i =0;i<a.length();i++){
            if(i%2==0){
                count = Character.getNumericValue(a.charAt(i));
                result.append(a.charAt(i));
                for(int j =0;j<count;j++){
                    result.append(a.charAt(i+1));
                }
            }
        }
        System.out.println("The Expected Output : "+result.toString());
    }
}
