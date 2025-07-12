package JavaCoolections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInterfaceExample {
    public static void main(String[] args) {
        Map<String, Integer> mp = new LinkedHashMap<>();
        mp.put("Nitesh",1);
        mp.put("Subodh", 2);
        mp.put("Harsha", 3);
        mp.put("Subodh", 4);
        System.out.println(mp);
        System.out.println(mp.get("Nitesh"));
        System.out.println(mp.keySet());
        System.out.println(mp.values());

        for(Integer i: mp.values()){
            System.out.print(i+" ");
        }
        System.out.println();
        for(String i: mp.keySet()){
            System.out.print(i+" ");
        }
        System.out.println();
        for(var i:mp.keySet()){//no need to specify type
            System.out.print(i+" ");
        }
        System.out.println();
        for(var i:mp.values()){//here also no need to specify type
            System.out.print(i+" ");
        }
        System.out.println();
        for(var i: mp.entrySet()){
            System.out.print(i+" ");
        }
    }
}
