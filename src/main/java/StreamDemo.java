import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        //forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        //map
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //get list of unique squares
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);
        //numbers.stream().map( i -> i*i).distinct().forEach(System.out::println);

        //filter
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //get count of empty string
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("count: " + count);

        //limit
        random.ints().limit(10).forEach(System.out::println);

        //sorted
        random.ints().limit(10).sorted().forEach(System.out::println);

        //Parallel Processing
        //get count of empty string
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("parallel processing count:" + count);

        //Collectors
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(" - "));
        System.out.println("Merged String: " + mergedString);

        //Statistics
        numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

    }
}
