package JavaCoolections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapInterface {
    public static void main(String[] args) {
        //syntax 
        Map<Integer,String> mp= new HashMap<>();
        //adding value in the hashmap
        mp.put(1, "Nitesh");
        mp.put(2, "Arvind");
        mp.put(3, "subu");
        mp.put(4, "Harsha");
        mp.put(5, "Manju");
        //getting value of the key from the hashmap
        System.out.println(mp.get(1));
        System.out.println(mp.get(2));
        System.out.println(mp.get(3));
        System.out.println(mp.get(6));
        //changing/updating value of the key in the hashmap
        mp.put(2, "Sai");//2-->Sai
        System.out.println(mp.get(2));
        //removing of a pair in the hashmap
        System.out.println(mp.remove(1));
        System.out.println(mp.remove(2,"Arvind"));
        //checking if a key is present in the hashmap
        System.out.println(mp.containsKey(1));//true
        System.out.println(mp.containsKey(3));//false
        //adding a new entry only if key doesn't exist already
        System.out.println(mp.putIfAbsent(1, "Abhishek"));//added because this key is not present in the hashmap
        System.out.println(mp.putIfAbsent(2,"Ganesh"));//not be added because it is already present in the hashmap
        System.out.println(mp);
        //getting all the keys of the hashmap
        System.out.println(mp.keySet());
        //getting all the values in the hashmap
        System.out.println(mp.values());
        //get all enteries in the hashmap
        System.out.println(mp.entrySet());
        //traversing all enteries of hashmap--->multiple method 
        for(Integer i:mp.keySet()){
            System.out.print(i+":"+mp.get(i)+"  ");
        }
        System.out.println();
        for(Entry<Integer, String> i:mp.entrySet()){
             System.out.print(i+" ");
        }
        System.out.println();
        for(var e:mp.entrySet()){
            System.out.print(e+" ");
        }
        
    }
}
