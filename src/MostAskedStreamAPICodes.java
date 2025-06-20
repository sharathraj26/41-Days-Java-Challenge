import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class Employee {
    String name;
    int salary;
    String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() { return name; }
    public int getSalary() { return salary; }
    public String getDepartment() { return department; }
}

public class MostAskedStreamAPICodes {

    public static final Object lock = new Object();
    public static boolean changeTurn = true;

    public static void main(String[] args){

        String str = "RAR";
        String s1 = "";
        for(int i =str.length()-1;i>=0;--i){
            char ar[] = str.toCharArray();
            s1 += ar[i];
        }
        System.out.println(str.equals(s1));


        //Input: List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        //Output: 2, 4, 6
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        System.out.println(nums.stream()
                .filter(n->n%2==0)
                .toList());


        //Input: ["apple", "banana", "cherry"]
        //Output: ["APPLE", "BANANA", "CHERRY"]
        List<String> names = Arrays.asList("apple", "banana", "cherry");
        System.out.println(names.stream()
                .map(String::toUpperCase)
                .toList());


        //Input: [apple, banana, apple, orange, banana, banana]
        //Output: {apple=2, banana=3, orange=1}
        List<String> names1 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
        System.out.println(names1.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));


        //Input: "aabccdbe"
        //Output: e
        String s2 = "aabccddbetg";
        LinkedHashMap<Character,Integer> seen = new LinkedHashMap<>();
        for(int i=0;i<s2.length();i++){
            seen.put(s2.charAt(i),seen.getOrDefault(s2.charAt(i),0)+1);
            }
        System.out.println(seen);
        //Stream api
        Character result = s2.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(d-> d, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(n-> n.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(result);

        //Input: [1, 2, 2, 3, 4, 4, 4, 5]
        //Output: [2, 4]
        List<Integer> List = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
        Set<Integer> seen1 = new HashSet<>();
        System.out.println(List.stream()
                .filter(n->!seen1.add(n))
                .collect(Collectors.toSet()));

        //Input: "programming"
        //Output: [r, g, m]
        String name = "programming";
          name.chars()
                .mapToObj(n->(char)n)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(n->n.getValue()>1)
                .map(Map.Entry::getKey)
                  .forEach(System.out::println);

            //Sample Input:
            //List<Employee> employees = Arrays.asList(
            //    new Employee("Alice", 70000, "HR"),
            //    new Employee("Bob", 50000, "IT"),
            //    new Employee("Charlie", 60000, "Finance")
            //);
            //Expected Output:
            //Bob - 50000
            //Charlie - 60000
            //Alice - 70000
        List<Employee> employees = Arrays.asList(
                    new Employee("Alice", 70000, "HR"),
                    new Employee("Bob", 50000, "IT"),
                    new Employee("Charlie", 60000, "Finance")
                );
         employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                 .forEach(a->System.out.println(a.getName()+ " "+ a.getSalary()));

         Map<String ,List<Employee>> ls = employees.stream()
                 .collect(Collectors.groupingBy(Employee::getDepartment));
         System.out.println(ls);


//                Thread t1 = new Thread(() -> {
//                    for(char a ='A';a<='Z';a++) {
//                        synchronized (lock){
//                            while(!changeTurn) {
//                                try {
//                                    lock.wait();
//                                }catch(InterruptedException e) {
//                                    System.out.print(e);
//                                }
//                            }
//                            System.out.print(a+" ");
//                            changeTurn = false;
//                            lock.notifyAll();
//                        }
//                    }
//                });
//
//                Thread t2 = new Thread(() -> {
//                    for(int i =1;i<=26;i++) {
//                        synchronized(lock) {
//                            while(changeTurn) {
//                                try {
//                                    lock.wait();
//                                } catch(InterruptedException e) {
//                                    System.out.print(e);
//                                }
//                            }
//                            System.out.print(i + " ");
//                            changeTurn = true;
//                            lock.notifyAll();
//                        }
//                    }
//                });
//
//                t1.start();
//                t2.start();

                //String = hello
                //olleh using java 8
                String S = "hello";
                String rw = Arrays.stream(S.split(S.toUpperCase())).toList().stream()
                        .map(n->new StringBuilder(n).reverse().toString())
                        .collect(Collectors.joining(""));
                System.out.println(rw);

                //Factorial in java 8
                //120
                int n=5;
                System.out.println(IntStream.rangeClosed(1,n)
                        .reduce(1,(a,b)->a*b));

                String out = "aaeededarrarrrr";
                Character a = out.chars()
                        .mapToObj(c->(char)c)
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Comparator.comparing(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElse(null);
                System.out.println(a);




    }
}
