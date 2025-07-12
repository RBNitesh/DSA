package Recursion;

import java.util.Scanner;

public class searchElement {
    static int findMax(int [] arr, int n){
        if(n==1){
            return arr[n];
        }else{

            // int max=findMax(arr, idx+1);
            //return Math.max(arr[idx], findMax(arr, max))

            return Math.max(findMax(arr, n-1), arr[n]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr={23,44,5,3,23,6,22,23,55,2,};
        int max=findMax(arr , arr.length-1);
        System.out.println(max);
    }
}
