package StreamInJava;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println("Hello");
        });

        MathOperation sumOperation = (a, b) -> a+b;
        MathOperation subtractOperation = (a, b) -> a-b;
        int res1 = sumOperation.operate(1, 4);
        int res2 = subtractOperation.operate(5, 2);
        System.out.println(res1);
        System.out.println(res2);

        //Predicate --> Functional interface (Boolean valued function)
        Predicate<Integer> isEven = x -> x%2 == 0;
        System.out.println(isEven.test(4));

        Predicate<String> isStartsWithA = x -> x.startsWith("A");
        System.out.println(isStartsWithA.test("Ankit"));

        Predicate<String> isEndsWithT = x -> x.toUpperCase().endsWith("T");
        System.out.println(isEndsWithT.test("Ankit"));

        Predicate<String> and = isStartsWithA.and(isEndsWithT);
        System.out.println(and.test("Arya"));

        //Function --> work for you
        Function<Integer,Integer> doubleIt = x -> 2 * x;
        Function<Integer,Integer> tripleIt = x -> 3 * x;

        System.out.println(doubleIt.apply(25));

        int res = doubleIt.andThen(tripleIt).apply(12);
        System.out.println(res);

        //Identity
        Function<Integer,Integer> identity = Function.identity();
        System.out.println(identity.apply(5));

        //Consumer
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(7);

        List<Integer> list = Arrays.asList(2, 4, 7);
        Consumer<List<Integer>> printList = x -> {
            for(int item : x){
                System.out.println(item);
            }
        };
        printList.accept(list);

        //Supplier
        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());


        //BiPredicate, BiConsumer,  BiFunction
        BiPredicate<Integer, Integer> isEven2 = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isEven2.test(4, 5));

        BiConsumer<Integer,String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        BiFunction<String,String,Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("a", "bc"));

        //UnaryOperator, BinaryOperator
        UnaryOperator<Integer> unaryOperation = x -> x * 2;
        BinaryOperator<Integer> binaryOPeration = (x, y) -> x + y;

        //Method Reference --> Use method w/o invoking & in place of lambda expression
        List<String> names = Arrays.asList("ram", "shyam", "faiz");
        List<MobilePhone> mobilePhones = names.stream().map(MobilePhone :: new).collect(Collectors.toList());

        
    }
}

class MobilePhone{
    String name;

    public MobilePhone(String name){
        this.name = name;
    }
}

@FunctionalInterface
interface MathOperation{
    int operate(int a, int b);
}