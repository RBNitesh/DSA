package Sorting.Searching;

import java.util.Scanner;

public class RecursiveBinarySearch {
    static int recursiveBinarySearch(int[] arr, int key, int l, int h){
        
        while(l<=h){
        int mid=l+(h-l)/2;

        if(arr[mid]==key) return mid;

        else if(arr[mid]<key)
        return recursiveBinarySearch(arr, key, mid+1, h);

        else return recursiveBinarySearch(arr, key, l, mid-1);
    }
    return -1;
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,2,3,4,5,6,7};
        int n=arr.length;
        // System.out.print("Enter the keya elements:");
        // int key=sc.nextInt();
        for(int i=0; i<10; i++){
        int key=i;
        int idx=recursiveBinarySearch(arr,key,0,n-1);
        if(idx==-1){
            System.out.println("Elements "+key+" not found!");
        }else{
            System.out.println("Elements " +key+ " found at index: "+idx);
        }
      }
    }
}
