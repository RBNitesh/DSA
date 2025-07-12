package Array;

import java.util.Scanner;

public class sortanbinarystring {
    static void printArray(int [] arr){
        int i=0;
        while(i<arr.length){
            System.out.print(arr[i]+" ");
            i++;
        }
    }
    static int countzeroes(int [] arr){
        int count=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0){
                count++;
            }
        }
        return count;
    }
    static void sort(int[] arr){
       int n= countzeroes(arr);
       for(int i=0; i<arr.length; i++){
           if(i<n){
            arr[i]=0;
           }else{
            arr[i]=1;
           }
       }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the string: ");
        int size=sc.nextInt();
        int [] arr=new int[size];
        int i=0;
        System.out.println("Enter the string:");
        while(i<size){
            arr[i++]=sc.nextInt();
        }
        System.out.print("Original string: ");
        printArray(arr);
        sort(arr);
        System.out.print("\nString after sorting: ");
        printArray(arr);
    }
}
