import java.lang.foreign.UnionLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DayEight {

    public static void main(String[] args){

        // Input: String name = null;
        // Expected Output: Name not provided
        Optional<String> str = Optional.ofNullable(null);
        System.out.println(str.map(String::toUpperCase).orElse("No Name Present"));

        //Input: List<String> names = Arrays.asList("Sam", "Shane", "Alex", "Steve", "Jo");
        //Expected Output:
        //Shane
        //Steve
        Predicate<String> isStartWithS = s->s.startsWith("S") && s.length()>3;
        List<String> input2 = Arrays.asList("Sam", "Shane", "Alex", "Steve", "Jo");
        System.out.println(input2.stream()
                .filter(isStartWithS)
                .toList());

        //Input:List<String> input = Arrays.asList("Java", "Spring", "Boot");
        //Expected Output: [4, 6, 4]
        Function<String,Integer> isLength = String::length;
        List<String> input3 = Arrays.asList("Java", "Spring", "Boot");
        System.out.println(input3.stream()
                .map(isLength)
                .toList());

        //Input: List<String> emails = Arrays.asList("abc@gmail.com", "user@yahoo.com", "test@gmail.com");
        //Expected Output:
        //gmail.com
        //gmail.com
        List<String> input4 = Arrays.asList("abc@gmail.com", "user@yahoo.com", "test@gmail.com");
        Predicate<String> isEmail = s -> s.contains("@gmail.com");
        Function<String,String> isString = s-> s.substring(s.indexOf("@")+1);
        input4.stream()
                .filter(isEmail)
                .map(isString)
                .forEach(System.out::println);

        //Input: Optional<Integer> age = Optional.ofNullable(16);
        //Expected Output: Minor
        Optional<Integer> age = Optional.ofNullable(19);
        System.out.println(age.map(a -> a>=18 ? "Adult" : "minor")
                .orElse("no proper age"));

        //names = ["Alice", "Bob", "Charlie"]
        //Expected Output:
        //0: Alice
        //1: Bob
        //2: Charlie
        List<String> input5 = Arrays.asList("Alice", "Bob", "Charlie");
        BiFunction<Integer,String,String> index = (i,a) -> i +" : " + a;
        for(int i = 0 ;i<input5.toArray().length;i++){
            System.out.println(index.apply(i, input5.get(i)));
        }


        //input = "Sharath"
        //Expected Output: Hello, Sharath
        String input6 = "sharath";
        UnaryOperator<String> Helo = a -> "Hello " + a + " !";
        System.out.println(Helo.apply(input6));


    }
}
