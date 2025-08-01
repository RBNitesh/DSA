import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("ram","swetha","johnty","sonam","preethi");

        Stream<String> stream = 
            names.stream().filter(name -> {
            System.out.println("Filtering: " +name);
            return name.length() > 3;
        });

        System.out.println("Before terminal operation ");

        List<String> result = stream.collect(Collectors.toList());
        System.out.println("After terminal operation");
        System.out.println(result);
    }
}
