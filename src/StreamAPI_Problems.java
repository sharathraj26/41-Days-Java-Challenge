import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
class Employee1 {
    String name;
    String dept;
    int salary;

    public Employee1(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class StreamAPI_Problems {

    public static void main(String[] args){

        //Input:
        //List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 1, 2, 4, 4, 4, 5, 1);
        //Expected Output: [4, 2, 1]  // 4 occurs 4 times, 2 - 3 times, 1 - 3 times
        int[] arr = {1, 2, 3, 2, 4, 1, 2, 4, 4, 4, 5, 1};
         List<Integer> output= Arrays.stream(arr)
                 .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                  .entrySet()
                  .stream()
                 .sorted(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder()))
                 .limit(3)
                 .map(Map.Entry::getKey)
                 .toList();
        System.out.println(output);

        List<Employee1> emps = Arrays.asList(
                new Employee1("Alice", "HR", 3000),
                new Employee1("Bob", "IT", 5000),
                new Employee1("Charlie", "IT", 4500),
                new Employee1("David", "HR", 3200)
        );
        Map<String, List<String>> em= emps.stream()
                        .collect(Collectors.groupingBy(
                                Employee1::getDept
                               ,Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list1 -> list1.stream()
                                                .map(Employee1::getName)
                                                .toList()
                                )        ));
                            System.out.println(em);



        //String str = "JavaStreamAPI";
        //Expected Output: [a, A]
        String str = "JavaStreamAAPI";
        int c = 1;
        LinkedHashMap<Character,Integer> ma = new LinkedHashMap<>();
         for(int i=0;i<str.length();i++){

             if(!ma.containsKey(str.charAt(i))){
                 ma.put(str.charAt(i),0);
             }
             ma.put(str.charAt(i),ma.get(str.charAt(i))+1);
         }
         List<Character> i = new ArrayList<>();
         for(int j=0;j<str.length();j++) {
             if (ma.get(str.charAt(j)) > 1 && !i.contains(str.charAt(j))) {
                 i.add(str.charAt(j));
             }
         }
        System.out.println(i);

         List<String> str1 = Arrays.stream(str.split(""))
                 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                 .entrySet()
                 .stream()
                 .filter(n->n.getValue()>1)
                 .map(Map.Entry::getKey)
                 .toList();
         System.out.println(str1);

        // Input : Map<String, List<String>> map = Map.of(
        //    "A", List.of("apple", "ant"),
        //    "B", List.of("banana", "bat"),
        //    "C", List.of("cat")
        //);
        // Expected Output: [ant, apple, banana, bat, cat]
        Map<String, List<String>> map1 = Map.of(
                "A", List.of("apple", "ant"),
                "B", List.of("banana", "bat"),
                "C", List.of("cat")
        );
       List<String> result = map1.values().stream()
               .flatMap(Collection::stream)
               .sorted()
               .toList();
         System.out.println(result);

          // Input:
         //  String input = "swiss";
        //   Expected Output: 'w'

        String input = "swiss";
        LinkedHashMap<Character,Integer> jap = new LinkedHashMap<>();
        for(int q =0;q<input.length();q++){
            if(!jap.containsKey(input.charAt(q))){
                jap.put(input.charAt(q),0);
            }
            jap.put(input.charAt(q),jap.getOrDefault(input.charAt(q),0)+1);
        }

        List<Character> o = new ArrayList<>();
        for(int z=0;z<input.length();z++){
            if(jap.get(input.charAt(z))==1){
                o.add(input.charAt(z));
            }
        }

        System.out.println(jap);
        System.out.println("This is from strings ---  "+o.getFirst());


       String qa = Arrays.stream(input.split(""))
               .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
               .entrySet()
               .stream()
               .filter(n->n.getValue()==1)
               .map(Map.Entry::getKey)
               .findFirst()
               .orElse("");
       System.out.println("This is from Streams ---  "+qa);




    }

}
