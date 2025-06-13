import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwo {
    public static void main(String[] args) {

    //Remove zeros in array and add it in the last expected output 1293900
    int[] nums = {1,2,0,9,0,3,9};
    int index = 0;


        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length){
            nums[index++] =0;
        }
        for (int num : nums) {
            System.out.print(num);
        }

        //Flatten the list and return a list of all names:
        //Output: ["Alice", "Bob", "John", "Jane"]
        List<List<String>> names = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("John", "Jane")
        );
          List<String> output1 = names.stream()
                  .flatMap(n -> n.stream())
                  .toList();
          System.out.println(output1);

          // Split each sentence into words and return all words in a single list.
         //  Output: ["Java", "is", "great", "Streams", "are", "powerful"]
        List<String> sentences = Arrays.asList(
                "Java is great",
                "Streams are powerful"
        );
        List<String> output2 = sentences.stream()
                        .flatMap(n -> Arrays.stream(n.split(" ")))
                                .toList();
         System.out.println(output2);


        //Extract all unique characters from the list using flatMap().
        //Output: ["a", "p", "l", "e", "b", "n"]
        List<String> words = Arrays.asList("apple", "banana");
        List<String> output3 = words.stream()
                .flatMap(n-> Arrays.stream(n.split("")))
                .distinct()
                .toList();
        System.out.println(output3);

        //Use reduce() to return the sum:
        //Output: 15
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int output4 = numbers.stream()
                .reduce(0,(a,b)-> a+b);
        System.out.println(output4);



        //Use reduce() to return the longest string.
        //Output: "Spring"
        List<String> strings = Arrays.asList("Cartoon", "Spring", "Boot","hello","Cartoon");
        String output5 = strings.stream()
                .reduce("" ,(a,b)->a.length()>b.length() ? a:b);
        System.out.println(output5);


        //Use reduce() to return the product(*):
        //Output: 24
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4);
        int output6 = numbers2.stream()
                .reduce(1,(a,b)->a*b);
        System.out.println(output6);


        //Use reduce() to combine into:
        //Output: "Alice,Bob,Charlie"
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie");
        String output7 = names2.stream()
                .reduce((a, b)-> a +","+b)
                        .orElse("");
        String output8 = names2.stream()
                        .collect(Collectors.joining(","));
        System.out.println(output7);
        System.out.println(output8);

    }
}
