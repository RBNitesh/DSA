package Array;

import java.util.Scanner;

public class SortEvenOdd {
    static void swap(int[] arr, int left, int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    static void sort(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(arr[left]%2!=0 && arr[right]%2==0){
                swap(arr,left,right);
                left++;
                right--;
            }
            if(arr[left]%2==0){
                left++;
            }
            if(arr[right]%2!=0){
                right--;
            }
        }
    }
    static void printArray(int [] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int size=sc.nextInt();
        int [] arr=new int[size];
        int i=0;
        System.out.println("Enter the "+size+" element:");
        while(i<size){
            arr[i++]=sc.nextInt();
        }
        System.out.print("Original array:");
        printArray(arr);
        sort(arr);
        System.out.print("\nArray after sorting: ");
        printArray(arr);
    
    }
}

