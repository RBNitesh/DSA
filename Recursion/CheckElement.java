package Recursion;

import java.util.Scanner;

public class CheckElement {
    static void checkElement(int[] arr, int key, int n){
        if(n>arr.length-1){
           return;
        }
        else
        {
           if(arr[n]==key){
           System.out.print(n+" ");
           }
           checkElement(arr, key, n+1);
           return;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [] arr={2, 4, 6, 3, 0, 7, 4};
        System.out.print("Enter the key:");
        int key=sc.nextInt();
        checkElement(arr, key, 0);
    }
}