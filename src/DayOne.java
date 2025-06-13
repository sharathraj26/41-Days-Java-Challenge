import java.util.*;
import java.util.stream.Collectors;

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


    //Learning Concepts of filter(), map(), collect().

    // stream.filter(element -> condition)
    List<Integer> list =  Arrays.asList(1,2,3,4,3,4,5);
    List<Integer> resultList = list.stream().filter(n -> n %2 == 0)
            .collect(Collectors.toList());
    System.out.println(resultList);

   // stream.map(element -> transformation)
   List<String> strList = Arrays.asList("bhanu","sharath","ram","lakshman","ram");
   List<String> streamList = strList.stream()
                   .distinct()
                   .map(name -> name.toUpperCase())
                   .collect(Collectors.toList());
        System.out.println(streamList);

   //stream.collect(Collectors.toList()) // or toSet(), joining(), groupingBy() etc.
        String name1 = strList.stream()
                .distinct()
                .collect(Collectors.joining(" "));
        System.out.println(name1);

        String name = String.join(" ", strList);// with lambda if there is null value in list it throws Null pointer exception.
        System.out.println(name);

    }
}
