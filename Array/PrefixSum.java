package Array;

import java.util.Scanner;

public class PrefixSum {
    static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int[] PrefixSumArr(int[] arr){
        int[] PreSum=new int[arr.length];
        PreSum[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            PreSum[i]=PreSum[i-1]+arr[i];
        }
      return PreSum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int n=sc.nextInt();
        int[] arr=new int [n];
        System.out.print("Enter the element of array:");
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Original array:");
        printArray(arr);
        
        int[] pref=PrefixSumArr(arr);
        System.out.print("\nPreSum array:");
        printArray(pref);

    } 
}
