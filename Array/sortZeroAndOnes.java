package Array;

import java.util.Scanner;

public class sortZeroAndOnes{

    static void swap(int[] arr, int left, int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    static void sort(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(arr[left]==1 && arr[right]==0){
                swap(arr,left,right);
                left++;
                right--;
            }
            else if(arr[left]==0){
                left++;
            }
            else if(arr[right]==1){
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
