import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class TerminationOperation {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // 1.collect
        System.out.println(list.stream().skip(1).collect(Collectors.toList()));
        System.out.println(list.stream().skip(1).toList());

        // 2.forEach
        list.stream().forEach(x -> System.out.println(x));

        // 3.reduce : Combines elements to produce a single result
        System.out.println(list.stream().reduce((a, b) -> a + b).get());
        System.out.println(list.stream().reduce(0, Integer :: sum));

        // 4. count


        // 5.anyMatch, allMatch, nonMatch
        boolean res1 = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(res1);

        boolean res2 = list.stream().allMatch(x -> x % 2 == 0);
        System.out.println(res2);

        boolean res3 = list.stream().noneMatch(x -> x < 0);
        System.out.println(res3);
        
        //findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // Example counting occurences of a character
        String word = "Hello World!";
        System.out.println(word.chars().filter(x -> x == 'l').count()); 

        //stateful and stateless
    }
}
