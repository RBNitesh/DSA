import java.util.HashSet;
public class Hashset {
    public static void main(String[] args){
        HashSet<Integer> set=new HashSet<>();
        //ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<=10; i++){
            set.add(i);
        }
        System.out.println(set);
        System.out.println(set.contains(1));
        System.out.println(set.contains(11));
        set.remove(5);
        System.out.println(set.clone());
        // set.clear();
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        // Integer[] arr=set.toArray(new Integer[9]);
        Object[] arr = set.toArray();
        for(var a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println(set.getClass());
        System.out.println(set.equals(set));
        
        System.out.println(list);
    }
}