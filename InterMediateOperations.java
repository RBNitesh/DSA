import java.util.*;
import java.util.stream.Stream;

public class InterMediateOperations {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream
        // They are lazy, means they don't execute  until a terminal operation is invoked
        
        // 1.filter
        List<String> list = Arrays.asList("ram","swetha","johnty","sonam","preethi");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("s"));
        // no filtering at this point
        long res = filteredStream.count();
        System.out.println(res);

        // 2.map
        Stream<String> stringStream = list.stream().map(String :: toUpperCase);
        
        // 3.sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStream1 = list.stream().sorted((a, b) -> a.length()-b.length());

        // 4.distinct
        System.out.println(list.stream().filter(x -> x.startsWith("s")).distinct().count());

        // 5.limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(91).count());

        // 6.skip
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(91).count());
    }
}
