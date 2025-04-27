package Sorting.Searching;

import java.util.Scanner;

public class BinarySearch {
    static int binarySearch(int[] arr, int key, int l, int h){
        
            while(l<=h){
                int mid=(l+h)/2;
                if(arr[mid]==key) {return mid;}
                else if(arr[mid]<key) {
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
            return -1;
        }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,2,3,4,5,6,7,8,9};//Binary search can only be implement on sorted array.
        System.out.print("Enter  the key:");
        int key=sc.nextInt();
        int idx=binarySearch(arr,key,0,arr.length-1);
        if(idx==-1){
            System.out.println("Elements not found!");
        }else{
            System.out.println("Elements found at index: "+idx);
        }
    }
}
