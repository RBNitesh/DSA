package StreamInJava;

import java.util.List;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // feature introduced in java 8
        // process collections of data in a functional and declarative manner
        // simplify data processing
        // embrace functional programming
        // improve readability and maintainability
        // enable easy parallelism
        
        // What is Stream?
        // A sequence of elements supporting functional and declarative programming

        // How to Use Streams?
        // Source, intermediate operations & terminal operation

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().filter(x -> x%2 == 0).count());

        //Creating Streams
        // 1.From Collections
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = list.stream();

        // 2.From Arrays
        String[] arr = {"ram", "shyam", "faiz", "john"};
        Stream<String> stream2 = Arrays.stream(arr);
        System.out.println(stream2.collect(Collectors.toList()));

        // 3.Using String.of()
        Stream<String> stream3 = Stream.of("a","b","c");
        System.out.println(stream3.collect(Collectors.toList()));
        
        //4.Infinite Streams
        Stream.generate(() -> 1).limit(100);
        Stream.iterate(1, x -> x+1).limit(30);
    }
}
