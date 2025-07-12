package ArrayList;
import java.util.ArrayList;
import java.util.Iterator;

public class Main{
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("sfs");
        cars.add("zvz");
        cars.add("rgs");
        cars.add("sfs");
        System.out.println(cars.lastIndexOf("sfs"));
        ArrayList<String> Brand=new ArrayList<>();
        Brand.add("tata");
        Brand.add("Abc");
        Brand.add("bdf");
        System.out.println(cars.isEmpty());
        cars.addAll(Brand);
        System.out.println(cars);
        System.out.println(Brand);
        Brand.clear();
        System.out.println(Brand);
        ArrayList carsclone=(ArrayList)cars.clone();
        System.out.println(carsclone);
        System.out.println(cars.contains("BMW"));//return true or false
        Boolean b1=cars.contains("Abc");
        System.out.println(b1);
        System.out.println(cars.indexOf("Abc"));
        System.out.println(cars.get(cars.indexOf("Abc")));
        cars.ensureCapacity(15);
        System.out.println(cars.size());
        for(int i=cars.size(); i<15; i++){
           cars.add("car"+i);
        }
        System.out.println(cars);

        Iterator<String> it =cars.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach((n) -> { System.out.println(n*n);});
        ArrayList<Integer> num=(ArrayList) numbers.clone();
        numbers.remove(1);
        numbers.removeIf(n -> n%2==0);
        System.out.println(numbers);
        numbers.removeAll(numbers);
        System.out.println(numbers);
        System.out.println(num);
    }
}