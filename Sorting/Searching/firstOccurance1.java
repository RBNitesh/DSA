package Sorting.Searching;

import java.util.Scanner;

public class firstOccurance1 {
    static int binarySearch(int [] arr, int key){
        int l=0; int h=arr.length-1;
        int firstOccurance=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
        
            if(arr[mid]==key) {
                firstOccurance=mid;
                h=mid-1;
            }
            
            else if(arr[mid]<key) {
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return firstOccurance;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] arr={0,1,1,2,2,2,3,3,3,3,4,4,4,4,4,5,5,5,5,5,5};
        System.out.print("Enter the key:");
        int key=sc.nextInt();
        System.out.println(binarySearch(arr, key));
    }
}
