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

//        Input: ["java", null, "python", null]
//        Output: ["java", "python"]
        List<String> s = Arrays.asList("java", null, "python", null);
        List<String> r = s.stream()
                .filter(Objects::nonNull)
                .toList();
        System.out.println(r);

        // Input: ["Alice", "Bob", "Ankit", "Mike"]
       //  Output: ["Alice", "Ankit"]
        List<String> input1 = Arrays.asList("Alice", "Bob", "Ankit", "Mike");
        List<String> output1 = input1.stream()
                .filter(n -> n.startsWith("A"))
                .toList();
        System.out.println(output1);

        // Input: ["java", "stream", "filter", "map"]
        // Output: 2 (stream, filter)
        List<String> input2 = Arrays.asList("java", "stream", "filter", "map");
        List<String> output2 = input2.stream()
                .filter(n -> n.length()>4)
                .toList();
        System.out.println(output2);

         // Input: ["John Doe", "Alice Smith", "Bob Marley"]
        // Output: ["John", "Alice", "Bob"]
        List<String> input3 = Arrays.asList("John Doe", "Alice Smith", "Bob Marley");
        List<String> output3 =  input3.stream()
                .map(i ->  i.split(" ")[0])
                .toList();
        System.out.println(output3);


          // new User("Alice", 25),
          // new User("Bob", 16),
          // new User("John", 30)
          // output should be age greater than 18
        class User {
            String name;
            int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }
      List<User> users = Arrays.asList(
              new User("Alice", 25),
              new User("Bob", 16),
              new User("John", 30));

        List<String> users1 = users.stream()
                .filter(user -> user.getAge()> 18)
                .map(User::getName)
                .toList();
        System.out.println(users1);
    }
}
