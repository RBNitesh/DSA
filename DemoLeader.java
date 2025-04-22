import java.util.*;

public class DemoLeader {
    static ArrayList<Integer> findLeader(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        int n=arr.length;
        int max=arr[n-1];
        for(int i=n-2; i>=0; i--){
            if(arr[i] > max){
                list.add(arr[i]);
                max=arr[i];
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr={73,14,54,64,33,25,53,4};
        ArrayList<Integer> list=findLeader(arr);
        System.out.println(list);
    }
}
