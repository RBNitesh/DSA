package Recursion;
import java.math.*;
public class minimumCost {
    static int op1,op2;
    static int findMinCost(int[] arr , int curridx){

        if(curridx==arr.length-1) return 0;
        int op1 = findMinCost(arr, curridx+1)+Math.abs(arr[curridx]-arr[curridx+1]);
    
        if(curridx==arr.length-2) return op1;
        int op2 = findMinCost(arr, curridx+2)+Math.abs(arr[curridx]-arr[curridx+2]);
        
        return Math.min(op1, op2);
    }
    public static void main(String[] args) {
        int [] arr={10,40,30,20};
        int mincost=findMinCost(arr ,0);
        System.out.println(mincost);
    }
}
