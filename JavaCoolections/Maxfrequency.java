package JavaCoolections;
import java.security.KeyStore.Entry;
import java.util.*;
public class Maxfrequency {
    public static void main(String[] args) {
        int[] arr={0,-1,-2,7,6,-1};
        Map<Integer, Integer> freq = new HashMap<>();

        for(Integer e:arr){
            if(freq.containsKey(e)){
                freq.put(e, freq.get(e)+1);
            }else{
                freq.put(e, 1);
            }
        }
        System.out.println(freq.entrySet());

        //to print max frequency
        int maxfreq=0;
        for(var e:freq.entrySet()){
            if(e.getValue()>maxfreq){
                maxfreq=e.getValue();
            }
        }
        System.out.println(maxfreq);
    }
}


