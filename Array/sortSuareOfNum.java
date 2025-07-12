package Array;

import java.util.Scanner;

public class sortSuareOfNum {
    static void reverse(int [] ans){
        int left=0;
        int right=ans.length-1;
        while(left<right){
           int temp=ans[left];
           ans[left]=ans[right];
           ans[right]=temp;
           left++;
           right--;
        }
    }

    static void swap(int []arr, int left, int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    static int[] sort(int []arr){
        int left=0;
        int right=arr.length-1;
        int[] ans=new int[arr.length];
        int k=0;
        while(left <= right){
            if(Math.abs(arr[left]) > Math.abs(arr[right])){
                ans[k]=arr[left]*arr[left];
                k++;
                left++;
            }
            else
            {
                ans[k]=arr[right]*arr[right];
                k++;
                right--;
            }
        }
        reverse(ans);
        return ans; 
    }
    static void printArray(int []arr){
        for (int i=0; i<arr.length; i++){
             System.out.print(arr[i]+" ");
        }
    }
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter the element in non decreasing order:");
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Original array:");
        printArray(arr);
        
        int [] ans=sort(arr);

        System.out.print("\nArray after sorting:");
        printArray(ans);
    }
}